import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class Main {

    //������ ���������� �������� �������
    Object[] headers = { "���������", "�����", "����", "����", "�����" };

    //������ ���������� ���������� ��� �������
    Object[][] data = {
            { "���������", "���1", "�����", "19.01.2021", "20:00:00" },
            { "���", "���2", "�����", "19.01.2021", "21:00:00"  },
            { "�����������", "���3", "�������", "19.01.2021", "20:30:00"   },
            { "�������", "�����", "�����" , "19.01.2021", "12:00:00"  },
            { "���", "��� � �������", "�����", "19.01.2021", "10:00:00"   },
            { "���2", "���������", "�����", "19.01.2021", "17:00:00"   },
    };

    //������ �������
    JTable jTabPeople;

    Main() {
        //������� ����� ��������� JFrame
        JFrame jfrm = new JFrame("JTableExample");
        //������������� ��������� ����������
        jfrm.getContentPane().setLayout(new FlowLayout());
        //������������� ������ ����
        jfrm.setSize(450, 200);
        //������������� ���������� ��������� ��� �������� ����
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //������� ����� ������� �� ������ ���������� ������� ������ � ����������
        jTabPeople = new JTable(data, headers);
        //������� ������ ��������� � �������� � �� ������ ���� �������
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
        //������������ ������� �������������� �������
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(400, 100));
        //��������� � ��������� ���� ������ �������� � ������� ������ � ���
        jfrm.getContentPane().add(jscrlp);
        //���������� ���������
        jfrm.setVisible(true);
    }

    //������� main, ������������� ��� ������ ����������
    public static void main(String[] args) {
        //������� ����� � ������ ��������� �������
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}