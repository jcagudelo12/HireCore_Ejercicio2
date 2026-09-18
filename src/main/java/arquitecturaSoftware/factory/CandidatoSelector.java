package arquitecturaSoftware.factory;

import arquitecturaSoftware.model.CandidatoModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CandidatoSelector {
    private final Map<String, CandidatoModel> candidatos = new HashMap<>();

    public void registrar(String id, CandidatoModel candidato) {
        candidatos.put(id, candidato);
    }

    public boolean esCandidato(String id) {
        return candidatos.containsKey(id);
    }

    public CandidatoModel obtenerPorId(String id) {
        return candidatos.get(id);
    }

    public Set<String> ids() {
        return new TreeSet<>(candidatos.keySet());
    }
}
