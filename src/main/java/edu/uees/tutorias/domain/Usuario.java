package edu.uees.tutorias.domain;

public abstract class Usuario {
    protected String id;
    protected String nombre;
    protected String email;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
}