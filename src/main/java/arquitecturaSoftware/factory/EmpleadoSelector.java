package arquitecturaSoftware.factory;

import arquitecturaSoftware.model.EmpleadoModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class EmpleadoSelector {
    private final Map<String, EmpleadoModel> empleados = new HashMap<>();

    public void registrar(String id, EmpleadoModel empleado) {
        empleados.put(id, empleado);
    }

    public EmpleadoModel obtenerPorId(String id) {
        return empleados.get(id);
    }

    public Set<String> ids() {
        return new TreeSet<>(empleados.keySet());
    }
}
