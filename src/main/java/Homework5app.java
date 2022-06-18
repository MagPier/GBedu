public class Homework5app {

}

class Employee{
    private String fullName;
    private String position;
    private String eMail;
    private String phone;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String eMail, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Employee{" +"fullName: "+this.fullName+
                ", position:'" + this.position + '\'' +
                ", eMail:'" + this.eMail + '\'' +
                ", phone:" + this.phone +
                ", salary:" + this.salary +
                ", age:" + this.age +
                '}');
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("Petrov Ivan Nikolayevich", "HR","petrov@mail.ru","999-999-999",999.99,40);
        Employee emp2 = new Employee("Sidorov Ivan Nikolayevich", "PR","sidirod@mail.ru","888-999-999",999.99,39);
        Employee emp3 = new Employee("Ivanov Ivan Nikolayevich", "UR","ivenov@mail.ru","777-999-999",899.99,45);
        Employee emp4 = new Employee("Kozlov Ivan Nikolayevich", "Director","kozlov@mail.ru","666-999-999",9999.99,55);
        Employee emp5 = new Employee("Maltcev Ivan Nikolayevich", "SUV","maltcev@mail.ru","555-999-999",1999.99,46);
        Employee[] staff = {emp1,emp2,emp3,emp4,emp5};
        for (Employee e:staff){
            if (e.age >40){
                e.printInfo();
            }
        }

    }
}
