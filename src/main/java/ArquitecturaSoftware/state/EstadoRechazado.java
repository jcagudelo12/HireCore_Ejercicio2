package ArquitecturaSoftware.state;
import ArquitecturaSoftware.factory.EtapaFactoryConcreta;
import java.util.Set;

public class EstadoRechazado implements EtapaState{
    private final EtapaFactoryConcreta fabrica;

    public EstadoRechazado(EtapaFactoryConcreta fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "Rechazado";
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
    public EtapaState avanzar() {
        return fabrica.rechazado();
    }

    @Override
    public EtapaState rechazar() {
        return fabrica.rechazado();
    }
}
