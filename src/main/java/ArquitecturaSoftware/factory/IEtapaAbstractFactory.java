package ArquitecturaSoftware.factory;

import ArquitecturaSoftware.state.IEtapaState;

public interface IEtapaAbstractFactory {
    public IEtapaState aplicado();
    public IEtapaState entrevista();
    public IEtapaState pruebaTecnica();
    public IEtapaState validacionReferencias();
    public IEtapaState oferta();
    public IEtapaState contratado();
    public IEtapaState rechazado();
}
