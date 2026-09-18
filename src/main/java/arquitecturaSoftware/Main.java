package arquitecturaSoftware;

import arquitecturaSoftware.consumer.Consumer;
import arquitecturaSoftware.model.CandidatoModel;
import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.strategy.GerenteContratacionStrategy;
import arquitecturaSoftware.strategy.NominaStrategy;
import arquitecturaSoftware.strategy.RecursosHumanosStrategy;
import arquitecturaSoftware.strategy.ReclutadorStrategy;

import java.util.Date;

public class Main {
    static void main() {
        // Datos externos al software
        EmpleadoModel reclutador = new EmpleadoModel("Carlos", "Perez", "carlos@test.com", "Reclutador", new ReclutadorStrategy());
        EmpleadoModel rrhh = new EmpleadoModel("Marta", "Lopez", "marta@test.com", "Recursos Humanos", new RecursosHumanosStrategy());
        EmpleadoModel nomina = new EmpleadoModel("Ana", "Gomez", "ana@test.com", "Nomina", new NominaStrategy());
        EmpleadoModel gerente = new EmpleadoModel("Jorge", "Mora", "jorge@test.com", "Gerente de Contratación", new GerenteContratacionStrategy());
        CandidatoModel laura = new CandidatoModel("Laura", "Ruiz", "laura@test.com", new Date(), "Ingeniera");
        CandidatoModel pedro = new CandidatoModel("Pedro", "Sanz", "pedro@test.com", new Date(), "Analista");

        Consumer consumer = new Consumer();
        consumer.registrarEmpleado("e1", reclutador);
        consumer.registrarEmpleado("e2", rrhh);
        consumer.registrarEmpleado("e3", nomina);
        consumer.registrarEmpleado("e4", gerente);
        consumer.registrarCandidato("c1", laura);
        consumer.registrarCandidato("c2", pedro);
        consumer.iniciar();
    }
}
