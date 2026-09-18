package arquitecturaSoftware.model;

import arquitecturaSoftware.state.IEtapaState;

public class FichaContratacionModel {
    private IEtapaState etapa;
    private CandidatoModel candidato;
    private EmpleadoModel empleado;
    private String cargo;

    public FichaContratacionModel(IEtapaState etapa, CandidatoModel candidato, EmpleadoModel empleado, String cargo) {
        this.etapa = etapa;
        this.candidato = candidato;
        this.empleado = empleado;
        this.cargo = cargo;
    }

    public IEtapaState getEtapa() {
        return etapa;
    }

    public void setEtapa(IEtapaState etapa) {
        this.etapa = etapa;
    }

    public CandidatoModel getCandidato() {
        return candidato;
    }

    public EmpleadoModel getReclutador() {
        return empleado;
    }

    public String getCargo() {
        return cargo;
    }
}
