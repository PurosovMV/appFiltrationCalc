import controller.ControllerForGeneratorPageHTML;

import controller.PhreaticFiltrationModeController;
import controller.PressureFiltrationModeController;
import controller.PressureFreeFiltrationModeController;
import view.View;

public class Main {
    public static void main(String[] args) {


        ControllerForGeneratorPageHTML controllerForGeneratorPageHTML = new ControllerForGeneratorPageHTML();
        PressureFreeFiltrationModeController pressureFreeFiltrationModeController = new PressureFreeFiltrationModeController();
        PressureFiltrationModeController pressureFiltrationModeController = new PressureFiltrationModeController();
        PhreaticFiltrationModeController  phreaticFiltrationModeController = new PhreaticFiltrationModeController();
        View view = new View(controllerForGeneratorPageHTML, pressureFreeFiltrationModeController, pressureFiltrationModeController, phreaticFiltrationModeController);
        view.run();


    }
}