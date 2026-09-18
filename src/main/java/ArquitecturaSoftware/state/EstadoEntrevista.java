package ArquitecturaSoftware.state;
import ArquitecturaSoftware.factory.EtapaFactoryConcreta;
import java.util.Set;

public class EstadoEntrevista implements IEtapaState {
    private final EtapaFactoryConcreta fabrica;

    public EstadoEntrevista(EtapaFactoryConcreta fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "Entrevista";
    }

    @Override
    public Set<String> permisosLectura() {
        return Set.of("Nombre", "Apellidos", "Email", "FechaNacimiento", "Profesion");
    }

    @Override
    public Set<String> permisosEscritura() {
        return Set.of("Nombre", "Apellidos", "Email", "FechaNacimiento", "Profesion");
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
