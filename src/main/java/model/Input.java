package model;

public class Input {
    private double waterReductionArea; // Площадь ограниченная контуром водопонижения
    private double filterDiameter; // Диаметр фильтра
    private double markOfTheUpperWaterBarrier; // Отметка верхнего водоупора
    private double theMarkOfTheLowerWaterBarrier;// Отметка нижнего водоупора
    private double markOfThDowngradeLevel;// Отметка уровня понижения грунтовых вод
    private double markingOfTheGroundwaterLevel; // Отметка уровня подземных вод
    private double filtrationCoefficient; // Коэффициент фильтрации
    private double numberOfWaterLoweringWells; // Количество водопонизительных скважин
    private double wellPitch; // Шаг скважин

    public Input(double waterReductionArea, double filterDiameter, double markOfTheUpperWaterBarrier,
            double theMarkOfTheLowerWaterBarrier, double markOfThDowngradeLevel, double markingOfTheGroundwaterLevel,
            double filtrationCoefficient, double numberOfWaterLoweringWells, double wellPitch) {
        this.waterReductionArea = waterReductionArea;
        this.filterDiameter = filterDiameter;
        this.markOfTheUpperWaterBarrier = markOfTheUpperWaterBarrier;
        this.theMarkOfTheLowerWaterBarrier = theMarkOfTheLowerWaterBarrier;
        this.markOfThDowngradeLevel = markOfThDowngradeLevel;
        this.markingOfTheGroundwaterLevel = markingOfTheGroundwaterLevel;
        this.filtrationCoefficient = filtrationCoefficient;
        this.numberOfWaterLoweringWells = numberOfWaterLoweringWells;
        this.wellPitch = wellPitch;
    }


    public double getWaterReductionArea() {
        return waterReductionArea;
    }

    public void setWaterReductionArea(double waterReductionArea) {
        this.waterReductionArea = waterReductionArea;
    }

    public double getFilterDiameter() {
        return filterDiameter;
    }

    public void setFilterDiameter(double filterDiameter) {
        this.filterDiameter = filterDiameter;
    }

    public double getMarkOfTheUpperWaterBarrier() {
        return markOfTheUpperWaterBarrier;
    }

    public void setMarkOfTheUpperWaterBarrier(double markOfTheUpperWaterBarrier) {
        this.markOfTheUpperWaterBarrier = markOfTheUpperWaterBarrier;
    }

    public double getTheMarkOfTheLowerWaterBarrier() {
        return theMarkOfTheLowerWaterBarrier;
    }

    public void setTheMarkOfTheLowerWaterBarrier(double theMarkOfTheLowerWaterBarrier) {
        this.theMarkOfTheLowerWaterBarrier = theMarkOfTheLowerWaterBarrier;
    }

    public double getMarkOfThDowngradeLevel() {
        return markOfThDowngradeLevel;
    }

    public void setMarkOfThDowngradeLevel(double markOfThDowngradeLevel) {
        this.markOfThDowngradeLevel = markOfThDowngradeLevel;
    }

    public double getMarkingOfTheGroundwaterLevel() {
        return markingOfTheGroundwaterLevel;
    }

    public void setMarkingOfTheGroundwaterLevel(double markingOfTheGroundwaterLevel) {
        this.markingOfTheGroundwaterLevel = markingOfTheGroundwaterLevel;
    }

    public double getFiltrationCoefficient() {
        return filtrationCoefficient;
    }

    public void setFiltrationCoefficient(double filtrationCoefficient) {
        this.filtrationCoefficient = filtrationCoefficient;
    }

    public double getNumberOfWaterLoweringWells() {
        return numberOfWaterLoweringWells;
    }

    public void setNumberOfWaterLoweringWells(double numberOfWaterLoweringWells) {
        this.numberOfWaterLoweringWells = numberOfWaterLoweringWells;
    }

    public double getWellPitch() {
        return wellPitch;
    }

    public void setWellPitch(double wellPitch) {
        this.wellPitch = wellPitch;
    }

}