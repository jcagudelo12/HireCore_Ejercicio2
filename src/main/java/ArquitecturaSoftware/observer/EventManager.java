package ArquitecturaSoftware.observer;

import ArquitecturaSoftware.model.FichaContratacionModel;

import java.util.List;
import java.util.Map;

public class EventManager {
    private final Map<String, List<IEventListener>> listeners;

    public EventManager(Map<String, List<IEventListener>> listeners) {
        this.listeners = listeners;
    }

    public void subscribe(String evento, IEventListener listener){

    }

    public void unsubscribe(String evento, IEventListener listener){

    }

    public void notifyEvent(String evento, FichaContratacionModel ficha){

    }
}
