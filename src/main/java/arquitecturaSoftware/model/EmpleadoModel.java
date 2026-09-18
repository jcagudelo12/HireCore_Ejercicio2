package arquitecturaSoftware.model;

import arquitecturaSoftware.strategy.IRolStrategy;

public class EmpleadoModel {
    private String nombre;
    private String apellidos;
    private String email;
    private String cargo;
    private IRolStrategy rol;

    public EmpleadoModel(String nombre, String apellidos, String email, String cargo, IRolStrategy rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.cargo = cargo;
        this.rol = rol;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getCargo() {
        return cargo;
    }

    public IRolStrategy getRol() {
        return rol;
    }
}
