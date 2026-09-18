package arquitecturaSoftware.state;
import arquitecturaSoftware.factory.IEtapaAbstractFactory;
import java.util.Set;

public class EstadoRechazado implements IEtapaState {
    private final IEtapaAbstractFactory fabrica;

    public EstadoRechazado(IEtapaAbstractFactory fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "Rechazado";
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
        return fabrica.rechazado();
    }

    @Override
    public IEtapaState rechazar() {
        return fabrica.rechazado();
    }
}
