package model;

public class Output {


    private double pressureInTheFieldOfNutrition; // напор в области питания
    private double loweringOfTheGroundwaterLevel; //Понижение уровня подземных вод  в центре системы
    private double loweringOfWaterInPressureMode; // Понижение уровня подземных вод в напорном режиме
    private double loweringOfWaterInNonPressureMode; // Понижение уровня подземных вод в безнапорном режиме
    private double pressureInTheCenterOfTheSystem; // Напор в центре системы
    private double theThicknessOfTheAquifer; // Мощность водоносного слоя
    private double theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration;  // Средняя глубина фильтрационного потока при напорно-безнапорной фильтрации
    private double theAverageDepthOfTheFiltrationFloDuringPressureFiltration; // Средняя глубина фильтрационного потока при напорной фильтрации
    private double theAverageDepthOfTheFiltrationFloDuringPhreaticFiltration; // Средняя глубина фильтрационного потока при безнапорной фильтрации
    private double theReducedRadiusOfTheWaterLoweringSystemSQR;  // Приведённый радиус водопонизительной системы
    private double depressionRadiusPressureFree;  // Радиус депрессии при напорно-безнапорной фильтрации
    private double depressionRadiusPressure;  // Радиус депрессии при напорной фильтрации
    private double depressionRadiusPhreatic;  // Радиус депрессии при безнапорной фильтрации
    private double loweringOfWaterFunctionCircle; // Функция понижения от действия водопонизительной системы
    private double totalSystemInflow; // Полный приток подземных вод к системе
    private double capacityOfLoweringWell; // Производительность скважины
    private double lengthOfFilter; // Длина действующей части фильтра
    private double   filterRadius; //Радиус фильтра


    // напорно-безнапорный режим фильтрации
    public Output(double pressureInTheFieldOfNutrition, double loweringOfTheGroundwaterLevel,
                  double loweringOfWaterInPressureMode, double loweringOfWaterInNonPressureMode,
                  double pressureInTheCenterOfTheSystem, double theThicknessOfTheAquifer,
                  double theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration,
                  double theReducedRadiusOfTheWaterLoweringSystemSQR, double depressionRadiusPressureFree,
                  double loweringOfWaterFunctionCircle, double totalSystemInflow, double capacityOfLoweringWell,
                  double lengthOfFilter) {
        this.pressureInTheFieldOfNutrition = pressureInTheFieldOfNutrition;
        this.loweringOfTheGroundwaterLevel = loweringOfTheGroundwaterLevel;
        this.loweringOfWaterInPressureMode = loweringOfWaterInPressureMode;
        this.loweringOfWaterInNonPressureMode = loweringOfWaterInNonPressureMode;
        this.pressureInTheCenterOfTheSystem = pressureInTheCenterOfTheSystem;
        this.theThicknessOfTheAquifer = theThicknessOfTheAquifer;
        this.theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration = theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration;
        this.theReducedRadiusOfTheWaterLoweringSystemSQR = theReducedRadiusOfTheWaterLoweringSystemSQR;
        this.depressionRadiusPressureFree = depressionRadiusPressureFree;
        this.loweringOfWaterFunctionCircle = loweringOfWaterFunctionCircle;
        this.totalSystemInflow = totalSystemInflow;
        this.capacityOfLoweringWell = capacityOfLoweringWell;
        this.lengthOfFilter = lengthOfFilter;
    }


    // напорный режим фильтрации
    public Output(double pressureInTheFieldOfNutrition, double loweringOfTheGroundwaterLevel,
                  double theThicknessOfTheAquifer, double theAverageDepthOfTheFiltrationFloDuringPressureFiltration,
                  double theReducedRadiusOfTheWaterLoweringSystemSQR, double depressionRadiusPressure,
                  double loweringOfWaterFunctionCircle, double totalSystemInflow,
                  double capacityOfLoweringWell, double lengthOfFilter) {
        this.pressureInTheFieldOfNutrition = pressureInTheFieldOfNutrition;
        this.loweringOfTheGroundwaterLevel = loweringOfTheGroundwaterLevel;
        this.theThicknessOfTheAquifer = theThicknessOfTheAquifer;
        this.theAverageDepthOfTheFiltrationFloDuringPressureFiltration = theAverageDepthOfTheFiltrationFloDuringPressureFiltration;
        this.theReducedRadiusOfTheWaterLoweringSystemSQR = theReducedRadiusOfTheWaterLoweringSystemSQR;
        this.depressionRadiusPressure = depressionRadiusPressure;
        this.loweringOfWaterFunctionCircle = loweringOfWaterFunctionCircle;
        this.totalSystemInflow = totalSystemInflow;
        this.capacityOfLoweringWell = capacityOfLoweringWell;
        this.lengthOfFilter = lengthOfFilter;
        this.filterRadius = filterRadius;
    }
    // безнапорный режим фильтрации


    public Output(double pressureInTheFieldOfNutrition, double loweringOfTheGroundwaterLevel, double theThicknessOfTheAquifer,
                  double theAverageDepthOfTheFiltrationFloDuringPhreaticFiltration,
                  double theReducedRadiusOfTheWaterLoweringSystemSQR, double depressionRadiusPhreatic,
                  double loweringOfWaterFunctionCircle, double totalSystemInflow,
                  double capacityOfLoweringWell, double lengthOfFilter, double filterRadius) {
        this.pressureInTheFieldOfNutrition = pressureInTheFieldOfNutrition;
        this.loweringOfTheGroundwaterLevel = loweringOfTheGroundwaterLevel;
        this.theThicknessOfTheAquifer = theThicknessOfTheAquifer;
        this.theReducedRadiusOfTheWaterLoweringSystemSQR = theReducedRadiusOfTheWaterLoweringSystemSQR;
        this.loweringOfWaterFunctionCircle = loweringOfWaterFunctionCircle;
        this.totalSystemInflow = totalSystemInflow;
        this.capacityOfLoweringWell = capacityOfLoweringWell;
        this.lengthOfFilter = lengthOfFilter;
        this.theAverageDepthOfTheFiltrationFloDuringPhreaticFiltration = theAverageDepthOfTheFiltrationFloDuringPhreaticFiltration;
        this.depressionRadiusPhreatic = depressionRadiusPhreatic;
        this.filterRadius = filterRadius;
    }


