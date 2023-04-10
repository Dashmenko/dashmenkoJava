/*
 * для создания объектов "Gorod", в динамическом списке strana. 
*  хранит: наименование города, последнюю букву имени (для поиска ответа) и поле used, которое показывает
* было ли использовано название города в игре (по умолчанию, при создании объекта, false)
 */
package gorodagame;


public class Gorod {
    private String title;    // имя города, например, Уфа
    private  char asLinkDw = '@';  // 'А' из примера выше
    private boolean used = false;
    
    Gorod(String titl){
        
         titl =  titl.replace('й', 'и');   // в имени города замена букв
         titl =  titl.replace('Й', 'И');
         titl =  titl.replace('ё', 'е');
         titl =  titl.replace('Ё', 'Е');
        title = titl.toUpperCase();
        asLinkDw = title.toUpperCase().charAt(title.length() - 1);   
        
        // если последний символ "Ь" или "Ы", берем предпоследний
        if((asLinkDw == 'Ь')||(asLinkDw =='Ы')){
             asLinkDw = title.toUpperCase().charAt(title.length() - 2);
        } // end if
        
    } // end Gorod

    char getFirstCharTitle() {
        return title.charAt(0);
    } // end getFirstCharTitle   
    
    void setTitle(String newTitl) {
        title = newTitl;
    } // end getFirstCharTitle   
    
    String getTitle() {
        return title;
    } // end getFirstCharTitle   
    
    void setLinkDw(char newLinkDw) {
        asLinkDw = newLinkDw;
    } // end setLinkDw
    
    char getLinkDw() {
        return asLinkDw;
    } // end getLinkDw
    
    boolean getUsed(){
        return used;
    } // end Used
    
    void setUsed(){
         used = true;
    } // end Used
   
     void resetUsed(){
         if(used)
            used = false;
    } // end setUsed
} // end class
