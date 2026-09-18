package arquitecturaSoftware.command;

import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.policyObject.FichaContratacionPolicy;
import arquitecturaSoftware.state.IEtapaState;

public class RechazarEtapaCommand implements ITransicionCommand{
    private FichaContratacionPolicy fichaContratacionPolicy;
    private FichaContratacionModel ficha;
    private IEtapaState etapaAnterior;

    public RechazarEtapaCommand(FichaContratacionPolicy fichaContratacionPolicy, FichaContratacionModel ficha) {
        this.fichaContratacionPolicy = fichaContratacionPolicy;
        this.ficha = ficha;
    }

    @Override
    public void ejecutar() {
        etapaAnterior = ficha.getEtapa();
        fichaContratacionPolicy.rechazarCandidato(ficha);
    }

    @Override
    public void deshacer() {
        if (etapaAnterior != null){
            ficha.setEtapa(etapaAnterior);
        }
    }
}
