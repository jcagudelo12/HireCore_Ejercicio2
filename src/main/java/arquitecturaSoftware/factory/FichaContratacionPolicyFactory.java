package arquitecturaSoftware.factory;

import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.observer.EventManager;
import arquitecturaSoftware.policyObject.CandidatoPolicy;
import arquitecturaSoftware.policyObject.FichaContratacionPolicy;
import arquitecturaSoftware.policyObject.IPermisosPolicy;

public class FichaContratacionPolicyFactory implements IFichaContratacionPolicyFactory {
    private final EmpleadoSelector empleados;
    private final CandidatoSelector candidatos;
    private final EventManager eventManager;

    public FichaContratacionPolicyFactory(EmpleadoSelector empleados, CandidatoSelector candidatos, EventManager eventManager) {
        this.empleados = empleados;
        this.candidatos = candidatos;
        this.eventManager = eventManager;
    }

    @Override
    public IPermisosPolicy crearPolitica(FichaContratacionModel ficha, String idUsuario) {
        if (candidatos.esCandidato(idUsuario)) {
            return new CandidatoPolicy(ficha, candidatos.obtenerPorId(idUsuario));
        }
        EmpleadoModel empleado = empleados.obtenerPorId(idUsuario);
        if (empleado == null) {
            throw new IllegalArgumentException("Usuario desconocido: " + idUsuario);
        }
        return new FichaContratacionPolicy(empleado, ficha.getEtapa(), eventManager);
    }
}