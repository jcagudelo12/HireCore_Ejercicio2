package arquitecturaSoftware.strategy;

import java.util.HashSet;
import java.util.Set;

public class NominaStrategy implements IRolStrategy{
    public Set<String> lectura() {
        Set<String> campos = new HashSet<>();
        campos.add("Nombre");
        campos.add("Apellidos");
        campos.add("Cargo");
        return campos;
    }

    @Override
    public Set<String> escritura() {
        return new HashSet<>();
    }
}
