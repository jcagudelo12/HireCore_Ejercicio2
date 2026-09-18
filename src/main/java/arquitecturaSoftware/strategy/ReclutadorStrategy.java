package arquitecturaSoftware.strategy;

import java.util.HashSet;
import java.util.Set;

public class ReclutadorStrategy implements IRolStrategy {
    public Set<String> lectura() {
        Set<String> campos = new HashSet<>();
        campos.add("Nombre");
        campos.add("Apellidos");
        campos.add("Email");
        campos.add("FechaNacimiento");
        campos.add("Profesion");
        campos.add("Etapa");
        campos.add("Cargo");
        return campos;
    }

    @Override
    public Set<String> escritura() {
        Set<String> campos = new HashSet<>();
        campos.add("Cargo");
        campos.add("Etapa");
        return campos;
    }
}
