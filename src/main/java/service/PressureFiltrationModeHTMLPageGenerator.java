package service;


import model.Input;
import model.Output;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static service.ParseBD.getVariableValue;

public class PressureFiltrationModeHTMLPageGenerator {
    private Input input;
    private Output output;
    private String pathInDB = "src/main/resources/BD1.txt";    // путь к файлу, в который сохраняются результаты расчёта и исходные данные
    private String pathForSaveInHTMLFile = "Напорная фильтрация.html"; //путь к файлу, в который сохраняется сгенерированный HTML документ
    SaveInHTMLFile save = new SaveInHTMLFile();

    //Метод замены точки на запятую при генерации HTML файла
    public String dotReplace(double num) {
        return String.valueOf(num).replace('.', ',');
    }

    //Метод генерации HTML файла
    public void pressureFreeFiltrationModeHTMLPageGenerator() {

        try {
            String content = new String(Files.readAllBytes(Paths.get(pathInDB)));
            input = new Input((getVariableValue(content, "waterReductionArea")),
                    (getVariableValue(content, "filterDiameter")),
                    (getVariableValue(content, "markOfTheUpperWaterBarrier")),
                    (getVariableValue(content, "theMarkOfTheLowerWaterBarrier")),
                    (getVariableValue(content, "markOfThDowngradeLevel")),
                    (getVariableValue(content, "markingOfTheGroundwaterLevel")),
                    (getVariableValue(content, "filtrationCoefficient")),
                    (getVariableValue(content, "numberOfWaterLoweringWells")),
                    (getVariableValue(content, "wellPitch")));
            output = new Output((getVariableValue(content, "pressureInTheFieldOfNutrition")),
                    (getVariableValue(content, "loweringOfTheGroundwaterLevel")),
                    (getVariableValue(content, "theThicknessOfTheAquifer")),
                    (getVariableValue(content, "theAverageDepthOfTheFiltrationFloDuringPressureFiltration")),
                    (getVariableValue(content, "theReducedRadiusOfTheWaterLoweringSystemSQR")),
                    (getVariableValue(content, "depressionRadiusPressure")),
                    (getVariableValue(content, "loweringOfWaterFunctionCircle")),
                    (getVariableValue(content, "totalSystemInflow")),
                    (getVariableValue(content, "capacityOfLoweringWell")),
                    (getVariableValue(content, "lengthOfFilter")));




        } catch (IOException e) {
            System.out.println("An error occurred while reading variables from file.");
            e.printStackTrace();
        }

        String htmlContent = "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Строительное водопонижение</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Строительное водопонижение</h2>\n" +
                "<h3>Исходные данные: </h3>\n" +
                "<ul>\n" +
                "<li>Площадь, ограниченная контуром водопонижения: A = " + dotReplace(input.getWaterReductionArea()) + " м<sup>2</sup>;</li>\n" +
                "<li>Диаметр фильтра: d<sub>h</sub> = " + dotReplace(input.getFilterDiameter()) + " мм;</li>\n" +
                "<li>Отметка верхнего водоупора: " + dotReplace(input.getMarkOfTheUpperWaterBarrier()) + " м;</li>\n" +
                "<li>Отметка нижнего водоупора : " + dotReplace(input.getTheMarkOfTheLowerWaterBarrier()) + " м;</li>\n" +
                "<li>Отметка уровня понижения : " + dotReplace(input.getMarkOfThDowngradeLevel()) + " м;</li>\n" +
                "<li>Отметка уровня подземных вод : " + dotReplace(input.getMarkingOfTheGroundwaterLevel()) + " м;</li>\n" +
                "<li>Коэффициент фильтрации : " + dotReplace(input.getFiltrationCoefficient()) + " м/сут;</li>\n" +
                "<li>Количество водопонизительных скважин : " + dotReplace(input.getNumberOfWaterLoweringWells()) + " шт.;</li>\n" +
                "<li>Шаг скважин : " + dotReplace(input.getWellPitch()) + " м;</li>\n" +
                "</ul>\n" +
                "<h3>1.Определение притока при установившемся режиме фильтрации:</h3>\n" +
                "<ul>\n" +
                "<li>Напор в области питания: H = " + dotReplace(input.getMarkingOfTheGroundwaterLevel()) + " – " + dotReplace(input.getTheMarkOfTheLowerWaterBarrier()) + " = " + dotReplace(output.getPressureInTheFieldOfNutrition()) + " м;</li>\n" +
                "</ul>\n" +
                "<h3>2. Расчёт системы водопонижения при напорной фильтрации:</h3>\n" +
                "<ul>\n" +
                "<li>Понижение уровня подземных вод в центре системы: S = " + dotReplace(input.getMarkingOfTheGroundwaterLevel()) + " – " + dotReplace(input.getMarkOfThDowngradeLevel()) + " = " + dotReplace(output.getLoweringOfTheGroundwaterLevel()) + " м;</li>\n" +

                "<li>Мощность водоносного слоя: h<sub>pl</sub> = " + dotReplace(input.getMarkOfTheUpperWaterBarrier()) + " – " + dotReplace(input.getTheMarkOfTheLowerWaterBarrier()) + " = " + dotReplace(output.getTheThicknessOfTheAquifer()) + " м;</li>\n" +
                "<li>Средняя глубина фильтрационного потока при напорной фильтрации:</li>" +
                "h = h<sub>pl</sub>  = " + dotReplace(output.getTheAverageDepthOfTheFiltrationFloDuringPressureFiltration()) + " м\n" +
                "<li>Приведенный радиус водопонизительной системы: r = (A / π)<sup>0,5</sup> = (" + dotReplace(input.getWaterReductionArea()) + "/ π)<sup>0,5</sup> = " + dotReplace(output.getTheReducedRadiusOfTheWaterLoweringSystemSQR()) + " м</li>\n" +
                "<li>Радиус депрессии:</li>" +
                "r<sub>d</sub> = r + 10Sp ‧ k<sup>0,5</sup>  = " + dotReplace(output.getTheReducedRadiusOfTheWaterLoweringSystemSQR()) + " + " + "10" + " ‧ " + dotReplace(output.getLoweringOfTheGroundwaterLevel()) + " ‧ " + dotReplace(input.getFiltrationCoefficient()) + "<sup>0,5</sup>" + " = " + dotReplace(output.getDepressionRadiusPressure()) + " м;\n" +
                "<li>Функция понижения от действия водопонизительной системы:</li>" +
                "Ф = (ln(r<sub>d</sub> / r)) / 2 π = (ln(" + dotReplace(output.getDepressionRadiusPressure()) + " / " + dotReplace(output.getTheReducedRadiusOfTheWaterLoweringSystemSQR()) + ")) / 2 π" + " = " + dotReplace(output.getLoweringOfWaterFunctionCircle()) + ";\n" +
                "<li>Полный приток подземных вод к системе:</li>" +
                "Q = khS / Ф = " + dotReplace(input.getFiltrationCoefficient()) + " ‧ " + dotReplace(output.getTheAverageDepthOfTheFiltrationFloDuringPressureFiltration()) + " ‧ " + dotReplace(output.getLoweringOfTheGroundwaterLevel()) + " / " + dotReplace(output.getLoweringOfWaterFunctionCircle()) + " = " + dotReplace(output.getTotalSystemInflow()) + " м<sup>3</sup>/сут;\n" +
                "<li>Производительность скважины: q<sub>h</sub> = " + dotReplace(output.getTotalSystemInflow()) + " / " + dotReplace(input.getNumberOfWaterLoweringWells()) + " = " + dotReplace(output.getCapacityOfLoweringWell()) + " м<sup>3</sup>/сут </li>\n" +
                "<li>Длина действующей части фильтра:</li>" +
                "l<sub>f</sub> = q<sub>h</sub> / 400r<sub>h</sub>k<sup>1/3</sup> = " + dotReplace(output.getCapacityOfLoweringWell()) + " / (" + "400" + " ‧ " + dotReplace(input.getFilterDiameter() / 2000) + " ‧ " + dotReplace(input.getFiltrationCoefficient()) + "<sup> 1/3</sup>) = " + dotReplace(output.getLengthOfFilter()) + " м;\n" +
                "</ul>\n" +
                "</body>\n" +
                "</html>";


        //Сохраняем полученную страницу HTML
        save.saveInHTMLFile(pathForSaveInHTMLFile, htmlContent);

    }
}