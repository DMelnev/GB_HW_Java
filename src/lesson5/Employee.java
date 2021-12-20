/**
 * Java 1/ Lesson 5
 * Class determinate for object employee
 *
 * @author Melnev Dmitry
 * @version 2021-12-
 */
package lesson5;

import java.util.Objects;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;
    private int yearOfBirth;

    private static int currentYear = 0;


    Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

        yearOfBirth = (currentYear > 0) ? currentYear - this.age : 0;
    }

    @Override
    public String toString() {
        return String.format("Employer name: %s\n" +
                        "year of birth: %d, age: %d\n" +
                        "phone number: %s,\n" +
                        "email: %s\n" +
                        "position: %s,\n" +
                        "salary: %,.2f\n",
                fullName,
                yearOfBirth,
                age,
                phone,
                email,
                position,
                salary);
    }


//        System.out.printf("Employer name: %s,\nyear of birth: %d, age: %d\n" +
//                        "phone number: %s,\nemail: %s\n" +
//                        "position: %s,\nsalary: %,.2f\n",
//                fullName,
//                yearOfBirth,
//                age,
//                phone,
//                email,
//                position,
//                salary);
//    }

    static void setCurrentYear(int year) {
        currentYear = year;
    }

    public void setFullName(String fullName) {
        if (fullName.equals(fullName.replaceAll("[^a-zA-Zа-яА-ЯёЁ ]", ""))){
            this.fullName = fullName;
        };

    }

    public void setAge(int age) {

        this.age = age;
        yearOfBirth = (currentYear > 0) ? currentYear - this.age : 0;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
