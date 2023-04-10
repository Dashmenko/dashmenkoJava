/*
 * ��������� ���� "������"
 */
package gorodagame;

import java.util.ArrayList;
import java.io.*;
import java.util.Random;



public class Game {
    
    private static final ArrayList<Gorod> strana = new ArrayList<>();  
    private static final ArrayList<IndexGorod> catalog = new ArrayList<>();   
   
    
// ##############################################################
     // strana ����������� ��������� gorod �� ���������������� ������ �����. ����� cities_ru.txt
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
        
         strana.remove(0);   // ��-�� ������-�� ������� ��� �������� �� �����
                                        // ���� � ����� �� ���������� ������ ������, �� ������ ����� �������� � ���������
                                        // ��������� ��������. ���� ��, ������ ������ ������� ������, �� ���� ��������� 
                                        // ������ ����� ��������, � ������� � ������� ������ strana.
         strana.trimToSize();
    } // end fillStrana
    
// ##############################################################
    // ����������� catalog ��������� IndexGorod,  ������� �  ��������� �������� gorod �� ������ strana
    // ��������:  0 <-- 'A' --> 52, �.�. ������ �� 'A' ����������� � strana � 0 �� 52 �������
    private static void fillIndexCatalog() {
        char tempLitera = '@';  // '@' �.�. ��� �������� ������ �� ���� ������ � ����� ������� ���-� ������ 'A'
        int i;
             
        // ��� ������ ������ ����� � ���-��� ������ �� �������� � tempLitera ��������� ������ 
        // IndexGorod � ���. ������������ ��� ����� � ������ ������ � strana
        for(Gorod gg: strana){
            if(gg.getFirstCharTitle() != tempLitera) {
                i = strana.indexOf(gg);                                // ������ Gorod � strana
                catalog.add( new IndexGorod(gg.getFirstCharTitle(), i));  // gg.getFirstCharTitle() ������ ����� ���. ������
                tempLitera = gg.getFirstCharTitle();             
            } // end if
         } // end for
                
       for(i = 0; i < catalog.size() - 2; i++) {
           catalog.get(i).setEndIndex(catalog.get(i + 1).getBeginIndex() - 1);                
       } // end for
       catalog.get(catalog.size() - 1).setEndIndex(strana.size() - 1);        
    } //  end  fillIndexCatalog

 // ##############################################################
    // ���� ������ ����� �� �������� ���� "������"
    // ��������: ���� "������", �������� "������"
    // ����� ������, ����� ��������� ��������������, �.�. ������ �� ��������
    private static String getAnswer(String quest) {
        int beginIndexGorod = 0, endIndexGorod = 1;
        String answer; 
        char  tempChar = quest.toUpperCase().charAt(quest.length() -1);
        
        // ���� ��������� ������ "�" ��� "�", ����� �������������
        if((tempChar == '�')||(tempChar =='�')){
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
                strana.get(i).setUsed();    // ��������� ����������� �������� ������
                return answer;
            } //  end if
        } // end for
        
        answer = "End";  // ������ END,  �.�. ��� �������� �������, �� �������� �����, �������������
        return answer;
    } // end getAnsver
    
// ##############################################################
    // ���� �� ����� ����� (��� ��������) � ������
    // ���� ����, �� ������ ��� ��� ��� �� ���������� (����� �������� ���)
    private static boolean getTrueGorod(String questGr) {
        int beginIndexGorod = 0, endIndexGorod = 1;
        boolean answer = false;
        final char  tempChar;
        
        questGr = questGr.replace('�', '�');
        questGr = questGr.replace('�', '�');
        questGr = questGr.toUpperCase();   //���� ������ � ������ �����, ������ �� �������
        tempChar = questGr.charAt(0);   // ������ ����� �������� ������
        
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
                strana.get(i).setUsed();   // ����� ���� ����� �� ���������� � ����
                 break;
            } //  end if
        } // end for
        
      if(!answer) {
          System.out.println("������ ������ ��� � ������ (������ ����� �� �����������), ���� �� ��� ����������� �����");  
         } // end if         
        
        return answer;
    } // end getTrueGorod
    
// ##############################################################
    // ��������� Gorod� � ������� strana (�.�. ��� ����������� ������������. �� ���) � 
    // �������� ����� �����
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
            tempTitl1 = strana.get(indGor.getBeginIndex() + i).getTitle();    // �� ������� ������� ����� �� ����� 
            tempLink1 = strana.get(indGor.getBeginIndex() + i).getLinkDw();
           
            tempTitl2 = strana.get(indGor.getBeginIndex() + mixer[i]).getTitle();  // �� ������� ������� ����� �� �����
            tempLink2 = strana.get(indGor.getBeginIndex() + mixer[i]).getLinkDw();
           
            strana.get(indGor.getBeginIndex() + i).setTitle(tempTitl2);       // � ������ ������ ����. �������
            strana.get(indGor.getBeginIndex() + i).setLinkDw(tempLink2);
          
            strana.get(indGor.getBeginIndex() + mixer[i]).setTitle(tempTitl1);
            strana.get(indGor.getBeginIndex() + mixer[i]).setLinkDw(tempLink1);   // ������� ���� ����. �������
        } // end for
        
    } // mixGorodaInLitera
// ##############################################################
    public static void main(String[] args) throws IOException {
        String enc = System.getProperty("file.encoding");     // � win cmd enc = "Cp866", ��� ������ ����� ���� 
       // System.out.println(enc);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "windows-1251"));   // � NetBeans ������ "windows-1251", � ��������� � UTF-8!!!
       // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out, enc));     // ������� ��� ������������ ��� Win cmd, ����������
        int i; // ������ �������
        String ss = "���";
        
        System.out.println("��������� ����� - " + ss);
        
        fillStrana("cities_ru.txt"); // ��� jar ����� ��������� ������ ���� � �����
        fillIndexCatalog();

        for(i = 0; i < catalog.size(); i++) {
            mixGorodaInLitera(catalog.get(i));
        } // end for
        
        // ������������������ ��� ��������� ��� ���� � ��������� ������ � IDE NetBeans!
       // �� ��� Win cmd ������� �� ���������� ��-�� ��������� � �����������
       // ######################################################################################
       //System.out.print("��� ������ ���! \n����� ������������ �������� ������� ������ (��� ��������)\n");
        
       // ss = br.readLine();
        i=0; 
        
        while(ss.compareTo("End") != 0 /*getTrueGorod(ss)*/) {
            System.out.println("---");     //  System.out.println("��� �����?");
           ss = getAnswer(ss);            // ss = br.readLine();
           System.out.println(ss);
           i++;
         } // end while 
        
        System.out.println("������� �������� " +i + " �������� �������");
    } // end main   
}
