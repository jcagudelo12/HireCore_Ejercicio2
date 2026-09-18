package ArquitecturaSoftware.policyObject;

import ArquitecturaSoftware.state.IEtapaState;
import ArquitecturaSoftware.strategy.IRolStrategy;

public class FichaContratacionPolicy implements PermisosPolicy{
    private IRolStrategy rol;
    private IEtapaState etapa;
    private EventManager eventManager;

    public FichaContratacionPolicy(IRolStrategy rol, IEtapaState etapa, EventManager eventManager) {
        this.rol = rol;
        this.etapa = etapa;
        this.eventManager = eventManager;
    }

    @Override
    public boolean puedeLeer(String campo) {
        return false;
    }

    @Override
    public boolean puedeEscribir(String campo) {
        return false;
    }

    public void avanzarEtapa(FichaContratacion){

    }

    public void rechazarCandidato(FichaContratacion){

    }
}
