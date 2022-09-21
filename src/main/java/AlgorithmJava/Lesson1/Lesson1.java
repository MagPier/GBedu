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


import java.util.*;

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
            if (workers[i].getSalary() >= l1.primitive[i]) {
                System.out.println("���������� " + i + " ������ �������� �");
                workers[i].showInfo();
                System.out.println();
            }

        }

        long time = ((System.nanoTime() - timeStart));
        System.out.println("����� ���������� 1 ������� ��: " + time);

//        ������� 2.1
//        �� ������ ������������ ���� �� ��������� ������� �1 ���������� ������ �� ������ ������������ ����������� ��� ��������� ����� ������.

        long timeStart2 = System.nanoTime();
        int[] primitivePart2 = new int[]{6, 5, 4, 3, 2, 1};
        int[] copyArray = new int[6];
        copyArray = Arrays.copyOf(primitivePart2, primitivePart2.length);
        Arrays.sort(copyArray);
        int find = Arrays.binarySearch(copyArray, 4);
        System.out.println(find);
        long time2 = ((System.nanoTime() - timeStart2));
        System.out.println("����� ���������� 2.1 ������� ��: " + time2);

//        ������� 2.2
//        �� ������ ����������� ���� � ������� 2.1 ���������� �������� � �������� �����.
//        ������� ��������� ��������� � ��������� ������ � ������� �������� ������ System.nanoTime(), ��� ������������� ��������� ��� ������������ ������ ������.


        int[] array = new int[400];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long timeStart3 = System.nanoTime();
        int binarySearch = Arrays.binarySearch(array, 300);
        long time3 = ((System.nanoTime() - timeStart3));
        System.out.println("����� ���������� ��������� ������ ��: " + time3);
        long timeStart4 = System.nanoTime();
        int linerSearch;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 300) {
                linerSearch = i;
            }
        }
        long time4 = ((System.nanoTime() - timeStart3));
        System.out.println("����� ���������� ��������� ������ ��: " + time4);


//        ������� 2.3
//
//        �������� ������ �������� 400 ���������.
//                ��������� ���������� � ������� ������ sort().
//                ������� ���������� � ������� �������� ������ System.nanoTime().
        int[] array2 = new int[400];
        Random rnd = new Random();
        for (int i = 1; i < array2.length; i++) {
            int j = rnd.nextInt(i);
            array2[i] = j;
        }
        long timeStart5 = System.nanoTime();
        int[] array3 = Arrays.copyOf(array2, array2.length);
        int[] array4 = Arrays.copyOf(array2, array2.length);
        int[] array5 = Arrays.copyOf(array2, array2.length);
        Arrays.sort(array3);
        // System.out.println(Arrays.toString(array3));
        long time5 = ((System.nanoTime() - timeStart5));
        System.out.println("����� ���������� ���������� ��: " + time5);
//        ������� 2.4
//        �� ������ ������������� ������� ������ �� ������� 2.3 ���������� �������� ���������� ���������.
//        ������� ���������� � ������� �������� ������ System.nanoTime().
        long timeStart6 = System.nanoTime();

        for (int i = 0; i < array2.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array2[j - 1] > array2[j]) {
                    int tmp = array2[j - 1];
                    array2[j - 1] = array2[j];
                    array2[j] = tmp;
                }
            }
        }
        // System.out.println(Arrays.toString(array2));
        long time6 = ((System.nanoTime() - timeStart6));
        System.out.println("����� ���������� ����������� ���������� ��: " + time6);
// ���������� ������� Arrays.sort ������� ~ � 4 ���� ��� 400 ���������.


//        ������� 2.5
//        �� ������ ������� ������ �� ������� 2.3 ���������� �������� ���������� ������� ������.
//                ������� ���������� � ������� �������� ������ System.nanoTime().
//                �������� � �������� ���������� ���������� ���������� �� ������� ������� 2.3 � 2.4.
        long timeStart7 = System.nanoTime();

        for (int i = 0; i < array4.length; i++) {
            int pos = i;
            int min = array4[i];

            for (int j = i + 1; j < array4.length; j++) {
                if (array4[j] < min) {
                    pos = j;
                    min = array4[j];
                }
            }
            array4[pos] = array4[i];
            array4[i] = min;
        }
        //   System.out.println(Arrays.toString(array4));
        long time7 = ((System.nanoTime() - timeStart7));
        System.out.println("����� ���������� ���������� ������� ������ ��: " + time7);

        // ������ ���������� ������� ������ � 1.7 ���� ������, ��� ����������� ������� ��� 400 ���������.

//        ������� 2.6
//        �� ������ ������� ������ �� ������� 2.3 ���������� �������� ���������� ������� �������.
//                ������� ���������� � ������� �������� ������ System.nanoTime().
//                �������� � �������� ���������� ���������� ���������� �� ������� ������� 2.3, 2.4 � 2.5.
        long timeStart8 = System.nanoTime();
        for (int left = 0; left < array5.length; left++) {
            int value = array5[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array5[i]) {
                    array5[i + 1] = array5[i];
                } else {
                    break;
                }
            }
            array5[i + 1] = value;
        }
        //  System.out.println(Arrays.toString(array5));
        long time8 = ((System.nanoTime() - timeStart8));
        System.out.println("����� ���������� ���������� ������� ������� ��: " + time8);
        // ����� ���������� ���������� ������� ������� � 2 ���� ������ ��� ��������� ������� �������

//        ������� 3.1
//        �� ������ ������� �� ��������� ������� 2.1 ���������� ������� ������ � ���������.
//                ������� ����� ���������� ��������������.
        long timeStart9 = System.nanoTime();
        LinkedList list = new LinkedList();
        for (int i : array5) {
            list.add(i);

        }
        System.out.println();
        long time9 = ((System.nanoTime() - timeStart9));
        System.out.println("����� ���������� ���������� ������ ��: " + time9);

//    ������� 3.4
//�� ������ ������ �� ������� 3.1 ���������� ������� ������������ ������ � ��� ������� ������.
//���������� ������ ����������� ��������� �� ������ ������ �� ������� 1.3

        DoublyLinkedList<Employee> dlink = new DoublyLinkedList();
        for (Employee emp:workers){
            dlink.add(emp,1);
        }

//        ������� 3.5
//        ���������� �������� �� ������ ��������� ������� �� ������� 3.4 � ��������� ������� �������� ���������.
//                ������� ����� ���������� �������� � ������� �������� ������ System.nanoTime()
//
      Iterator iter = list.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}



class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public static <T> LinkedList<T> newEmptyList() {
        return new LinkedList<T>();
    }

    protected LinkedList() {
        head = null;
        tail = null;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> currentNode;

        public ListIterator(Node<T> head) {
            currentNode = head;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (currentNode == null) {
                throw new NoSuchElementException();
            }
            T value = currentNode.getValue();
            currentNode = currentNode.getNext();
            return value;
        }

        @Override
        public void remove() {
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(head);
    }
}
class Node<T> {
    private final T value;
    private Node next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
