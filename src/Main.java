//Привет, приятно познакомиться!
import java.util.Scanner;

// Класс содержит метод main, который является точкой входа в приложение
// Отвечает за вывод меню приложения на экран и взаимодействие с пользователем
public class Main {
    public static void main(String[] args) {

        int userInput;
        int dayNumber;
        int monthNumber;
        int steps;
        String message;
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        printMenu();
        userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput ==1) {
                message = "Введите номер месяца, в котором вы хотите внести количество пройденных шагов";
                monthNumber = readNumberInRange(scanner,message, 1, 12);
                message = "Введите номер дня месяца, в котором вы хотите внести количество пройденных шагов";
                dayNumber = readNumberInRange(scanner, message, 1, 30);
                message = "Введите количество пройденных шагов";
                steps = readNonNegativeNumber(scanner, message);
                stepTracker.setStepsOnDate(monthNumber, dayNumber, steps);
            } else if (userInput ==2) {
                message = "Введите номер месяца, за который вы хотите увидеть статистику";
                monthNumber = readNumberInRange(scanner, message, 1, 12);
                stepTracker.showStatisticsOnMonth(monthNumber);
            } else if (userInput ==3) {
                message = "Введите новую цель по количеству шагов за день";
                steps = readNonNegativeNumber(scanner, message);
                stepTracker.setStepsGoal(steps);
            } else System.out.println("Неверный ввод: такого пункта в меню нет. Попробуйте снова");
            printMenu();
            userInput = scanner.nextInt();
        }
    }

    // выводит на экран меню управления счетчиком шагов
    public static void printMenu() {
        System.out.println("МЕНЮ");
        System.out.println("1. Ввести количество шагов за определенный день");
        System.out.println("2. Напечатать статистику за определенный месяц");
        System.out.println("3. Изменить цель по количеству шагов за день");
        System.out.println("0. Выход");
        System.out.print("Введите номер команды ");
    }

    // выводит на экран сообщение message и считывает целое число в интервале от leftBorder до rightBorder включительно
    public static int readNumberInRange(Scanner scanner, String message, int leftBorder, int rightBorder) {
        System.out.print(message + " ");
        int input;
        while (true) {
            input = scanner.nextInt();
            if (input >= leftBorder) {
                if (input <= rightBorder) {
                    return input;
                } else {
                    System.out.println("Неверный ввод: введенное число не должно превышать " + rightBorder +
                            ". Попробуйте снова");
                    System.out.print(message + " ");
                }
            } else {
                System.out.println("Неверный ввод: введенное число не должно быть меньше " + leftBorder +
                        ". Попробуйте снова");
                System.out.print(message + " ");
            }
        }
    }

    // выводит на экран сообщение message и считывает неотрицательное целое число
    public static int readNonNegativeNumber(Scanner scanner, String message) {
        System.out.print(message + " ");
        int input;
        while (true) {
            input = scanner.nextInt();
            if (input > -1) {
                return input;
            } else {
                System.out.println("Неверный ввод: введенное число должно быть неотрицательным. Попробуйте снова");
                System.out.print(message + " ");
            }
        }
    }
}