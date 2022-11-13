//Хранит и обрабатывает данные одного месяца
public class MonthData {

    int[] days = new int[30]; //хранит количество пройденных шагов в каждый день

    public MonthData() {
        for (int i = 0; i < days.length; i++) days[i] = 0;
    }

    // сохраняет новое количество пройденных шагов newSteps в день номер dayNumber
    public void setStepsOnDay (int dayNumber, int newSteps) {
        days[dayNumber-1] = newSteps;
    }

    // выводит на экран статистику за месяц. stepsGoal - целевое количество шагов, которые необходимо пройти за один день
    public void printMonthData(int stepsGoal) {
        int stepsSum = getStepsSum();
        int[] maxStepsAndCorrespondingDay = getMaxStepsAndCorrespondingDay();
        printAllSteps();
        printStepsSum(stepsSum);
        printMaxSteps(maxStepsAndCorrespondingDay[0], maxStepsAndCorrespondingDay[1]);
        printAverageSteps(stepsSum);
        Converter converter = new Converter();
        System.out.println("Всего пройдено за месяц " + converter.convertToKm(stepsSum) + " километров");
        System.out.println("Всего сожжено за месяц " + converter.convertToKcal(stepsSum) + " килокалорий");
        printLongestGoalStreak(stepsGoal);
    }

    // возвращает суммарное количество пройденных шагов
    public int getStepsSum() {
        int stepsSum = 0;
        for (int i = 0; i < days.length; i++) {
            stepsSum = stepsSum + days[i];
        }
        return stepsSum;
    }

    // возвращает массив из двух элементов, содержащий максимальное количество шагов, пройденных за один день
    // и соответствующий день
    public int[] getMaxStepsAndCorrespondingDay() {
        int maxSteps = 0;
        int dayWithMaxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
                dayWithMaxSteps = i + 1;
            }
        }
        int[] maxStepsAndCorrespondingDay = {maxSteps, dayWithMaxSteps};
        return maxStepsAndCorrespondingDay;
    }

    // выводит на экран количество пройденных шагов по дням
    public void printAllSteps() {
        System.out.println("Количество пройденных шагов по дням");
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j< 6; j++) {
                System.out.print((i * 5 + j) + "-й день: " + days[i * 5 + j - 1] + ", ");
            }
            System.out.println("");
        }
    }

    // выводит на экран суммарное количество шагов stepsSum, пройденных за месяц
    public void printStepsSum(int stepsSum) {
        System.out.print("Всего пройдено " + stepsSum);
        printWordSteps(stepsSum);
        System.out.println("");
    }

    //выводит на экран максимальное количество шагов пройденных за один день maxSteps и номер этого дня dayWithMaxSteps
    public void printMaxSteps(int maxSteps, int dayWithMaxSteps) {
        if (maxSteps == 0) {
            System.out.println("Ни в один из дней не пройдено ни одного шага");
            return;
        }
        if (dayWithMaxSteps == 2) {
            System.out.print("Наибольшее количество шагов пройдено во " + dayWithMaxSteps + "-й день - " + maxSteps);
        } else {
            System.out.print("Наибольшее количество шагов пройдено в " + dayWithMaxSteps + "-й день - " + maxSteps);
        }
        printWordSteps(maxSteps);
        System.out.println("");
    }

    // выводит на экран среднее количество шагоф пройденых за день в течение месяца
    public void printAverageSteps(int stepsSum) {
        System.out.println("В среднем пройдено " + stepsSum / 30.0 + " шагов в день.");
    }

    // выводит на экран информацию о самой длинной серии достижения цели по количеству пройденных шагов в день stepsGoal
    public void printLongestGoalStreak(int stepsGoal) {
        int firstDayOfStreak = 0;
        int lastDayOfStreak = 0;
        int streakDuration = 0;
        int firstDay = 0;
        int counter = 0;
        for (int i = 0; i < days.length; i++) {
            if (stepsGoal <= days[i]) {
                if (counter == 0) {
                    firstDay = i + 1;
                }
                counter++;
                if (i == days.length - 1) {
                    if (counter > streakDuration) {
                        streakDuration = counter;
                        firstDayOfStreak = firstDay;
                        lastDayOfStreak = i + 1;
                    }
                }
            } else if (counter > streakDuration) {
                streakDuration = counter;
                firstDayOfStreak = firstDay;
                lastDayOfStreak = i;
                counter = 0;
            } else {
                counter = 0;
            }
        }
        if (streakDuration == 0) {
            System.out.print("Ни в один из дней в этом месяце вы не достигли цели в " + stepsGoal);
            printWordSteps(stepsGoal);
            System.out.println("");
        } else {
            System.out.print("В этом месяце лучшая серия достижения цели в " + stepsGoal);
            printWordSteps(stepsGoal);
            System.out.print(" составила " + streakDuration);
            printWordDays(streakDuration);
            System.out.println(" и продлилась с " + firstDayOfStreak + "-го дня по " + lastDayOfStreak + "-й");
        }
    }

    // правильно склоняет слово "шаги"
    public static void printWordSteps(int steps) {
        if (10 < steps % 100) {
            if (steps % 100 < 15) {
                System.out.print(" шагов");
                return;
            }
        }
        if (steps % 10 ==1) {
            System.out.print(" шаг");
        } else if (1 < steps % 10) {
            if (steps % 10 < 5) {
                System.out.print(" шага");
            } else {
                System.out.print(" шагов");
            }
        } else {
            System.out.print(" шагов");
        }
    }

    // правильно склоняет слово "дни"
    public static void printWordDays(int days) {
        if (10 < days % 100) {
            if (days % 100 < 15) {
                System.out.print(" дней");
                return;
            }
        }
        if (days % 10 ==1) {
            System.out.print(" день");
        } else if (1 < days % 10) {
            if (days % 10 < 5) {
                System.out.print(" дня");
            } else {
                System.out.print(" дней");
            }
        } else {
            System.out.print(" дней");
        }
    }
}