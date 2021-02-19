package edu.pucmm.eict.util;

import io.javalin.Javalin;

public class Login {
    private Javalin app;

    public Login(Javalin app) {
        this.app = app;
    }

    public void ejecutarRuta(){

        app.get("/principal",ctx -> {
            Usuario usuario = ctx.sessionAttribute("usuario");

            if(usuario == null){
                ctx.redirect("/login.html");
            }

            ctx.result("Pagina principal");
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
                ctx.redirect("/principal");
            }
            else{
                ctx.redirect("/401.html");
            }
        });

    }

}
