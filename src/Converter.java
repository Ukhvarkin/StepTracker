public class Converter {

    int convertToKm(int steps) { // метод переводящий количество шагов в километры
        return (steps*75)/100000;
    }

    int convertStepsToKilocalories(int steps){ // метод, переводящий количество шагов в килокалории
        return (steps*50)/1000;

    }
}
