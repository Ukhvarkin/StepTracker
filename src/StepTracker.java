import java.util.Scanner;
public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];//месяцы
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();


    StepTracker(Scanner scan) {
        scanner = scan; // Чтобы не создавать новый экземпляр Scanner

        for (int i=0; i < monthToData.length; i++) { //экземпляр класса MonthData для каждого индекса массива monthToData
            monthToData[i] = new MonthData(); //
        }
    }
    void addNewNumberStepsPerDay() {
        int month=0;
        while (month < 1 || month > 12) {
            System.out.println("Введите номер месяца от 1 до 12 (включительно):");
            month = scanner.nextInt();
        }

        int day = 0;
        while (day < 1 || day > 30) {
            System.out.println("Введите день от 1 до 30 (включительно):");
            day = scanner.nextInt();
        }

        int steps = 0;
        while (steps<1){
            System.out.println("Введите количество шагов (строго больше 0):");
            steps = scanner.nextInt();
        }

            // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month-1];
            // Сохранение полученных данных
        monthData.days[day-1] = steps;
    }


    void changeStepGoal(){
        System.out.println("Сейчас твоя цель "+ goalByStepsPerDay +" шагов в день");

        int newStepGoal = 0;
        while (newStepGoal<1){
            System.out.print("Введите новую цель (больше 0): ");
            newStepGoal = scanner.nextInt();
        }
        goalByStepsPerDay=newStepGoal;
        System.out.println("Ваша новая цель: "+goalByStepsPerDay + " шаг(-ов) в день.");
    }

    void printStatistic(){
        int month=0;
        while (month < 1 || month > 12) {
            System.out.println("Введите номер месяца от 1 до 12 (включительно):");
            month = scanner.nextInt();
        }

        MonthData monthData = monthToData[month-1];// получение соответствующего месяца
        int sumSteps = monthData.sumStepsFromMonth(); // получение суммы шагов за месяц
        monthData.printDaysAndStepsFromMonth();// вывод общей статистики по дням
        System.out.println("Сумма шагов за месяц: "+sumSteps);// вывод суммы шагов за месяц
        System.out.println("Максимальное пройденное количество шагов в месяце: "+monthData.maxSteps());// вывод максимального пройденного количества шагов за месяц
        System.out.println("Среднее количество шагов: "+(sumSteps/(monthData.days.length)));// вывод среднего пройденного количества шагов за месяц
        System.out.println("Пройдено: "+converter.convertToKm(sumSteps)+" км");// вывод пройденной за месяц дистанции в км
        System.out.println("Сожжено: "+converter.convertStepsToKilocalories(sumSteps)+" ккал");// вывод количества сожжённых килокалорий за месяц
        System.out.println("Лучшая серия: "+monthData.bestSeries(goalByStepsPerDay));// вывод лучшей серии
        System.out.println(); //дополнительный перенос строки
    }
}
