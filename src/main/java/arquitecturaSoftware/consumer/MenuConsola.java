package arquitecturaSoftware.consumer;

import arquitecturaSoftware.model.EmpleadoModel;
import arquitecturaSoftware.model.FichaContratacionModel;
import arquitecturaSoftware.model.RegistroAuditoriaModel;
import arquitecturaSoftware.policyObject.IPermisosPolicy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuConsola {
    private final Consumer consumer;
    private final Scanner scanner = new Scanner(System.in);
    private EmpleadoModel usuario;

    public MenuConsola(Consumer consumer) {
        this.consumer = consumer;
    }

    public void iniciar() {
        try {
            identificarse();
            boolean salir = false;
            while (!salir) {
                mostrarMenu();
                try {
                    switch (leer("Opción: ")) {
                        case "1" -> crearFicha();
                        case "2" -> listarFichas();
                        case "3" -> avanzarEtapa();
                        case "4" -> rechazarCandidato();
                        case "5" -> deshacerUltimo();
                        case "6" -> consultarPermiso();
                        case "7" -> identificarse();
                        case "8" -> verAuditoria();
                        case "0" -> salir = true;
                        default -> IO.println("Opción no válida");
                    }
                } catch (SecurityException | IllegalArgumentException e) {
                    IO.println("Error: " + e.getMessage());
                }
            }
        } catch (NoSuchElementException e) {
            // Entrada cerrada (Ctrl+D): salimos sin error
        }
        IO.println("Hasta luego");
    }

    private void mostrarMenu() {
        IO.println("");
        IO.println("=== HireCore === Usuario: " + usuario.getNombreCompleto() + " (" + usuario.getCargo() + ")");
        IO.println("1. Crear ficha de contratación");
        IO.println("2. Listar fichas");
        IO.println("3. Avanzar etapa");
        IO.println("4. Rechazar candidato");
        IO.println("5. Deshacer último cambio");
        IO.println("6. Consultar permiso sobre un campo");
        IO.println("7. Cambiar de usuario");
        IO.println("8. Ver auditoría de cambios");
        IO.println("0. Salir");
    }

    private void identificarse() {
        IO.println("Empleados disponibles: " + consumer.idsEmpleados());
        EmpleadoModel encontrado = null;
        while (encontrado == null) {
            encontrado = consumer.buscarEmpleado(leer("Id de empleado: "));
            if (encontrado == null) {
                IO.println("Empleado no encontrado");
            }
        }
        usuario = encontrado;
    }

    private void crearFicha() {
        IO.println("Candidatos disponibles: " + consumer.idsCandidatos());
        String idCandidato = leer("Id de candidato: ");
        String cargo = leer("Cargo: ");
        consumer.crearFicha(idCandidato, usuario, cargo);
        IO.println("Ficha creada");
    }

    private void listarFichas() {
        List<FichaContratacionModel> fichas = consumer.getFichas();
        if (fichas.isEmpty()) {
            IO.println("No hay fichas");
            return;
        }
        for (int i = 0; i < fichas.size(); i++) {
            FichaContratacionModel f = fichas.get(i);
            IPermisosPolicy politica = consumer.consultarPolitica(f, usuario);
            // "Nombre" cubre nombre completo: en este proyecto ningún rol lee Apellidos sin leer también Nombre
            IO.println((i + 1) + ". " + campo(politica, "Nombre", f.getCandidato().getNombreCompleto())
                    + " | " + campo(politica, "Cargo", f.getCargo())
                    + " | Etapa: " + campo(politica, "Etapa", f.getEtapa().nombre())
                    + " | Reclutador: " + campo(politica, "Reclutador", f.getReclutador().getNombreCompleto()));
        }
    }

    private String campo(IPermisosPolicy politica, String nombreCampo, String valor) {
        return politica.puedeLeer(nombreCampo) ? valor : "[oculto]";
    }

    private void avanzarEtapa() {
        FichaContratacionModel ficha = seleccionarFicha();
        consumer.avanzarEtapa(usuario, ficha);
        IO.println("Nueva etapa: " + ficha.getEtapa().nombre());
    }

    private void rechazarCandidato() {
        FichaContratacionModel ficha = seleccionarFicha();
        consumer.rechazarEtapa(usuario, ficha);
        IO.println("Nueva etapa: " + ficha.getEtapa().nombre());
    }

    private void deshacerUltimo() {
        FichaContratacionModel ficha = seleccionarFicha();
        IO.println(consumer.deshacer(usuario, ficha) ? "Último cambio deshecho" : "No hay cambios que deshacer");
    }

    private void consultarPermiso() {
        FichaContratacionModel ficha = seleccionarFicha();
        IO.println("Usuarios: empleados " + consumer.idsEmpleados() + ", candidatos " + consumer.idsCandidatos());
        String idUsuario = leer("Id de usuario a consultar: ");
        String campo = leer("Campo (Nombre, Apellidos, Email, FechaNacimiento, Profesion, Etapa, Cargo, Candidato, Reclutador): ");
        IPermisosPolicy politica = consumer.consultarPolitica(ficha, idUsuario);
        IO.println("Puede leer: " + politica.puedeLeer(campo) + " | Puede escribir: " + politica.puedeEscribir(campo));
    }

    private FichaContratacionModel seleccionarFicha() {
        List<FichaContratacionModel> fichas = consumer.getFichas();
        if (fichas.isEmpty()) {
            throw new IllegalArgumentException("No hay fichas creadas");
        }
        listarFichas();
        String texto = leer("Número de ficha: ");
        try {
            int numero = Integer.parseInt(texto);
            if (numero < 1 || numero > fichas.size()) {
                throw new IllegalArgumentException("La ficha " + numero + " no existe");
            }
            return fichas.get(numero - 1);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'" + texto + "' no es un número");
        }
    }

    private String leer(String mensaje) {
        IO.print(mensaje);
        return scanner.nextLine().trim();
    }

    private void verAuditoria() {
        List<RegistroAuditoriaModel> registros = consumer.getAuditoria();
        if (registros.isEmpty()) {
            IO.println("No hay cambios registrados");
            return;
        }
        for (RegistroAuditoriaModel registro : registros) {
            IO.println(registro.toString());
        }
    }


}
