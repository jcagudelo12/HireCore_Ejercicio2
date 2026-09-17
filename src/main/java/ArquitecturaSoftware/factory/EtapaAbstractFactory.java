package ArquitecturaSoftware.factory;

import ArquitecturaSoftware.state.EtapaState;

public interface EtapaAbstractFactory {
    public EtapaState aplicado();
    public EtapaState entrevista();
    public EtapaState pruebaTecnica();
    public EtapaState validacionReferencias();
    public EtapaState oferta();
    public EtapaState contratado();
    public EtapaState rechazado();
}
