package arquitecturaSoftware.command;

import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.observer.EventManager;
import arquitecturaSoftware.policyObject.FichaContratacionPolicy;
import arquitecturaSoftware.state.IEtapaState;

public class FichaContratacionController {
    private final EventManager eventManager;

    public FichaContratacionController(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public void avanzarEtapa(EmpleadoModel empleado, FichaContratacionModel ficha){
        FichaContratacionPolicy policy = crearPolitica(empleado, ficha);
        ficha.getHistorial().ejecutar(new AvanzarEtapaCommand(policy, ficha));
    }

    public void rechazarEtapa(EmpleadoModel empleado, FichaContratacionModel ficha){
        FichaContratacionPolicy policy = crearPolitica(empleado, ficha);
        ficha.getHistorial().ejecutar(new RechazarEtapaCommand(policy, ficha));
    }

    public boolean deshacer(EmpleadoModel empleado, FichaContratacionModel ficha) {
        IEtapaState etapaAntesDeDeshacer = ficha.getEtapa();
        boolean deshecho = ficha.getHistorial().deshacerUltimo();
        if (deshecho) {
            eventManager.notifyEvent("CAMBIO_DESHECHO", ficha, empleado, etapaAntesDeDeshacer);
        }
        return deshecho;
    }

    private FichaContratacionPolicy crearPolitica(EmpleadoModel empleado, FichaContratacionModel ficha){
        return new FichaContratacionPolicy(empleado, ficha.getEtapa(), eventManager);
    }
}
