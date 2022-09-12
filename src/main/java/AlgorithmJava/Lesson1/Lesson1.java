package AlgorithmJava.Lesson1;

// ������� 1.1
//��������� ������ ���������� � �������� ������ �� �����.
// - ������������ ������� � ����������� �����;
// - ���������� ������� ������������;
// - ������ ����� �� �����;
// - ������ �������.
//------------------------------------------
// ������� 1.2
// �������� ������ ���������� � �������� ������ � ����������������.
// - ��� ���� ����������, ����� ����������;
// - �������, �����, �������, �������, �����, �������.
//-----------------------------------------


import java.util.Arrays;

//������� 1.3
//�������� ����������� ���, � ������� ��� ������ �������� ������ � ���������� ���� ����� ������: ���������, ����������� � ������ ������ �����������: ����������� � ����� ����������� ������.
//�������� ���������� ������.
//������� 1.4
//��������� ���������� ��� ���������� ����� ������ � ������ ����������, ������ ��� ������ ����������� ���������� ����� ���������.
//������� ����� ���������� ��������� � ������� �������� ������ System.nanoTime().
public class Lesson1 {
    int[] primitive = new int[]{6, 5, 4, 3, 2, 1};
    String[] text = new String[]{"one", "two", "thee", "four", "five", "six"};


    public static void main(String[] args) {
       long timeStart = System.nanoTime();
        Lesson1 l1 = new Lesson1();

        Employee emp1 = new Employee("Valera", 1, "PR");
        Employee emp2 = new Employee("Ivan", 2, "PR");
        Employee emp3 = new Employee("Sveta", 3, "PR");
        Employee emp4 = new Employee("Masha", 4, "IT");
        Employee emp5 = new Employee("Jenya", 5, "IT");
        Employee emp6 = new Employee("Artem", 6, "IT");
        Employee[] workers = new Employee[]{emp1, emp2, emp3, emp4, emp5, emp6};

        System.out.println("����������� ����:");
        System.out.println(Arrays.toString(l1.primitive));
        System.out.println("��������� ����:");
        System.out.println(Arrays.toString(l1.text));
        System.out.println("����������� ���:");
//        for (Employee worker : workers) {
//            worker.showInfo();
//        }
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].getSalary()>=l1.primitive[i]){
                System.out.println("���������� " +i+" ������ �������� �");
                workers[i].showInfo();
                System.out.println();
            }

        }

        long time = ((System.nanoTime() - timeStart));
        System.out.println("����� ���������� ��: "+ time);


    }


}
