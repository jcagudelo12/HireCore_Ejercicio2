package ArquitecturaSoftware.observer;

import ArquitecturaSoftware.model.FichaContratacionModel;

public interface IEventListener {
    public void update(String evento, FichaContratacionModel ficha);
}
