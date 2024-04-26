package model;

import static org.junit.jupiter.api.Assertions.*;

class MainFunctionsTest {
    MainFunctions mainFunctions = new MainFunctions();

    @org.junit.jupiter.api.Test
    void pressureInTheFieldOfNutrition() {
        double result = mainFunctions.pressureInTheFieldOfNutrition(100, 50);
        assert.Equals(50, result);
    }

    @org.junit.jupiter.api.Test
    void loweringOfTheGroundwaterLevel() {
        double result = mainFunctions.loweringOfTheGroundwaterLevel(100, 50);
        assert.Equals(50, result);
    }

    @org.junit.jupiter.api.Test
    void loweringOfWaterInPressureMode() {
        double result = mainFunctions.loweringOfWaterInPressureMode(100, 50);
        assert.Equals(50, result);
    }

    @org.junit.jupiter.api.Test
    void loweringOfWaterInNonPressureMode() {
        double result = mainFunctions.loweringOfWaterInNonPressureMode(100, 50);
        assert.Equals(50, result);
    }

    @org.junit.jupiter.api.Test
    void pressureInTheCenterOfTheSystem() {
        double result = mainFunctions.pressureInTheCenterOfTheSystem(100, 50);
        assert.Equals(50, result);
    }

    @org.junit.jupiter.api.Test
    void theThicknessOfTheAquifer() {
        double result = mainFunctions.theThicknessOfTheAquifer(100, 50);
        assert.Equals(50, result);
    }

    @org.junit.jupiter.api.Test
    void theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration() {
        double result = mainFunctions.theAverageDepthOfTheFiltrationFloDuringPressureFreeFiltration(10, 5,3,2);
        assert.Equals(12.50, result);
    }

    @org.junit.jupiter.api.Test
    void theAverageDepthOfTheFiltrationFloDuringPheatricFiltration() {
        double result = mainFunctions.theAverageDepthOfTheFiltrationFloDuringPheatricFiltration(10, 5);
        assert.Equals(7.50, result);
    }

    @org.junit.jupiter.api.Test
    void theAverageDepthOfTheFiltrationFloDuringPressureFiltration() {
        double result = mainFunctions.theAverageDepthOfTheFiltrationFloDuringPressureFiltration(10);
        assert.Equals(10, result);
    }

    @org.junit.jupiter.api.Test
    void theReducedRadiusOfTheWaterLoweringSystemSQR() {
        double result = mainFunctions.theAverageDepthOfTheFiltrationFloDuringPressureFiltration(10);
        assert.Equals(1.78, result);
    }

    @org.junit.jupiter.api.Test
    void depressionRadiusPressureFree() {
        double result = mainFunctions.depressionRadiusPressureFree(10, 5, 3, 2, 1);
        assert.Equals(32.20, result);
    }

    @org.junit.jupiter.api.Test
    void depressionRadiusPheatric() {
        double result = mainFunctions.depressionRadiusPheatric(10, 5, 3, 2);
        assert.Equals(23.20, result);

    }

    @org.junit.jupiter.api.Test
    void depressionRadiusPressure() {
        double result = mainFunctions.depressionRadiusPressure(10, 5, 3);
        assert.Equals(23.20, result);
    }

    @org.junit.jupiter.api.Test
    void loweringOfWaterFunctionCircle() {
        double result = mainFunctions.loweringOfWaterFunctionCircle(10, 5);
        assert.Equals(0.10, result);
    }

    @org.junit.jupiter.api.Test
    void totalSystemInflow() {
        double result = mainFunctions.totalSystemInflow(10, 5, 3, 2);
        assert.Equals(7.50, result);
    }

    @org.junit.jupiter.api.Test
    void capacityOfLoweringWell() {
        double result = mainFunctions.capacityOfLoweringWell(10, 5);
        assert.Equals(2, result);
    }

    @org.junit.jupiter.api.Test
    void lengthOfFilter() {
        double result = mainFunctions.lengthOfFilter(10, 5, 3);
        assert.Equals(1.33, result);
    }
}