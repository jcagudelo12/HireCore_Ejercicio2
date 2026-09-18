package arquitecturaSoftware.model;

import java.util.Date;

public class CandidatoModel {
    private String nombre;
    private String apellidos;
    private String email;
    private Date fechaNacimiento;
    private String profesion;

    public CandidatoModel(String nombre, String apellidos, String email, Date fechaNacimiento, String profesion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.profesion = profesion;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public String getEmail() {
        return email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getProfesion() {
        return profesion;
    }
}
