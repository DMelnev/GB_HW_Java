/**
 *
 * Class determinate for object employee
 *
 * @author Melnev Dmitry
 * @version 2021-12-
 *
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
    Employee(String fullName, String position, String email, String phone, double salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

        Calendar date = Calendar.getInstance();
        yearOfBirth = date.get(Calendar.YEAR);
    }
}
