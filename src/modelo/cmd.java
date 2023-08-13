package modelo;

import controlador.controladorFromPrincipal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Telematico
 */
public class cmd implements Runnable {

    private static String query;
    private static boolean control = false;

    public cmd() {
        Thread hilo = new Thread(this);
        hilo.start();
    }

    public void getLine(String query) {
        cmd.query = query;
        cmd.control = true;
    }

    @Override
    public void run() {
        while (control) {
            Runtime r = Runtime.getRuntime();
            String salida = null;
            int i = 1;
            try {
                Process p = r.exec("cmd /c " + query);
                InputStreamReader entrada = new InputStreamReader(p.getInputStream());
                BufferedReader cmdInput = new BufferedReader(entrada);
                //mostramos la salida del comando
                if ((salida = cmdInput.readLine()) != null) {
                    while ((salida = cmdInput.readLine()) != null) {
                        controladorFromPrincipal.fp.txtArea.append("\n " + i + ">  " + salida);
                        controladorFromPrincipal.fp.txtArea.setCaretPosition(controladorFromPrincipal.fp.txtArea.getDocument().getLength());
                        //System.out.println(i + " " + salida);
                        i++;
                    }
                }
                controladorFromPrincipal.fp.txtArea.append("\n " + i + ">  " + "Fin");
                cmd.control = false;
            } catch (IOException ex) {
                ex.getStackTrace();
            }
        }
    }
}
