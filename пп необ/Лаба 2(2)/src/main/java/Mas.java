import java.util.ArrayList;

public class Mas
{
    private final int[] mas;
    private int N;
    private int min_sum=0;
    private final ArrayList<Integer> answer = new ArrayList<>();


    Mas(int[] mas, int N)
    {
        this.mas = mas;
        this.N=N;
    }

    public  double getMin()
    {
        for (int i = 2; i < N; i++)
        {
            min_sum += Math.min(mas[i - 1], mas[i - 2]);
        }
        return min_sum;
    }

    public  ArrayList<Integer> getAns()
    {
        int index;
        do
        {
            if (Math.min(mas[N - 1], mas[N - 2]) == mas[N - 1])
                index = N - 1;
            else
                index = N - 2;

            answer.add(0, index + 1);
            N = index;
        } while (N != 1 && N != 0);
        return answer;
    }
}
