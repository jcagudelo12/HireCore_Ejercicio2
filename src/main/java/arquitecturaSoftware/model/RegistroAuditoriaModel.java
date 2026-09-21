package arquitecturaSoftware.model;

import java.time.LocalDateTime;

public record RegistroAuditoriaModel(
        LocalDateTime momento,
        String usuario,
        String ficha,
        String evento,
        String etapaAnterior,
        String etapaNueva
) {
    @Override
    public String toString() {
        return momento + " | " + usuario + " | " + ficha + " | " + evento
                + " | " + etapaAnterior + " -> " + etapaNueva;
    }
}