import java.util.Comparator;

public interface Sort<T> //интерфейс для сортировок
{
    void sort(T[] arr, Comparator<T> comp);
}
