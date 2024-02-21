import java.util.Scanner;
public class Main {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command==1){
                stepTracker.addNewNumberStepsPerDay(); //команда 1
            } else if (command==2){
                stepTracker.changeStepGoal();//команда 2
            } else if (command==3){
                stepTracker.printStatistic();
            } else if (command==4){
                System.out.println("Всего доброго!");
                scanner.close();
                return; // останавливает всю программу
            } else {
                System.out.println("Такой команды нет");
            }

        }
    }

    static void printMenu(){
        System.out.println("Шагомер v1. Выберите задачу: ");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Статистика за месяц");
        System.out.println("4 - Выход");
    }
}
