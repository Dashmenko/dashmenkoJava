import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("������� ����� �������� �����: ");
        int N = in.nextInt();
        int[] mas = new int[N];
        System.out.print("������� ������� �����: ");
        for (int i = 0; i < N; i++)
        {
            mas[i]=in.nextInt();
        }

        Mas ans = new Mas(mas, N);
        System.out.println("����������� �����: " + ans.getMin());
        System.out.print(ans.getAns());
    }
}
