package ArquitecturaSoftware.state;
import ArquitecturaSoftware.factory.EtapaFactoryConcreta;
import java.util.Set;

public class EstadoOferta implements EtapaState{
    private final EtapaFactoryConcreta fabrica;

    public EstadoOferta(EtapaFactoryConcreta fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "Oferta";
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
        return fabrica.contratado();
    }

    @Override
    public EtapaState rechazar() {
        return fabrica.rechazado();
    }
}
