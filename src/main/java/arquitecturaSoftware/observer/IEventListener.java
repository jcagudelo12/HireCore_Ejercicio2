package arquitecturaSoftware.observer;

import arquitecturaSoftware.model.FichaContratacionModel;

public interface IEventListener {
    public void update(String evento, FichaContratacionModel ficha);
}
