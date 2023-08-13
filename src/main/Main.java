package main;

import controlador.controladorFromPrincipal;
import vista.fromPrincipal;

/**
 *
 * @author Telematico
 */
public class Main {

    public static void main(String[] args) {
        fromPrincipal fp = new fromPrincipal();
        controladorFromPrincipal cp = new controladorFromPrincipal(fp);
    }

}
