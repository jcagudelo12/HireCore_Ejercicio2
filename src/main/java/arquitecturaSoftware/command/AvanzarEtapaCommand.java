package arquitecturaSoftware.command;

import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.policyObject.FichaContratacionPolicy;
import arquitecturaSoftware.state.IEtapaState;

public class AvanzarEtapaCommand implements ITransicionCommand{
    private final FichaContratacionPolicy fichaContratacionPolicy;
    private final FichaContratacionModel ficha;
    private IEtapaState etapaAnterior;

    public AvanzarEtapaCommand(FichaContratacionPolicy fichaContratacionPolicy, FichaContratacionModel ficha) {
        this.fichaContratacionPolicy = fichaContratacionPolicy;
        this.ficha = ficha;
    }

    @Override
    public void ejecutar() {
        etapaAnterior = ficha.getEtapa();
        fichaContratacionPolicy.avanzarEtapa(ficha);
    }

    @Override
    public void deshacer() {
        if (etapaAnterior != null){
            ficha.setEtapa(etapaAnterior);
        }
    }
}
