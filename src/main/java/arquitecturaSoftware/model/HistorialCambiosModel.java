package arquitecturaSoftware.model;

import arquitecturaSoftware.command.ITransicionCommand;

import java.util.ArrayDeque;
import java.util.Deque;

public class HistorialCambiosModel {
    private final Deque<ITransicionCommand> pila = new ArrayDeque<>();

    public void ejecutar(ITransicionCommand command) {
        command.ejecutar();
        pila.push(command);
    }

    public boolean deshacerUltimo() {
        if (pila.isEmpty()) {
            return false;
        }
        pila.pop().deshacer();
        return true;
    }
}
