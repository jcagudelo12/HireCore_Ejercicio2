package ArquitecturaSoftware.state;
import ArquitecturaSoftware.factory.EtapaFactoryConcreta;
import java.util.Set;

public class EstadoValidacionReferencias implements EtapaState{
    private final EtapaFactoryConcreta fabrica;

    public EstadoValidacionReferencias(EtapaFactoryConcreta fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "ValidacionReferencias";
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
        return fabrica.oferta();
    }

    @Override
    public EtapaState rechazar() {
        return fabrica.rechazado();
    }
}
