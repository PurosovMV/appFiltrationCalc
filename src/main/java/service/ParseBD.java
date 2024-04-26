package service;
public class ParseBD {
    /**
     * @param content      - контент типа String, который парсим
     * @param variableName - путь к файлу из которого взять контент
     * @return - возвращаем переменные типа double
     */
    //Метод поиска данных
    public static Double getVariableValue(String content, String variableName) {
        String line = content.lines()
                .filter(l -> l.startsWith(variableName))
                .findFirst()
                .orElse("");


        return Double.parseDouble(line.substring(line.indexOf("=") + 1).trim());
    }
}
