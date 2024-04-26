package controller;

import service.PhreaticFiltrationModeHTMLPageGenerator;
import service.PressureFiltrationModeHTMLPageGenerator;
import service.PressureFreeFiltrationModeHTMLPageGenerator;


public class ControllerForGeneratorPageHTML {

    //Генератор страницы HTML  для напорно-безнапорной фильтрации

    PressureFreeFiltrationModeHTMLPageGenerator pressureFreeFiltrationModeHTMLPageGenerator = new PressureFreeFiltrationModeHTMLPageGenerator();

    public void pressureFreeFiltrationModeHTMLPageGenerator() {
        pressureFreeFiltrationModeHTMLPageGenerator.pressureFreeFiltrationModeHTMLPageGenerator();
    }
    //Генератор страницы HTML  для напорной фильтрации

    PressureFiltrationModeHTMLPageGenerator pressureFiltrationModeHTMLPageGenerator = new PressureFiltrationModeHTMLPageGenerator();

    public void pressureFiltrationModeHTMLPageGenerator() {
        pressureFiltrationModeHTMLPageGenerator.pressureFreeFiltrationModeHTMLPageGenerator();
    }
    //Генератор страницы HTML  для безнапорной фильтрации

    PhreaticFiltrationModeHTMLPageGenerator phreaticFiltrationModeHTMLPageGenerator = new PhreaticFiltrationModeHTMLPageGenerator();

    public void phreaticFiltrationModeHTMLPageGenerator() {
        phreaticFiltrationModeHTMLPageGenerator.phreaticFiltrationModeHTMLPageGenerator();
    }


}
