package arquitecturaSoftware.observer;

import arquitecturaSoftware.model.FichaContratacionModel;

public class EmailNotificationListener implements IEventListener{
    private final String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String evento, FichaContratacionModel ficha) {
        System.out.println("[EMAIL a " + email + "] " + evento + ": " + ficha.getCandidato().getNombreCompleto()
                + " -> " + ficha.getEtapa().nombre());
    }

    public void EmailNotificationListener(String email){

    }
}
