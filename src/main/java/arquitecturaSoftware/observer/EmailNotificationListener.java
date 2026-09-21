package arquitecturaSoftware.observer;

import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.state.IEtapaState;

public class EmailNotificationListener implements IEventListener{
    private final String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String evento, FichaContratacionModel ficha, EmpleadoModel actor, IEtapaState etapaAnterior) {
        System.out.println("[EMAIL a " + email + "] " + evento + ": " + ficha.getCandidato().getNombreCompleto()
                + " " + etapaAnterior.nombre() + " -> " + ficha.getEtapa().nombre()
                + " (por " + actor.getNombreCompleto() + ")");
    }
}
