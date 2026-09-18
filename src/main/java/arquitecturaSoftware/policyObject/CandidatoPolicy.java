package arquitecturaSoftware.policyObject;

import arquitecturaSoftware.model.CandidatoModel;
import arquitecturaSoftware.model.FichaContratacionModel;

import java.util.Set;

public class CandidatoPolicy implements IPermisosPolicy {
    private final Set<String> camposVisibles;

    public CandidatoPolicy(FichaContratacionModel fichaContratacionModel, CandidatoModel candidato) {
        boolean esSuFicha = fichaContratacionModel.getCandidato() == candidato;
        this.camposVisibles = esSuFicha ? Set.of("Nombre", "Apellidos", "Email", "FechaNacimiento", "Profesion", "Etapa", "Cargo") : Set.of();
    }

    @Override
    public boolean puedeLeer(String campo) {
        return camposVisibles.contains(campo);
    }

    @Override
    public boolean puedeEscribir(String campo) {
        return false;
    }
}
