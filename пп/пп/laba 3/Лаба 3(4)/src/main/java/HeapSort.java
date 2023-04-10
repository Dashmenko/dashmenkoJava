import java.util.Comparator;

public class HeapSort<T> implements Sort<T> //создание класса, принимающий любой тип
{

    @Override
    public void sort(T[] array, Comparator<T> comp) //алгоритм пирамидальной сортировки
    {
        for (int i = (array.length - 2) / 2; i >= 0; i--)
            heapify( array , i , array.length - 1,comp );

        for (int i = array.length - 1; i > 0; i--) {
            swapKeys( array , 0 , i,comp );
            heapify(array , 0 , i - 1, comp);
        }
    }
    private void heapify(T[] array, int i, int m, Comparator<T> comp) {
        int j;
        while ( 2 * i + 1 <= m ) {
            j = 2 * i + 1;
            if ( j < m ) {
                // if ( 0 > array[ j ] < array[ j + 1 ] )
                if(0> comp.compare(array[j],array[j+1]))
                    j++;
            }
            if (0> comp.compare(array[i],array[j])) {
                swapKeys( array , i , j,comp );
                i = j;
            } else
                i = m;
        }
    }

    public void swapKeys(T[] array, int i, int j,Comparator<T> comp) {
        T temp;
        temp = array[ i ];
        array[ i ] = array[ j ];
        array[ j ] = temp;
    }
}
