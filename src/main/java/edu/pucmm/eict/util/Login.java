package edu.pucmm.eict.util;

import io.javalin.Javalin;

public class Login {
    private Javalin app;

    public Login(Javalin app) {
        this.app = app;
    }

    public void ejecutarRuta(){

        app.get("/",ctx -> {
            Usuario usuario = ctx.sessionAttribute("usuario");

            if(usuario == null){
                ctx.redirect("/login.html");
            }
            else {
                ctx.redirect("/index.html");
            }

            //ctx.cookie("usuario","usuario",240);
            //ctx.sessionAttribute("usuario",usuario);
        });

        app.post("/autenticar", ctx -> {
            Usuario usuario = null;
            String nombreUsuario = ctx.formParam("usuario");
            String contrasena = ctx.formParam("password");

            if(Usuario.autentificar(nombreUsuario,contrasena)){
                 usuario = new Usuario(nombreUsuario,contrasena);
                ctx.sessionAttribute("usuario", usuario);
                ctx.redirect("/");
            }
            else{
                ctx.redirect("/401.html");
            }
        });

    }

}
