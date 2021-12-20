/**
 * Java 1/ Lesson 5
 * Class determinate for object employee
 *
 * @author Melnev Dmitry
 * @version 2021-12-20
 */
package lesson5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;
    private int yearOfBirth; //сверх задания, просто хотел испытать статический метод и поле

    private static int currentYear = 0;


    Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

        yearOfBirth = (currentYear > 0) ? currentYear - age : 0;
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

    public static void setCurrentYear(int year) {
        if (year > 1900 && year < 2100)
            currentYear = year;
    }

    public void setFullName(String fullName) {
        if (fullName.equals(fullName.replaceAll("[^a-zA-Zа-яА-ЯёЁ ]", "")))//тест работы с регулярными выражениями.
            this.fullName = fullName;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 99) {
            this.age = age;
            yearOfBirth = (currentYear > 0) ? currentYear - age : 0;
        }
    }

    public void setPosition(String position) {
        if (position.equals(position.replaceAll("[^a-zA-Zа-яА-ЯёЁ -]", "")))
            this.position = position;
    }

    public void setEmail(String email) {
        if (email.equals(email.replaceAll("[^a-z0-9_.\\-@]", ""))) //должно быть иначе, но пока так.
            this.email = email;
    }

    public void setPhone(String phone) {
        if (phone.equals(phone.replaceAll("[^0-9-()+ ]", "")))
            this.phone = phone;
    }

    public void setSalary(int salary) {
        if (salary >= 0.0 && salary <= 1000000.0)
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

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
