/*
 * Реализует игру "Города"
 */
package gorodagame;

import java.util.ArrayList;
import java.io.*;
import java.util.Random;



public class Game {
    
    private static final ArrayList<Gorod> strana = new ArrayList<>();  
    private static final ArrayList<IndexGorod> catalog = new ArrayList<>();   
   
    
// ##############################################################
     // strana заполняется объектами gorod из отсортированного списка наход. файле cities_ru.txt
    private static void fillStrana(String fileName) {
        String S;
        
         try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            while ((S = reader.readLine()) != null) {
                strana.add(new Gorod(S));
            }  // end while
        }  // end try
        catch (IOException e) {
            System.out.println(e);
        }  // end catch
        
         strana.remove(0);   // из-за какого-то дефекта при загрузке из файла
                                        // если в файле не пропастить первую строку, то первое слово читается с невидимым
                                        // начальным символом. если же, первую строку сделать пустой, то этот невидимый 
                                        // символ будет прочитан, и помещен в нулевой объект strana.
         strana.trimToSize();
    } // end fillStrana
    
// ##############################################################
    // заполняется catalog объектами IndexGorod,  буквами и  индексами объектов gorod из списка strana
    // например:  0 <-- 'A' --> 52, т.е. города на 'A' расположены в strana с 0 по 52 позицию
    private static void fillIndexCatalog() {
        char tempLitera = '@';  // '@' т.к. нет названия города на этот символ и можно поймать нач-й индекс 'A'
        int i;
             
        // как только первая буква в наз-нии города не совпадет с tempLitera создается объект 
        // IndexGorod в кот. записывается эта буква и индекс города в strana
        for(Gorod gg: strana){
            if(gg.getFirstCharTitle() != tempLitera) {
                i = strana.indexOf(gg);                                // индекс Gorod в strana
                catalog.add( new IndexGorod(gg.getFirstCharTitle(), i));  // gg.getFirstCharTitle() первая буква наз. города
                tempLitera = gg.getFirstCharTitle();             
            } // end if
         } // end for
                
       for(i = 0; i < catalog.size() - 2; i++) {
           catalog.get(i).setEndIndex(catalog.get(i + 1).getBeginIndex() - 1);                
       } // end for
       catalog.get(catalog.size() - 1).setEndIndex(strana.size() - 1);        
    } //  end  fillIndexCatalog

 // ##############################################################
    // дает верный ответ по правилам игры "Города"
    // например: даем "Москва", получаем "Абакан"
    // после выдачи, город считается использованным, т.е. больше не выдается
    private static String getAnswer(String quest) {
        int beginIndexGorod = 0, endIndexGorod = 1;
        String answer; 
        char  tempChar = quest.toUpperCase().charAt(quest.length() -1);
        
        // если последний символ "Ь" или "Ы", берем предпоследний
        if((tempChar == 'Ь')||(tempChar =='Ы')){
             tempChar = quest.toUpperCase().charAt(quest.length() - 2);
        } // end if
        
        for(IndexGorod indG: catalog) {
            if(indG.getLitera() == tempChar) {
                beginIndexGorod = indG.getBeginIndex();
                endIndexGorod = indG.getEndIndex();
                break;
            } // end if
        } // end for
        
        for(int i = beginIndexGorod; i < endIndexGorod +1; i++) {
            if(!strana.get(i).getUsed()) {
                answer = strana.get(i).getTitle();
                strana.get(i).setUsed();    // компьютер использовал название города
                return answer;
            } //  end if
        } // end for
        
        answer = "End";  // значит END,  т.е. все названия городов, на заданную букву, использованны
        return answer;
    } // end getAnsver
    
