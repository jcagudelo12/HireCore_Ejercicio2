package arquitecturaSoftware.model;

import arquitecturaSoftware.state.IEtapaState;

public class FichaContratacionModel {
    private IEtapaState etapa;
    private final CandidatoModel candidato;
    private final EmpleadoModel empleado;
    private String cargo;
    private final HistorialCambiosModel historial = new HistorialCambiosModel();

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

    public HistorialCambiosModel getHistorial() {
        return historial;
    }
}
