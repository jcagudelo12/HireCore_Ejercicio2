package ArquitecturaSoftware.policyObject;

import ArquitecturaSoftware.model.CandidatoModel;
import ArquitecturaSoftware.model.FichaContratacionModel;

import java.util.Set;

public class CandidatoPolicy implements PermisosPolicy{
    private Set<String> camposVisibles(){
        return null;
    }

    public CandidatoPolicy(FichaContratacionModel fichaContratacionModel, CandidatoModel candidatoModel) {
    }

    @Override
    public boolean puedeLeer(String campo) {
        return true;
    }

    @Override
    public boolean puedeEscribir(String campo) {
        return false;
    }
}
