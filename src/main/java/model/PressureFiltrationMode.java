package model;

// Расчёт системы водопонижения при напорном режиме фильтрации

import service.Scan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PressureFiltrationMode {

    MainFunctions mainFunctions = new MainFunctions();
    Scan scan = new Scan();

    private double pressureInTheFieldOfNutrition;
    private double loweringOfTheGroundwaterLevel;
    private double theThicknessOfTheAquifer;
    private double theAverageDepthOfTheFiltrationFloDuringPressureFiltration;
    private double theReducedRadiusOfTheWaterLoweringSystemSQR;
    private double depressionRadiusPressure;
    private double loweringOfWaterFunctionCircle;
    private double totalSystemInflow;
    private double capacityOfLoweringWell;
    private double lengthOfFilter;

    private Output output = new Output(pressureInTheFieldOfNutrition, loweringOfTheGroundwaterLevel, theThicknessOfTheAquifer,
            theAverageDepthOfTheFiltrationFloDuringPressureFiltration,
            theReducedRadiusOfTheWaterLoweringSystemSQR, depressionRadiusPressure,
            loweringOfWaterFunctionCircle, totalSystemInflow,
            capacityOfLoweringWell, lengthOfFilter);
     private Input input ;

    public void pressureFiltrationMode() {
        input = new Input(scan.number("Площадь ограниченная контуром водопонижения, м2: "),
                scan.number("Диаметр фильтра, мм: "), scan.number("Отметка верхнего водоупора, м: "),
                scan.number("Отметка нижнего водоупора, м: "), scan.number("Отметка уровня понижения, м: "),
                scan.number("Отметка уровня подземных вод, м: "),
                scan.number("Коэффициент фильтрации, м/сут: "), scan.number("Количество водопонизительных скважин, шт.: "),
                scan.number("Шаг скважин, м: "));

        // напор в области питания
        output.setPressureInTheFieldOfNutrition(mainFunctions.pressureInTheFieldOfNutrition(input.getMarkingOfTheGroundwaterLevel(), input.getTheMarkOfTheLowerWaterBarrier()));
        System.out.println("Напор в области питания: H = " + output.getPressureInTheFieldOfNutrition() + " м");

        //Понижение уровня подземных вод  в центре системы
        output.setLoweringOfTheGroundwaterLevel(mainFunctions.loweringOfTheGroundwaterLevel(input.getMarkingOfTheGroundwaterLevel(), input.getMarkOfThDowngradeLevel()));
        System.out.println("Понижение уровня подземных вод  в центре системы: S = " + output.getLoweringOfTheGroundwaterLevel() + " м");

        // Мощность водоносного слоя
        output.setTheThicknessOfTheAquifer(mainFunctions.theThicknessOfTheAquifer(input.getMarkOfTheUpperWaterBarrier(), input.getTheMarkOfTheLowerWaterBarrier()));
        System.out.println("Мощность водоносного слоя: hpl = " + output.getTheThicknessOfTheAquifer() + " м");

        // Средняя глубина фильтрационного потока при напорной фильтрации
        output.setTheAverageDepthOfTheFiltrationFloDuringPressureFiltration(mainFunctions.theAverageDepthOfTheFiltrationFloDuringPressureFiltration(output.getTheThicknessOfTheAquifer()));
        System.out.println("Средняя глубина фильтрационного потока при напорной фильтрации: h = " + output.getTheAverageDepthOfTheFiltrationFloDuringPressureFiltration() + " м");

        // Приведённый радиус водопонизительной системы (Расчёт через площадь)
        output.setTheReducedRadiusOfTheWaterLoweringSystemSQR(mainFunctions.theReducedRadiusOfTheWaterLoweringSystemSQR(input.getWaterReductionArea()));
        System.out.println("Приведённый радиус водопонизительной системы: r = " + output.getTheReducedRadiusOfTheWaterLoweringSystemSQR() + " м");

        // Радиус депрессии
        output.setDepressionRadiusPressure(mainFunctions.depressionRadiusPressure(output.getTheReducedRadiusOfTheWaterLoweringSystemSQR(), output.getLoweringOfTheGroundwaterLevel(), input.getFiltrationCoefficient()));
        System.out.println("Радиус депрессии: rd = " + output.getDepressionRadiusPressure() + " м");

        // Функция понижения от действия водопонизительной системы
        output.setLoweringOfWaterFunctionCircle(mainFunctions.loweringOfWaterFunctionCircle(output.getDepressionRadiusPressure(), output.getTheReducedRadiusOfTheWaterLoweringSystemSQR()));
        System.out.println("Функция понижения от действия водопонизительной системы: Ф = " + output.getLoweringOfWaterFunctionCircle());

        // Полный приток подземных вод к системе
        output.setTotalSystemInflow(mainFunctions.totalSystemInflow(input.getFiltrationCoefficient(), output.getTheAverageDepthOfTheFiltrationFloDuringPressureFiltration(),
                output.getLoweringOfTheGroundwaterLevel(), output.getLoweringOfWaterFunctionCircle()));
        System.out.println("Полный приток подземных вод к системе: Q = " + output.getTotalSystemInflow() + " м3/сут");

        // Производительность скважины
        output.setCapacityOfLoweringWell(mainFunctions.capacityOfLoweringWell(output.getTotalSystemInflow(), input.getNumberOfWaterLoweringWells()));
        System.out.println("Производительность скважины: qh = " + output.getCapacityOfLoweringWell() + " м3/сут");

        // Длина действующей части фильтра
        output.setLengthOfFilter(mainFunctions.lengthOfFilter(output.getCapacityOfLoweringWell(), input.getFilterDiameter(), input.getFiltrationCoefficient()));
        System.out.println("Длина действующей части фильтра: lf = " + output.getLengthOfFilter() + " м");
    }

    public void saveInBD() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/BD1.txt"))) {
            writer.write("waterReductionArea = " + input.getWaterReductionArea() + "\n");
            writer.write("filterDiameter = " + input.getFilterDiameter() + "\n");
            writer.write("markOfTheUpperWaterBarrier = " + input.getMarkOfTheUpperWaterBarrier() + "\n");
            writer.write("theMarkOfTheLowerWaterBarrier = " + input.getTheMarkOfTheLowerWaterBarrier() + "\n");
            writer.write("markOfThDowngradeLevel = " + input.getMarkOfThDowngradeLevel() + "\n");
            writer.write("markingOfTheGroundwaterLevel = " + input.getMarkingOfTheGroundwaterLevel() + "\n");
            writer.write("filtrationCoefficient = " + input.getFiltrationCoefficient() + "\n");
            writer.write("numberOfWaterLoweringWells = " + input.getNumberOfWaterLoweringWells() + "\n");
            writer.write("wellPitch = " + input.getWellPitch() + "\n");

            writer.write("pressureInTheFieldOfNutrition = " + output.getPressureInTheFieldOfNutrition() + "\n");
            writer.write("loweringOfTheGroundwaterLevel = " + output.getLoweringOfTheGroundwaterLevel() + "\n");
            writer.write("theThicknessOfTheAquifer = " + output.getTheThicknessOfTheAquifer() + "\n");
            writer.write("theAverageDepthOfTheFiltrationFloDuringPressureFiltration = " + output.getTheAverageDepthOfTheFiltrationFloDuringPressureFiltration() + "\n");
            writer.write("theReducedRadiusOfTheWaterLoweringSystemSQR = " + output.getTheReducedRadiusOfTheWaterLoweringSystemSQR() + "\n");
            writer.write("depressionRadiusPressure = " + output.getDepressionRadiusPressure() + "\n");
            writer.write("loweringOfWaterFunctionCircle = " + output.getLoweringOfWaterFunctionCircle() + "\n");
            writer.write("totalSystemInflow = " + output.getTotalSystemInflow() + "\n");
            writer.write("capacityOfLoweringWell = " + output.getCapacityOfLoweringWell() + "\n");
            writer.write("lengthOfFilter = " + output.getLengthOfFilter() + "\n");


            System.out.println("Variables written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing variables to file.");
            e.printStackTrace();
        }
    }
}
