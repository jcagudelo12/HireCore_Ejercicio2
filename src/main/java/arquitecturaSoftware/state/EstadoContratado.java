package arquitecturaSoftware.state;
import arquitecturaSoftware.factory.IEtapaAbstractFactory;
import java.util.Set;

public class EstadoContratado implements IEtapaState {
    private final IEtapaAbstractFactory fabrica;

    public EstadoContratado(IEtapaAbstractFactory fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "Contratado";
    }

    @Override
    public Set<String> permisosLectura() {
        return Set.of("Nombre", "Apellidos", "Email", "FechaNacimiento", "Profesion", "Etapa", "Cargo", "Candidato", "Reclutador");
    }

    @Override
    public Set<String> permisosEscritura() {
        return Set.of();
    }

    @Override
    public IEtapaState avanzar() {
        return fabrica.contratado();
    }

    @Override
    public IEtapaState rechazar() {
        return fabrica.rechazado();
    }
}
