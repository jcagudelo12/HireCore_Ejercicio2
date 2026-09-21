package arquitecturaSoftware.observer;

import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.state.IEtapaState;

public interface IEventListener {
    public void update(String evento, FichaContratacionModel ficha, EmpleadoModel actor, IEtapaState etapaAnterior);
}
