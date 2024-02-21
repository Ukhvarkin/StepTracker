public class MonthData {
    int [] days = new int[30];


    void printDaysAndStepsFromMonth(){ // количество пройденных шагов в день
        for (int i =0; i< days.length; i++){
            System.out.println((i+1)+" день: "+days[i]);// Вывод элементов массива в необходимом формате
        }
    }

    int sumStepsFromMonth(){ // общее количество шагов за месяц
        int sumSteps = 0;
        for (int i : days) {
            sumSteps += i;// подсчёт суммы элементов массива days[]
        }
        return sumSteps;
    }

    int maxSteps(){ // максимальное количество шагов за месяц
        int maxSteps =0;
        for (int i : days) {
            if (maxSteps < i) {
                maxSteps = i;// поиск максимального элемента
            }
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) { // Максимальная серия шагов
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i : days) {
            if (i >= goalByStepsPerDay) { // поиск максимальной серии
                currentSeries++;
                if(currentSeries>finalSeries){ // если текущая серия больше финальной
                    finalSeries = currentSeries; // то финальной серии присваиваем значение текущей
                }
            } else {
                currentSeries=0;
            }
        }
        return finalSeries;
    }
}
