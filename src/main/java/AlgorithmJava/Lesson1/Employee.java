package AlgorithmJava.Lesson1;

import java.util.Objects;

public class Employee {
    private String name;
    private int salary;
    private String position;

    public Employee(String name, int salary, String position) {
        this.name = name;
        this.salary = salary;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, position);
    }

    public void showInfo(){
        System.out.printf("Name: %s; Salary: %s; Position: %s",this.name,this.salary,this.position);
    }
}
