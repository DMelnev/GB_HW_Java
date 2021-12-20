/**
 * Java 1/ Lesson 5
 *
 * @author Melnev Dmitry
 * @version 2021-12-20
 */
package lesson5;

import java.util.Calendar;

public class HomeWorkApp {
    Calendar date = Calendar.getInstance();

    public static void main(String[] args) {
        HomeWorkApp process = new HomeWorkApp();
        process.run();
    }

    void run() {

        Employee.setCurrentYear(date.get(Calendar.YEAR)); //в статическое поле пишем текущий год

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivan Ivanov",
                "director", "asd@asd.ru", "+7900 900 00 00", 150000.0, 48);
        employees[1] = new Employee("Petr Petrov",
                "manager", "qwe@asd.ru", "+7900 900 00 01", 130000.0, 32);
        employees[2] = new Employee("Sidor Sidorov",
                "lawer", "zxc@asd.ru", "+7900 900 00 02", 120000.0, 41);
        employees[3] = new Employee("Dmitriy Dmitryev",
                "accountant", "fgh@asd.ru", "+7900 900 00 03", 100000.0, 52);
        employees[4] = new Employee("Alexandr Alexandrov",
                "engineer", "rty@asd.ru", "+7900 900 00 04", 25000.0, 41);

        for (Employee prsn : employees) {
            if (prsn.getAge() > 40) {
                System.out.println(prsn);
            }
        }
    }
}
