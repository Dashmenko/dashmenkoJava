/*
 * для создания массива объектов catalog. 
*  объект IndexGorod содержит букву, на которую начинаются города (в динамическом массиве strana)
*  начальный и конечный индексы в strana. например:  'А' , 0, 53 значит все города на 'А' расположенны с 0-го по
* 53-й индексы в strana
 */
package gorodagame;

public class IndexGorod {
    private final char litera;
    private final int beginIndex;
    private int endIndex;
    
    IndexGorod(char literaGorod, int beginIndexGorod) {
        litera = literaGorod;
        beginIndex = beginIndexGorod;
       
    } // end constructor
    
    char getLitera() { 
        return litera;
    }  // end getLitera
    
    int getBeginIndex() { 
        return beginIndex;
    }  // end getBeginIndex
    
    int getEndIndex() { 
        return endIndex;
    }  // end getEndIndex
    
    void setEndIndex(int endIndexGorod) { 
         endIndex = endIndexGorod;
    }  // end setEndIndex
} // end class
