package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.cmd;
import vista.fromPrincipal;

/**
 *
 * @author Telematico
 */
public class controladorFromPrincipal implements ActionListener {

    public static fromPrincipal fp = null;

    public controladorFromPrincipal(fromPrincipal fp) {
        this.fp = fp;
        inicializar();
    }

    private void inicializar() {
        this.fp.btnEjecutar.addActionListener(this);
        this.fp.setVisible(true);
        this.fp.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.fp.btnEjecutar)) {
            fp.txtArea.setText("");
            if (fp.txtQuery.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error no se permiten valores nulos!", "Error", 0);
            } else {
                cmd c = new cmd();
                c.getLine(this.fp.txtQuery.getText());
            }
        }
    }

}
