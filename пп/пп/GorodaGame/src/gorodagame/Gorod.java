/*
 * ��� �������� �������� "Gorod", � ������������ ������ strana. 
*  ������: ������������ ������, ��������� ����� ����� (��� ������ ������) � ���� used, ������� ����������
* ���� �� ������������ �������� ������ � ���� (�� ���������, ��� �������� �������, false)
 */
package gorodagame;


public class Gorod {
    private String title;    // ��� ������, ��������, ���
    private  char asLinkDw = '@';  // '�' �� ������� ����
    private boolean used = false;
    
    Gorod(String titl){
        
         titl =  titl.replace('�', '�');   // � ����� ������ ������ ����
         titl =  titl.replace('�', '�');
         titl =  titl.replace('�', '�');
         titl =  titl.replace('�', '�');
        title = titl.toUpperCase();
        asLinkDw = title.toUpperCase().charAt(title.length() - 1);   
        
        // ���� ��������� ������ "�" ��� "�", ����� �������������
        if((asLinkDw == '�')||(asLinkDw =='�')){
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
