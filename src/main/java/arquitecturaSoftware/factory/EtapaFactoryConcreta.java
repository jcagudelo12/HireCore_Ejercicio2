package arquitecturaSoftware.factory;

import arquitecturaSoftware.state.*;

public class EtapaFactoryConcreta  implements IEtapaAbstractFactory {

    @Override
    public IEtapaState aplicado() {
        return new EstadoAplicado(this);
    }

    @Override
    public IEtapaState entrevista() {
        return new EstadoEntrevista(this);
    }

    @Override
    public IEtapaState pruebaTecnica() {
        return new EstadoPruebaTecnica(this);
    }

    @Override
    public IEtapaState validacionReferencias() {
        return new EstadoValidacionReferencias(this);
    }

    @Override
    public IEtapaState oferta() {
        return new EstadoOferta(this);
    }

    @Override
    public IEtapaState contratado() { return new EstadoContratado(this); }

    @Override
    public IEtapaState rechazado() {
        return new EstadoRechazado(this);
    }
}
