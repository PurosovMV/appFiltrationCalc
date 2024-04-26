package model;

// Расчёт водопонижения при напорно-безнапорном режиме фильтрации

import service.Scan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PressureFreeFiltrationMode {

    MainFunctions mainFunctions = new MainFunctions();
    Scan scan = new Scan();


    private double pressureInTheFieldOfNutrition;
    private double loweringOfTheGroundwaterLevel;
    private double loweringOfWaterInPressureMode;
    private double loweringOfWaterInNonPressureMode;
    private double pressureInTheCenterOfTheSystem;
    private double theThicknessOfTheAquifer;
    private double theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration;
    private double theReducedRadiusOfTheWaterLoweringSystemSQR;
    private double depressionRadiusPressureFree;
    private double loweringOfWaterFunctionCircle;
    private double totalSystemInflow;
    private double capacityOfLoweringWell;
    private double lengthOfFilter;


    private Output output = new Output(pressureInTheFieldOfNutrition, loweringOfTheGroundwaterLevel,
            loweringOfWaterInPressureMode, loweringOfWaterInNonPressureMode,
            pressureInTheCenterOfTheSystem, theThicknessOfTheAquifer,
            theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration,
            theReducedRadiusOfTheWaterLoweringSystemSQR, depressionRadiusPressureFree,
            loweringOfWaterFunctionCircle, totalSystemInflow, capacityOfLoweringWell,
            lengthOfFilter);
    private Input input;


    public void pressureFreeFiltrationMode() {

        input = new Input(scan.number("Площадь ограниченная контуром водопонижения, м2: "),
                scan.number("Диаметр фильтра, мм: "),
                scan.number("Отметка верхнего водоупора, м: "),
                scan.number("Отметка нижнего водоупора, м: "),
                scan.number("Отметка уровня понижения, м: "),
                scan.number("Отметка уровня подземных вод, м: "),
                scan.number("Коэффициент фильтрации, м/сут: "),
                scan.number("Количество водопонизительных скважин, шт.: "),
                scan.number("Шаг скважин, м: "));


        // напор в области питания
        output.setPressureInTheFieldOfNutrition(mainFunctions.pressureInTheFieldOfNutrition(input.getMarkingOfTheGroundwaterLevel(), input.getTheMarkOfTheLowerWaterBarrier()));
        System.out.println("Напор в области питания: H = " + output.getPressureInTheFieldOfNutrition() + " м");

        //Понижение уровня подземных вод  в центре системы
        output.setLoweringOfTheGroundwaterLevel(mainFunctions.loweringOfTheGroundwaterLevel(input.getMarkingOfTheGroundwaterLevel(), input.getMarkOfThDowngradeLevel()));
        System.out.println("Понижение уровня подземных вод  в центре системы: S = " + output.getLoweringOfTheGroundwaterLevel() + " м");

        // Понижение уровня подземных вод в напорном режиме
        output.setLoweringOfWaterInPressureMode(mainFunctions.loweringOfWaterInPressureMode(input.getMarkingOfTheGroundwaterLevel(), input.getMarkOfTheUpperWaterBarrier()));
        System.out.println("Понижение уровня подземных вод в напорном режиме: Sр = " + output.getLoweringOfWaterInPressureMode() + " м");

        // Понижение уровня подземных вод в безнапорном режиме
        output.setLoweringOfWaterInNonPressureMode(mainFunctions.loweringOfWaterInNonPressureMode(input.getMarkOfTheUpperWaterBarrier(), input.getMarkOfThDowngradeLevel()));
        System.out.println("Понижение уровня подземных вод в безнапорном режиме: Sпр = " + output.getLoweringOfWaterInNonPressureMode() + " м");

        // Напор в центре системы
        output.setPressureInTheCenterOfTheSystem(mainFunctions.pressureInTheCenterOfTheSystem(output.getPressureInTheFieldOfNutrition(), output.getLoweringOfTheGroundwaterLevel()));
        System.out.println("Напор в центре системы: y = " + output.getPressureInTheCenterOfTheSystem() + " м");

        // Мощность водоносного слоя
        output.setTheThicknessOfTheAquifer(mainFunctions.theThicknessOfTheAquifer(input.getMarkOfTheUpperWaterBarrier(), input.getTheMarkOfTheLowerWaterBarrier()));
        System.out.println("Мощность водоносного слоя: hpl = " + output.getTheThicknessOfTheAquifer() + " м");

        // Средняя глубина фильтрационного потока при напорно-безнапорной фильтрации
        output.setTheAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration(mainFunctions.theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration(output.getPressureInTheFieldOfNutrition(), output.getTheThicknessOfTheAquifer(), output.getPressureInTheCenterOfTheSystem(), output.getLoweringOfTheGroundwaterLevel()));
        System.out.println("Средняя глубина фильтрационного потока при напорно-безнапорной фильтрации: h = " + output.getTheAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration() + " м");

        // Приведённый радиус водопонизительной системы (Расчёт через площадь)
        output.setTheReducedRadiusOfTheWaterLoweringSystemSQR(mainFunctions.theReducedRadiusOfTheWaterLoweringSystemSQR(input.getWaterReductionArea()));
        System.out.println("Приведённый радиус водопонизительной системы: r = " + output.getTheReducedRadiusOfTheWaterLoweringSystemSQR() + " м");

        // Радиус депрессии
        output.setDepressionRadiusPressureFree(mainFunctions.depressionRadiusPressureFree(output.getTheReducedRadiusOfTheWaterLoweringSystemSQR(), output.getLoweringOfWaterInPressureMode(), input.getFiltrationCoefficient(), output.getLoweringOfWaterInNonPressureMode(), output.getPressureInTheFieldOfNutrition()));
        System.out.println("Радиус депрессии: rd = " + output.getDepressionRadiusPressureFree() + " м");

        // Функция понижения от действия водопонизительной системы
        output.setLoweringOfWaterFunctionCircle(mainFunctions.loweringOfWaterFunctionCircle(output.getDepressionRadiusPressureFree(), output.getTheReducedRadiusOfTheWaterLoweringSystemSQR()));
        System.out.println("Функция понижения от действия водопонизительной системы: Ф = " + output.getLoweringOfWaterFunctionCircle());

        // Полный приток подземных вод к системе
        output.setTotalSystemInflow(mainFunctions.totalSystemInflow(input.getFiltrationCoefficient(), output.getTheAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration(), output.getLoweringOfTheGroundwaterLevel(), output.getLoweringOfWaterFunctionCircle()));
        System.out.println("Полный приток подземных вод к системе: Q = " + output.getTotalSystemInflow() + " м3/сут");

        // Производительность скважины
        output.setCapacityOfLoweringWell(mainFunctions.capacityOfLoweringWell(output.getTotalSystemInflow(), input.getNumberOfWaterLoweringWells()));
        System.out.println("Производительность скважины: qh = " + output.getCapacityOfLoweringWell() + "м3/сут");

        // Длина действующей части фильтра
        output.setLengthOfFilter(mainFunctions.lengthOfFilter(output.getCapacityOfLoweringWell(), input.getFilterDiameter(), input.getFiltrationCoefficient()));
        System.out.println("Длина действующей части фильтра: lf = " + output.getLengthOfFilter() + " м");


    }

    public void saveInBD() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/BD.txt"))) {
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
            writer.write("loweringOfWaterInPressureMode = " + output.getLoweringOfWaterInPressureMode() + "\n");
            writer.write("loweringOfWaterInNonPressureMode = " + output.getLoweringOfWaterInNonPressureMode() + "\n");
            writer.write("pressureInTheCenterOfTheSystem = " + output.getPressureInTheCenterOfTheSystem() + "\n");
            writer.write("theThicknessOfTheAquifer = " + output.getTheThicknessOfTheAquifer() + "\n");
            writer.write("theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration = " + output.getTheAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration() + "\n");
            writer.write("theReducedRadiusOfTheWaterLoweringSystemSQR = " + output.getTheReducedRadiusOfTheWaterLoweringSystemSQR() + "\n");
            writer.write("depressionRadiusPressureFree = " + output.getDepressionRadiusPressureFree() + "\n");
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
