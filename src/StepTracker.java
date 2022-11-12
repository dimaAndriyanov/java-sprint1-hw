// основной класс приложения
public class StepTracker {

    int stepsGoal = 10000; // хранит целевое количество шагав на каждый день
    MonthData[] monthData; // хранит данные за 12 месяцев (1 год)

    public StepTracker() {
        monthData = new MonthData[12];
        for (int i = 0; i < monthData.length; i++) monthData[i] = new MonthData();
    }

    // устанавливает новое целевое количество шагов на каждый день newStepsGoal
    public void setStepsGoal(int newStepsGoal) {
        stepsGoal = newStepsGoal;
        System.out.println("Новая цель по колчиеству шагов - " + stepsGoal);
    }

    // устанавливает количество пройденных шагов steps в месяце номер monthNumber в дне номер dayNumber
    public void setStepsOnDate(int monthNumber, int dayNumber, int steps){
        monthData[monthNumber - 1].setStepsOnDay(dayNumber, steps);
        System.out.print(dayNumber + "." + monthNumber + " пройдено " + steps);
        printWordSteps(steps);
        System.out.println("");
    }

    // выводит на экран статистику достижений за месяц номер monthNumber
    public void showStatisticsOnMonth(int monthNumber){
        monthData[monthNumber - 1].printMonthData(stepsGoal);
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
}
