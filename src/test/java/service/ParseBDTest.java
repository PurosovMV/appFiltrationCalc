package service;

import static org.junit.jupiter.api.Assertions.*;

class ParseBDTest {
    ParseBD parseBD = new ParseBD();
    @org.junit.jupiter.api.Test
    void getVariableValue() {

        String content = "variable1 = 10.5\nvariable2 = 20.3\nvariable3 = 15.7";
        String variableName1 = "variable1";
        String variableName2 = "variable2";
        String variableName3 = "variable3";

        double result1 = ParseBD.getVariableValue(content, variableName1);
        assertEquals(10.5, result1);

    }
}