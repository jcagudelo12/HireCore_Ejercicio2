package ArquitecturaSoftware.state;
import ArquitecturaSoftware.factory.EtapaFactoryConcreta;
import java.util.Set;

public class EstadoPruebaTecnica implements EtapaState{
    private final EtapaFactoryConcreta fabrica;

    public EstadoPruebaTecnica(EtapaFactoryConcreta fabrica){
        this.fabrica = fabrica;
    }

    @Override
    public String nombre() {
        return "Prueba Técnica";
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
        return fabrica.validacionReferencias();
    }

    @Override
    public EtapaState rechazar() {
        return fabrica.rechazado();
    }
}
