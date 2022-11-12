// переводит пройденные шаги в пройденные километры и сожженные килокалории
public class Converter {

    double kmRate = 75.0 / 100000.0; // отношение километров к шагам
    double kcalRate = 50.0 / 1000.0; // отношение килокалориям к шагам

    // переводит шаги steps в километры
    public double convertToKm (int steps) {
        return steps * kmRate;
    }

    // переводит шаги steps в килокалории
    public double convertToKcal(int steps) {
        return steps * kcalRate;
    }
}
