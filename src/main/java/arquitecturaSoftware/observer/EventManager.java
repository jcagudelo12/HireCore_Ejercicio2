package arquitecturaSoftware.observer;

import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.state.IEtapaState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private final Map<String, List<IEventListener>> listeners = new HashMap<>();

    public void subscribe(String evento, IEventListener listener){
        listeners.computeIfAbsent(evento, k -> new ArrayList<>()).add(listener);
    }

    public void unsubscribe(String evento, IEventListener listener){
        List<IEventListener> suscritos = listeners.get(evento);
        if (suscritos != null && !suscritos.isEmpty()){
            suscritos.remove(listener);
        }
    }

    public void notifyEvent(String evento, FichaContratacionModel ficha, EmpleadoModel actor, IEtapaState etapaAnterior){
        for (IEventListener listener : new ArrayList<>(listeners.getOrDefault(evento, List.of()))){
            listener.update(evento, ficha, actor, etapaAnterior);
        }
    }
}
