package arquitecturaSoftware.policyObject;

public interface IPermisosPolicy {
    public boolean puedeLeer(String campo);
    public boolean puedeEscribir(String campo);
}