    public double getPressureInTheFieldOfNutrition() {
        return pressureInTheFieldOfNutrition;
    }

    public void setPressureInTheFieldOfNutrition(double pressureInTheFieldOfNutrition) {
        this.pressureInTheFieldOfNutrition = pressureInTheFieldOfNutrition;
    }

    public double getLoweringOfTheGroundwaterLevel() {
        return loweringOfTheGroundwaterLevel;
    }

    public void setLoweringOfTheGroundwaterLevel(double loweringOfTheGroundwaterLevel) {
        this.loweringOfTheGroundwaterLevel = loweringOfTheGroundwaterLevel;
    }

    public double getLoweringOfWaterInPressureMode() {
        return loweringOfWaterInPressureMode;
    }

    public void setLoweringOfWaterInPressureMode(double loweringOfWaterInPressureMode) {
        this.loweringOfWaterInPressureMode = loweringOfWaterInPressureMode;
    }

    public double getLoweringOfWaterInNonPressureMode() {
        return loweringOfWaterInNonPressureMode;
    }

    public void setLoweringOfWaterInNonPressureMode(double loweringOfWaterInNonPressureMode) {
        this.loweringOfWaterInNonPressureMode = loweringOfWaterInNonPressureMode;
    }

    public double getPressureInTheCenterOfTheSystem() {
        return pressureInTheCenterOfTheSystem;
    }

    public void setPressureInTheCenterOfTheSystem(double pressureInTheCenterOfTheSystem) {
        this.pressureInTheCenterOfTheSystem = pressureInTheCenterOfTheSystem;
    }

    public double getTheThicknessOfTheAquifer() {
        return theThicknessOfTheAquifer;
    }

    public void setTheThicknessOfTheAquifer(double theThicknessOfTheAquifer) {
        this.theThicknessOfTheAquifer = theThicknessOfTheAquifer;
    }

    public double getTheAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration() {
        return theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration;
    }

    public void setTheAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration(double theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration) {
        this.theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration = theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration;
    }

    public double getTheAverageDepthOfTheFiltrationFloDuringPressureFiltration() {
        return theAverageDepthOfTheFiltrationFloDuringPressureFiltration;
    }

    public void setTheAverageDepthOfTheFiltrationFloDuringPressureFiltration(double theAverageDepthOfTheFiltrationFloDuringPressureFiltration) {
        this.theAverageDepthOfTheFiltrationFloDuringPressureFiltration = theAverageDepthOfTheFiltrationFloDuringPressureFiltration;
    }

    public double getTheAverageDepthOfTheFiltrationFloDuringPhreaticFiltration() {
        return theAverageDepthOfTheFiltrationFloDuringPhreaticFiltration;
    }

    public void setTheAverageDepthOfTheFiltrationFloDuringPhreaticFiltration(double theAverageDepthOfTheFiltrationFloDuringPhreaticFiltration) {
        this.theAverageDepthOfTheFiltrationFloDuringPhreaticFiltration = theAverageDepthOfTheFiltrationFloDuringPhreaticFiltration;
    }

    public double getTheReducedRadiusOfTheWaterLoweringSystemSQR() {
        return theReducedRadiusOfTheWaterLoweringSystemSQR;
    }

    public void setTheReducedRadiusOfTheWaterLoweringSystemSQR(double theReducedRadiusOfTheWaterLoweringSystemSQR) {
        this.theReducedRadiusOfTheWaterLoweringSystemSQR = theReducedRadiusOfTheWaterLoweringSystemSQR;
    }

    public double getDepressionRadiusPressureFree() {
        return depressionRadiusPressureFree;
    }

    public void setDepressionRadiusPressureFree(double depressionRadiusPressureFree) {
        this.depressionRadiusPressureFree = depressionRadiusPressureFree;
    }

    public double getDepressionRadiusPressure() {
        return depressionRadiusPressure;
    }

    public void setDepressionRadiusPressure(double depressionRadiusPressure) {
        this.depressionRadiusPressure = depressionRadiusPressure;
    }

    public double getDepressionRadiusPhreatic() {
        return depressionRadiusPhreatic;
    }

    public void setDepressionRadiusPhreatic(double depressionRadiusPhreatic) {
        this.depressionRadiusPhreatic = depressionRadiusPhreatic;
    }

    public double getLoweringOfWaterFunctionCircle() {
        return loweringOfWaterFunctionCircle;
    }

    public void setLoweringOfWaterFunctionCircle(double loweringOfWaterFunctionCircle) {
        this.loweringOfWaterFunctionCircle = loweringOfWaterFunctionCircle;
    }

    public double getTotalSystemInflow() {
        return totalSystemInflow;
    }

    public void setTotalSystemInflow(double totalSystemInflow) {
        this.totalSystemInflow = totalSystemInflow;
    }

    public double getCapacityOfLoweringWell() {
        return capacityOfLoweringWell;
    }

    public void setCapacityOfLoweringWell(double capacityOfLoweringWell) {
        this.capacityOfLoweringWell = capacityOfLoweringWell;
    }

    public double getLengthOfFilter() {
        return lengthOfFilter;
    }

    public void setLengthOfFilter(double lengthOfFilter) {
        this.lengthOfFilter = lengthOfFilter;
    }

}