// ##############################################################
    // есть ли такой город (его название) в России
    // если есть, то второй раз его уже не используют (игрок применил его)
    private static boolean getTrueGorod(String questGr) {
        int beginIndexGorod = 0, endIndexGorod = 1;
        boolean answer = false;
        final char  tempChar;
        
        questGr = questGr.replace('й', 'и');
        questGr = questGr.replace('ё', 'е');
        questGr = questGr.toUpperCase();   //если начало с мелкой буквы, замена ее большой
        tempChar = questGr.charAt(0);   // первая буква названия города
        
        for(IndexGorod indG: catalog) {
            if(indG.getLitera() == tempChar) {
                beginIndexGorod = indG.getBeginIndex();
                endIndexGorod = indG.getEndIndex();
                break;
            } // end if
        } // end for
        
        for(int i = beginIndexGorod; i < endIndexGorod +1; i++) {
            if((!strana.get(i).getUsed()) && (strana.get(i).getTitle().compareTo(questGr) == 0)) {
                answer = true;
                strana.get(i).setUsed();   // далее этот город не учавствует в игре
                 break;
            } //  end if
        } // end for
        
      if(!answer) {
          System.out.println("Такого города нет в России (города крыма не учитываются), либо он уже использован ранее");  
         } // end if         
        
        return answer;
    } // end getTrueGorod
    
// ##############################################################
    // смешивает Gorodа в массиве strana (т.к. они загружаются отсортирован. по абв) в 
    // пределах одной буквы
    private static void mixGorodaInLitera(IndexGorod indGor) {
        int limitArr;
        limitArr = indGor.getEndIndex() - indGor.getBeginIndex();
        int i, mixer [];
        if(limitArr < 3) {
            return;
        } // end if
        mixer = new int[limitArr];
        Random randGen = new Random(); // random generator
        String tempTitl1, tempTitl2;
        char tempLink1, tempLink2;
        
        for(i=0; i < limitArr; i++) {
            mixer[i] = randGen.nextInt(limitArr);
        } // end for
        
        for(i=0; i < limitArr; i++) {
            tempTitl1 = strana.get(indGor.getBeginIndex() + i).getTitle();    // из первого объекта берем зн полей 
            tempLink1 = strana.get(indGor.getBeginIndex() + i).getLinkDw();
           
            tempTitl2 = strana.get(indGor.getBeginIndex() + mixer[i]).getTitle();  // из первого объекта берем зн полей
            tempLink2 = strana.get(indGor.getBeginIndex() + mixer[i]).getLinkDw();
           
            strana.get(indGor.getBeginIndex() + i).setTitle(tempTitl2);       // в первый ставим знач. второго
            strana.get(indGor.getBeginIndex() + i).setLinkDw(tempLink2);
          
            strana.get(indGor.getBeginIndex() + mixer[i]).setTitle(tempTitl1);
            strana.get(indGor.getBeginIndex() + mixer[i]).setLinkDw(tempLink1);   // второму даем знач. первого
        } // end for
        
    } // mixGorodaInLitera
// ##############################################################
    public static void main(String[] args) throws IOException {
        String enc = System.getProperty("file.encoding");     // в win cmd enc = "Cp866", для чтения русск букв 
       // System.out.println(enc);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "windows-1251"));   // в NetBeans читает "windows-1251", а сохраняет в UTF-8!!!
       // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, enc));     // пытался его использовать для Win cmd, безуспешно
        int i; // просто счетчик
        String ss = "оса";
        
        System.out.println("Начальный город - " + ss);
        
        fillStrana("cities_ru.txt"); // для jar нужно указывать полный путь к файлу
        fillIndexCatalog();

        for(i = 0; i < catalog.size(); i++) {
            mixGorodaInLitera(catalog.get(i));
        } // end for
        
        // закомментированный код применять для игры с человеком только в IDE NetBeans!
       // из под Win cmd сделать не получилось из-за заморочек с кодировками
       // ######################################################################################
       //System.out.print("Ваш первый ход! \nМожно использовать названия городов России (без крымских)\n");
        
       // ss = br.readLine();
        i=0; 
        
        while(ss.compareTo("End") != 0 /*getTrueGorod(ss)*/) {
            System.out.println("---");     //  System.out.println("Ваш город?");
           ss = getAnswer(ss);            // ss = br.readLine();
           System.out.println(ss);
           i++;
         } // end while 
        
        System.out.println("Цепочка содержит " +i + " названий городов");
    } // end main   
}
