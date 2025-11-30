package com.congreso.domain;

public class Congresista {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String pais;

    public Congresista() {
    }

    public Congresista(int id, String nombre, String apellido, String email, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.pais = pais;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}
