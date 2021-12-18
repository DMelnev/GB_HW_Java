/**
 * Class determinate for object employee
 *
 * @author Melnev Dmitry
 * @version 2021-12-
 */
package lesson5;

import java.util.Calendar;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;
    private int yearOfBirth;
    static int currentYear = 0;


    Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

        yearOfBirth = (currentYear > 0) ? currentYear - this.age : 0;
    }

    void printInfo() {
        System.out.printf("Employer name: %s,\nyear of birth: %d, age: %d\n" +
                        "phone number: %s,\nemail: %s\n" +
                        "position: %s,\nsalary: %,.2f\n",
                fullName, yearOfBirth, age,
                phone, email,
                position, salary);
    }

    static void setCurrentYear(int year) {
        currentYear = year;
    }
    void setFullName(String name){
        fullName = name;
    }
    void setAge(int age){
        this.age = age;
        yearOfBirth = (currentYear > 0) ? currentYear - this.age : 0;
    }
    void setPosition(String position){
        this.position = position;
    }
    void setEmail(String email){

    }

    int getYearOfBirth() {
        return yearOfBirth;
    }
}
