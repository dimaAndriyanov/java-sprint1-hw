import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        printMenu();
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (userInput != 0) {
            if (userInput ==1) {
                System.out.print("Введите номер месяца, в котором вы хотите внести количество пройденных шагов ");
                int monthNumber = readMonthNumber(scanner);
                System.out.print("Введите номер дня месяца, в котором вы хотите внести количество пройденных шагов ");
                int dayNumber = readDayNumber(scanner);
                System.out.print("Введите количество пройденных шагов ");
                int steps = readSteps(scanner);
                stepTracker.setStepsOnDate(monthNumber, dayNumber, steps);
            } else if (userInput ==2) {
                System.out.print("Введите номер месяца, за который вы хотите увидеть статистику ");
                int monthNumber = readMonthNumber(scanner);
                stepTracker.showStatisticsOnMonth(monthNumber);
            } else if (userInput ==3) {
                System.out.print("Введите новую цель по количеству шагов за день ");
                int steps = readSteps(scanner);
                stepTracker.setStepsGoal(steps);
            } else System.out.println("Неверный ввод, попробуйте снова");
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

    // считывает номер месяца из командной строки, исключает ошибки пользователя
    public static int readMonthNumber(Scanner scanner) {
        int monthNumber;
        while (true) {
            monthNumber = scanner.nextInt();
            if (monthNumber > 0) {
                if (monthNumber < 13) {
                    return monthNumber;
                } else {
                    System.out.println("Неверный ввод, попробуйте снова");
                    System.out.print("Введите номер месяца, в котором вы хотите внести количество пройденных шагов ");
                }
            } else {
                System.out.println("Неверный ввод, попробуйте снова");
                System.out.print("Введите номер месяца, в котором вы хотите внести количество пройденных шагов ");
            }
        }
    }

    // считывает номер дня из командной строки, исключает ошибки пользователя
    public static int readDayNumber(Scanner scanner) {
        int dayNumber;
        while (true) {
            dayNumber = scanner.nextInt();
            if (dayNumber > 0) {
                if (dayNumber < 31) {
                    return dayNumber;
                } else {
                    System.out.println("Неверный ввод, попробуйте снова");
                    System.out.print("Введите номер дня месяца, в котором вы хотите внести количество пройденных шагов ");
                }
            } else {
                System.out.println("Неверный ввод, попробуйте снова");
                System.out.print("Введите номер дня месяца, в котором вы хотите внести количество пройденных шагов ");
            }
        }
    }

    // считывает количество шагов из командной строки, исключает ошибки пользователя
    public static int readSteps (Scanner scanner) {
        int steps;
        while (true) {
            steps = scanner.nextInt();
            if (steps > -1) {
                return steps;
            } else {
                System.out.println("Неверный ввод, попробуйте снова");
                System.out.print("Введите количество пройденных шагов ");
            }
        }
    }
}
