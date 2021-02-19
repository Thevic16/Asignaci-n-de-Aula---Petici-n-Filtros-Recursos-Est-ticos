package edu.pucmm.eict;

import edu.pucmm.eict.util.Login;
import io.javalin.Javalin;


public class Main {
    public static void main(String[] args) {
        //Creando la instancia del servidor.
        Javalin app = Javalin.create().start(7000);
        app.config.addStaticFiles("/publico");

        new Login(app).ejecutarRuta();
    }

}
