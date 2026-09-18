package arquitecturaSoftware.command;

import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.model.HistorialCambiosModel;
import arquitecturaSoftware.observer.EventManager;
import arquitecturaSoftware.policyObject.FichaContratacionPolicy;

public class FichaContratacionController {
    private final HistorialCambiosModel historial;
    private final EventManager eventManager;

    public FichaContratacionController(HistorialCambiosModel historial, EventManager eventManager) {
        this.historial = historial;
        this.eventManager = eventManager;
    }

    public void avanzarEtapa(EmpleadoModel empleado, FichaContratacionModel ficha){
        FichaContratacionPolicy policy = crearPolitica(empleado, ficha);
        historial.ejecutar(new AvanzarEtapaCommand(policy, ficha));
    }

    public void rechazarEtapa(EmpleadoModel empleado, FichaContratacionModel ficha){
        FichaContratacionPolicy policy = crearPolitica(empleado, ficha);
        historial.ejecutar(new RechazarEtapaCommand(policy, ficha));
    }

    public boolean deshacer() {
        return historial.deshacerUltimo();
    }

    private FichaContratacionPolicy crearPolitica(EmpleadoModel empleado, FichaContratacionModel ficha){
        return new FichaContratacionPolicy(empleado.getRol(), ficha.getEtapa(), eventManager);
    }
}
