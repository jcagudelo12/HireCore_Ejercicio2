package arquitecturaSoftware.policyObject;

import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.observer.EventManager;
import arquitecturaSoftware.state.IEtapaState;
import arquitecturaSoftware.strategy.IRolStrategy;

public class FichaContratacionPolicy implements IPermisosPolicy {
    private final EmpleadoModel actor;
    private final IRolStrategy rol;
    private IEtapaState etapa;
    private final EventManager eventManager;

    public FichaContratacionPolicy(EmpleadoModel actor, IEtapaState etapa, EventManager eventManager) {
        this.actor = actor;
        this.rol = actor.getRol();
        this.etapa = etapa;
        this.eventManager = eventManager;
    }

    // El rol dice QUIÉN puede; la etapa dice CUÁNDO se puede. Hace falta que ambos lo permitan.
    @Override
    public boolean puedeLeer(String campo) {
        return rol.lectura().contains(campo) && etapa.permisosLectura().contains(campo);
    }

    @Override
    public boolean puedeEscribir(String campo) {
        return rol.escritura().contains(campo) && etapa.permisosEscritura().contains(campo);
    }

    public void avanzarEtapa(FichaContratacionModel ficha){
        cambiarEtapa(ficha, ficha.getEtapa().avanzar(), "ETAPA_AVANZADA");
    }

    public void rechazarCandidato(FichaContratacionModel ficha){
        cambiarEtapa(ficha,ficha.getEtapa().rechazar(), "CANDIDATO_RECHAZADO");
    }

    public void cambiarEtapa(FichaContratacionModel ficha, IEtapaState nueva, String evento){
        if (!puedeEscribir("Etapa")){
            throw new SecurityException("No se puede modificar la etapa desde '" + etapa.nombre() + "' con este rol.");
        }

        IEtapaState anterior = this.etapa;
        ficha.setEtapa(nueva);
        this.etapa = nueva;
        eventManager.notifyEvent(evento, ficha, actor, anterior);
    }
}
