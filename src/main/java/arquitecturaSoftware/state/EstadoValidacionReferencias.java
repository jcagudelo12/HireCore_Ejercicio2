package arquitecturaSoftware.state;
import arquitecturaSoftware.factory.IEtapaAbstractFactory;
import java.util.Set;

public class EstadoValidacionReferencias implements IEtapaState {
    private final IEtapaAbstractFactory fabrica;

    public EstadoValidacionReferencias(IEtapaAbstractFactory fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "ValidacionReferencias";
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
        return fabrica.oferta();
    }

    @Override
    public IEtapaState rechazar() {
        return fabrica.rechazado();
    }
}
