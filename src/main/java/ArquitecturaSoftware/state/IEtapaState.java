package ArquitecturaSoftware.state;

import java.util.Set;

public interface IEtapaState {
    public String nombre();
    public Set<String> permisosLectura();
    public Set<String> permisosEscritura();
    public IEtapaState avanzar();
    public IEtapaState rechazar();
}