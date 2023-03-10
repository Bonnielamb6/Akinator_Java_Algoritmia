
package front;

import back.Arbol;
import back.NodoArbol;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class EndGame extends javax.swing.JPanel {

    /**
     * Creates new form EndGame
     */
    Arbol datos = new Arbol();
    NodoArbol activo = new NodoArbol();
    InGame panelJuego;

    public EndGame(Arbol datos, NodoArbol activo) {
        initComponents();
        this.datos = datos;
        this.activo = activo;
        this.setVisible(true);
        btnVolverAJugar.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        dirImagen = new javax.swing.JLabel();
        txtPersonaje = new javax.swing.JTextField();
        btnAgregarImagen = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblPregunta = new javax.swing.JLabel();
        btnVolverAJugar = new javax.swing.JButton();
        lblGenio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(6, 118, 243));
        setPreferredSize(new java.awt.Dimension(860, 460));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(11, 18, 98));
        jPanel1.setLayout(null);

        lblDescripcion.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("Descripcion del personaje:");
        lblDescripcion.setToolTipText("");
        jPanel1.add(lblDescripcion);
        lblDescripcion.setBounds(10, 120, 500, 50);

        txtDescripcion.setBackground(new java.awt.Color(91, 191, 255));
        txtDescripcion.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDescripcion);
        txtDescripcion.setBounds(10, 170, 500, 50);

        dirImagen.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        dirImagen.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(dirImagen);
        dirImagen.setBounds(190, 250, 310, 50);

        txtPersonaje.setBackground(new java.awt.Color(91, 191, 255));
        txtPersonaje.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        txtPersonaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPersonajeKeyTyped(evt);
            }
        });
        jPanel1.add(txtPersonaje);
        txtPersonaje.setBounds(10, 60, 500, 50);

        btnAgregarImagen.setBackground(new java.awt.Color(91, 191, 255));
        btnAgregarImagen.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnAgregarImagen.setText("A??adir Imagen");
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarImagen);
        btnAgregarImagen.setBounds(10, 250, 170, 50);

        btnAceptar.setBackground(new java.awt.Color(91, 191, 255));
        btnAceptar.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);
        btnAceptar.setBounds(210, 380, 110, 40);

        lblPregunta.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        lblPregunta.setForeground(new java.awt.Color(255, 255, 255));
        lblPregunta.setText("En quien estabas pensando?");
        jPanel1.add(lblPregunta);
        lblPregunta.setBounds(8, 5, 500, 50);

        btnVolverAJugar.setBackground(new java.awt.Color(91, 191, 255));
        btnVolverAJugar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnVolverAJugar.setText("Volver a jugar");
        btnVolverAJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAJugarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverAJugar);
        btnVolverAJugar.setBounds(160, 330, 200, 60);

        add(jPanel1);
        jPanel1.setBounds(340, 10, 520, 440);

        lblGenio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/genio.jpg"))); // NOI18N
        add(lblGenio);
        lblGenio.setBounds(0, 80, 350, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if (txtDescripcion.getText().isBlank() || txtPersonaje.getText().isBlank() || dirImagen.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "No puede haber ningun dato vacio");
        } else {
            datos.insertarNuevoPersonaje(txtDescripcion.getText(), txtPersonaje.getText(), dirImagen.getText(), activo);
            datos.setRaiz(datos.equilibrarArbol(datos.getRaiz()));
            esconderCajas();
        }


    }//GEN-LAST:event_btnAceptarActionPerformed
    private void esconderCajas() {
        txtDescripcion.setVisible(false);
        txtPersonaje.setVisible(false);
        lblDescripcion.setVisible(false);
        lblPregunta.setVisible(false);
        btnAgregarImagen.setVisible(false);
        btnAceptar.setVisible(false);
        btnVolverAJugar.setVisible(true);
        dirImagen.setVisible(false);
    }

    private void mostrarCajas() {
        txtDescripcion.setVisible(true);
        txtPersonaje.setVisible(true);
        lblDescripcion.setVisible(true);
        lblPregunta.setVisible(true);
        btnAgregarImagen.setVisible(true);
        btnAceptar.setVisible(true);
        btnVolverAJugar.setVisible(false);
        dirImagen.setVisible(true);
    }

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();

        int seleccion = fc.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {

            File fichero = fc.getSelectedFile();

            this.dirImagen.setText(fichero.getAbsolutePath());
        }
    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    private void btnVolverAJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAJugarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        panelJuego.setVisible(true);
        panelJuego.datos = datos;
        panelJuego.activo = datos.getRaiz();
        panelJuego.setVisible(true);

        btnVolverAJugar.setVisible(false);
        mostrarCajas();
        txtPersonaje.setText("");
        txtDescripcion.setText("");
        dirImagen.setText("");
    }//GEN-LAST:event_btnVolverAJugarActionPerformed

    private void txtPersonajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonajeKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        if (!((key >= 48 && key <= 57) || (key >= 65 && key <= 90) || (key >= 97 && key <= 122) || (key == 32) || (key == 127))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPersonajeKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        if (!((key >= 48 && key <= 57) || (key >= 65 && key <= 90) || (key >= 97 && key <= 122) || (key == 32) || (key == 127))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnVolverAJugar;
    private javax.swing.JLabel dirImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblGenio;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPersonaje;
    // End of variables declaration//GEN-END:variables
}
