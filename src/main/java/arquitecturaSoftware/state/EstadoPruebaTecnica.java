package arquitecturaSoftware.state;
import arquitecturaSoftware.factory.IEtapaAbstractFactory;
import java.util.Set;

public class EstadoPruebaTecnica implements IEtapaState {
    private final IEtapaAbstractFactory fabrica;

    public EstadoPruebaTecnica(IEtapaAbstractFactory fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "Prueba Técnica";
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
        return fabrica.validacionReferencias();
    }

    @Override
    public IEtapaState rechazar() {
        return fabrica.rechazado();
    }
}
