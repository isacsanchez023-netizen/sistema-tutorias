package edu.uees.tutorias.domain;

public class Docente extends Usuario {
    private String departamento;

    public Docente(String id, String nombre, String email, String departamento) {
        super(id, nombre, email);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
}