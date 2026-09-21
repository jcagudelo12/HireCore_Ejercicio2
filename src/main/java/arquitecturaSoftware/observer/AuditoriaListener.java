package arquitecturaSoftware.observer;

import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.model.RegistroAuditoriaModel;
import arquitecturaSoftware.state.IEtapaState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Listener del Observer dedicado a dejar constancia de cada cambio: quién, cuándo, dónde y cuál fue el cambio
public class AuditoriaListener implements IEventListener {
    private final List<RegistroAuditoriaModel> registros = new ArrayList<>();

    @Override
    public void update(String evento, FichaContratacionModel ficha, EmpleadoModel actor, IEtapaState etapaAnterior) {
        registros.add(new RegistroAuditoriaModel(
                LocalDateTime.now(),
                actor.getNombreCompleto() + " (" + actor.getCargo() + ")",
                ficha.getCandidato().getNombreCompleto() + " - " + ficha.getCargo(),
                evento,
                etapaAnterior.nombre(),
                ficha.getEtapa().nombre()
        ));
    }

    public List<RegistroAuditoriaModel> getRegistros() {
        return List.copyOf(registros);
    }
}
