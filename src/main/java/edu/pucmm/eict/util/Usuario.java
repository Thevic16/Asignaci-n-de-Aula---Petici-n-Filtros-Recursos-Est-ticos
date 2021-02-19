package edu.pucmm.eict.util;

public class Usuario {
    private String usuario;
    private String contrasena;

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static boolean autentificar(String usuario, String contrasena){
        boolean ok = false;

        if(usuario.equals("admin") && contrasena.equals("admin")){
            ok = true;
        }
        return ok;
    }
}
