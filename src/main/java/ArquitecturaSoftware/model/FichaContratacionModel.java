package ArquitecturaSoftware.model;

public class FichaContratacionModel {
    private String etapa;
    private CandidatoModel candidatoModel;
    private ReclutadorModel reclutadorModel;
    private String cargo;

    public FichaContratacionModel(String etapa, CandidatoModel candidatoModel, ReclutadorModel reclutadorModel, String cargo) {
        this.etapa = etapa;
        this.candidatoModel = candidatoModel;
        this.reclutadorModel = reclutadorModel;
        this.cargo = cargo;
    }

    public String getEtapa() {
        return etapa;
    }

    public CandidatoModel getCandidato() {
        return candidatoModel;
    }

    public ReclutadorModel getReclutador() {
        return reclutadorModel;
    }

    public String getCargo() {
        return cargo;
    }
}
