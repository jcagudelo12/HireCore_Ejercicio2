package ArquitecturaSoftware.state;

import java.util.Set;

public interface EtapaState {
    public String nombre();
    public Set<String> permisosLectura();
    public Set<String> permisosEscritura();
    public EtapaState avanzar();
    public EtapaState rechazar();
}