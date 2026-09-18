package arquitecturaSoftware.factory;

import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.policyObject.IPermisosPolicy;

public interface IFichaContratacionPolicyFactory {
    public IPermisosPolicy crearPolitica(FichaContratacionModel ficha, String idUsuario);
}
