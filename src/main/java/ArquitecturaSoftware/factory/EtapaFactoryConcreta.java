package ArquitecturaSoftware.factory;

import ArquitecturaSoftware.state.*;

public class EtapaFactoryConcreta  implements EtapaAbstractFactory{

    @Override
    public EtapaState aplicado() {
        return new EstadoAplicado(this);
    }

    @Override
    public EtapaState entrevista() {
        return new EstadoEntrevista(this);
    }

    @Override
    public EtapaState pruebaTecnica() {
        return new EstadoPruebaTecnica(this);
    }

    @Override
    public EtapaState validacionReferencias() {
        return new EstadoValidacionReferencias(this);
    }

    @Override
    public EtapaState oferta() {
        return new EstadoOferta(this);
    }

    @Override
    public EtapaState contratado() {
        return new EstadoContratado(this);
    }

    @Override
    public EtapaState rechazado() {
        return new EstadoRechazado(this);
    }
}
