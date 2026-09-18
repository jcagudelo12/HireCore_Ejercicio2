package arquitecturaSoftware.state;
import arquitecturaSoftware.factory.IEtapaAbstractFactory;
import java.util.Set;

public class EstadoEntrevista implements IEtapaState {
    private final IEtapaAbstractFactory fabrica;

    public EstadoEntrevista(IEtapaAbstractFactory fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "Entrevista";
    }

    @Override
    public Set<String> permisosLectura() {
        return Set.of("Nombre", "Apellidos", "Email", "FechaNacimiento", "Profesion", "Etapa", "Cargo", "Candidato", "Reclutador");
    }

    @Override
    public Set<String> permisosEscritura() {
        return Set.of("Nombre", "Apellidos", "Email", "FechaNacimiento", "Profesion", "Etapa", "Cargo", "Candidato", "Reclutador");
    }

    @Override
    public IEtapaState avanzar() {
        return fabrica.pruebaTecnica();
    }

    @Override
    public IEtapaState rechazar() {
        return fabrica.rechazado();
    }
}
