package arquitecturaSoftware.consumer;

import arquitecturaSoftware.command.FichaContratacionController;
import arquitecturaSoftware.factory.CandidatoSelector;
import arquitecturaSoftware.factory.EmpleadoSelector;
import arquitecturaSoftware.factory.EtapaFactoryConcreta;
import arquitecturaSoftware.factory.FichaContratacionPolicyFactory;
import arquitecturaSoftware.factory.IFichaContratacionPolicyFactory;
import arquitecturaSoftware.model.CandidatoModel;
import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.observer.EmailNotificationListener;
import arquitecturaSoftware.observer.EventManager;
import arquitecturaSoftware.policyObject.IPermisosPolicy;
import arquitecturaSoftware.model.RegistroAuditoriaModel;
import arquitecturaSoftware.observer.AuditoriaListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Consumer {
    private final EmpleadoSelector empleados = new EmpleadoSelector();
    private final CandidatoSelector candidatos = new CandidatoSelector();
    private final EtapaFactoryConcreta fabricaEtapas = new EtapaFactoryConcreta();
    private final List<FichaContratacionModel> fichas = new ArrayList<>();
    private final FichaContratacionController controller;
    private final IFichaContratacionPolicyFactory policyFactory;
    private final AuditoriaListener auditoria = new AuditoriaListener();

    public Consumer() {
        EventManager eventos = new EventManager();
        eventos.subscribe("ETAPA_AVANZADA", new EmailNotificationListener("rrhh@hirecore.com"));
        eventos.subscribe("CANDIDATO_RECHAZADO", new EmailNotificationListener("rrhh@hirecore.com"));
        eventos.subscribe("ETAPA_AVANZADA", auditoria);
        eventos.subscribe("CANDIDATO_RECHAZADO", auditoria);
        eventos.subscribe("ETAPA_AVANZADA", auditoria);
        eventos.subscribe("CANDIDATO_RECHAZADO", auditoria);
        eventos.subscribe("CAMBIO_DESHECHO", auditoria);

        this.controller = new FichaContratacionController(eventos);
        this.policyFactory = new FichaContratacionPolicyFactory(empleados, candidatos, eventos);
    }

    // Puntos de entrada de los datos externos al software
    public void registrarEmpleado(String id, EmpleadoModel empleado) {
        empleados.registrar(id, empleado);
    }

    public void registrarCandidato(String id, CandidatoModel candidato) {
        candidatos.registrar(id, candidato);
    }

    public void iniciar() {
        new MenuConsola(this).iniciar();
    }

    // Consultas
    public EmpleadoModel buscarEmpleado(String id) {
        return empleados.obtenerPorId(id);
    }

    public Set<String> idsEmpleados() {
        return empleados.ids();
    }

    public Set<String> idsCandidatos() {
        return candidatos.ids();
    }

    public List<FichaContratacionModel> getFichas() {
        return List.copyOf(fichas);
    }

    public IPermisosPolicy consultarPolitica(FichaContratacionModel ficha, String idUsuario) {
        return policyFactory.crearPolitica(ficha, idUsuario);
    }

    // Operaciones sobre fichas
    public FichaContratacionModel crearFicha(String idCandidato, EmpleadoModel empleado, String cargo) {
        CandidatoModel candidato = candidatos.obtenerPorId(idCandidato);
        if (candidato == null) {
            throw new IllegalArgumentException("Candidato no registrado: " + idCandidato);
        }
        FichaContratacionModel ficha = new FichaContratacionModel(fabricaEtapas.aplicado(), candidato, empleado, cargo);
        fichas.add(ficha);
        return ficha;
    }

    public void avanzarEtapa(EmpleadoModel empleado, FichaContratacionModel ficha) {
        controller.avanzarEtapa(empleado, ficha);
    }

    public void rechazarEtapa(EmpleadoModel empleado, FichaContratacionModel ficha) {
        controller.rechazarEtapa(empleado, ficha);
    }

    public boolean deshacer(EmpleadoModel empleado, FichaContratacionModel ficha) {
        return controller.deshacer(empleado, ficha);
    }

    public List<RegistroAuditoriaModel> getAuditoria() {
        return auditoria.getRegistros();
    }
}
