package model;

public class MainFunctions {


    // напор в области питания
    public <T extends Number> double pressureInTheFieldOfNutrition(T num1, T num2) {
        return Math.round((num1.doubleValue() - num2.doubleValue()) * 100) / 100.00;

    }

    // Понижение уровня подземных вод в центре системы
    public <T extends Number> double loweringOfTheGroundwaterLevel(T num1, T num2) {
        return Math.round((num1.doubleValue() - num2.doubleValue()) * 100) / 100.00;
    }

    // Понижение уровня подземных вод в напорном режиме
    public <T extends Number> double loweringOfWaterInPressureMode(T num1, T num2) {
        return Math.round((num1.doubleValue() - num2.doubleValue()) * 100) / 100.00;
    }

    // Понижение уровня подземных вод в безнапорном режиме
    public <T extends Number> double loweringOfWaterInNonPressureMode(T num1, T num2) {
        return Math.round((num1.doubleValue() - num2.doubleValue()) * 100) / 100.00;
    }

    // Напор в центре системы
    public <T extends Number> double pressureInTheCenterOfTheSystem(T num1, T num2) {
        return Math.round((num1.doubleValue() - num2.doubleValue()) * 100) / 100.00;
    }

    // Мощность водоносного слоя
    public <T extends Number> double theThicknessOfTheAquifer(T num1, T num2) {
        return Math.round((num1.doubleValue() - num2.doubleValue()) * 100) / 100.00;
    }

    // Средняя глубина фильтрационного потока при напорно-безнапорной фильтрации
    public <T extends Number> double theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration(T num1, T num2, T num3, T num4) {

        return Math.round(((2 * num1.doubleValue() * num2.doubleValue()
                - num2.doubleValue() * num2.doubleValue()
                - num3.doubleValue() * num3.doubleValue())
                / (2 * num4.doubleValue()))
                * 100)
                / 100.00;
    }

    // Средняя глубина фильтрационного потока при безнапорной фильтрации
    public <T extends Number> double theAverageDepthOfTheFiltrationFloDuringPheatricFiltration(T num1, T num2) {

        return Math.round(((2 * num1.doubleValue() - num2.doubleValue())
                / (2))
                * 100)
                / 100.00;
    }

    public <T extends Number> double theAverageDepthOfTheFiltrationFloDuringPressureFiltration(T num1) {

        return Math.round((num1.doubleValue())
                * 100)
                / 100.00;
    }

    // Приведённый радиус водопонизительной системы (Расчёт через площадь)
    public <T extends Number> double theReducedRadiusOfTheWaterLoweringSystemSQR(T num1) {

        return Math.round((Math.sqrt(num1.doubleValue() / Math.PI)) * 100) / 100.00;
    }

    // Радиус депрессии при напорно-безнапорной фильтрации
    public <T extends Number> double depressionRadiusPressureFree(T num1, T num2, T num3, T num4, T num5) {

        return Math.round((num1.doubleValue() + 10 * num2.doubleValue() * Math.sqrt(num3.doubleValue()) + 2 * num4.doubleValue() * Math.sqrt(num3.doubleValue() * num5.doubleValue())) * 100) / 100.00;
    }

    // Радиус депрессии при безнапорной фильтрации
    public <T extends Number> double depressionRadiusPheatric(T num1, T num2, T num3, T num4) {

        return Math.round((num1.doubleValue() + 2 * num2.doubleValue() * Math.sqrt(num3.doubleValue() * num4.doubleValue())) * 100) / 100.00;
    }

    // Радиус депрессии при напорной фильтрации
    public <T extends Number> double depressionRadiusPressure(T num1, T num2, T num3) {

        return Math.round((num1.doubleValue() + 10 * num2.doubleValue() * Math.sqrt(num3.doubleValue())) * 100) / 100.00;
    }

    // Функция понижения от действия кольцевой водопонизительной системы
    public <T extends Number> double loweringOfWaterFunctionCircle(T num1, T num2) {

        return Math.round((Math.log(num1.doubleValue() / num2.doubleValue()) / (2 * Math.PI)) * 100) / 100.00;
    }

    // Полный приток подземных вод к системе
    public <T extends Number> double totalSystemInflow(T num1, T num2, T num3, T num4) {

        return Math.round((num1.doubleValue() * num2.doubleValue() * num3.doubleValue() / num4.doubleValue()) * 100) / 100.00;
    }

    // Производительность скважины
    public <T extends Number> double capacityOfLoweringWell(T num1, T num2) {

        return Math.round((num1.doubleValue() / num2.doubleValue()) * 100) / 100.00;
    }

    // Длина действующей части фильтра
    public <T extends Number> double lengthOfFilter(T num1, T num2, T num3) {

        return Math.round((num1.doubleValue() / (400 * (num2.doubleValue() / 2000) * Math.pow(num3.doubleValue(), (double) 1 / 3))) * 100) / 100.00;
    }
}