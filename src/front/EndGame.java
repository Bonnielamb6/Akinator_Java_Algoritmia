package front;

import back.Arbol;
import back.NodoArbol;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class EndGame extends javax.swing.JPanel {

    File imgSeleccionada;
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
        lblimagenPersonaje = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPersonaje = new javax.swing.JTextField();
        btnAgregarImagen = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblPregunta = new javax.swing.JLabel();
        btnVolverAJugar = new javax.swing.JButton();
        lblGenio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(6, 118, 243));
        setPreferredSize(new java.awt.Dimension(860, 460));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(11, 18, 98));
        jPanel1.setLayout(null);
        jPanel1.add(lblimagenPersonaje);
        lblimagenPersonaje.setBounds(390, 240, 110, 100);

        lblDescripcion.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        lblDescripcion.setText("Descripcion del personaje:");
        lblDescripcion.setToolTipText("");
        jPanel1.add(lblDescripcion);
        lblDescripcion.setBounds(10, 120, 500, 50);

        txtDescripcion.setBackground(new java.awt.Color(91, 191, 255));
        txtDescripcion.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jPanel1.add(txtDescripcion);
        txtDescripcion.setBounds(10, 170, 500, 50);

        jLabel2.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(190, 250, 310, 50);

        txtPersonaje.setBackground(new java.awt.Color(91, 191, 255));
        txtPersonaje.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jPanel1.add(txtPersonaje);
        txtPersonaje.setBounds(10, 60, 500, 50);

        btnAgregarImagen.setBackground(new java.awt.Color(91, 191, 255));
        btnAgregarImagen.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnAgregarImagen.setText("Añadir Imagen");
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
        if (txtDescripcion.getText().isBlank() || txtPersonaje.getText().isBlank() || imgSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "No puede haber ningun dato vacio");
        } else {
            datos.insertarNuevoPersonaje(txtDescripcion.getText(), txtPersonaje.getText(), activo);
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
        lblimagenPersonaje.setVisible(false);
        txtDescripcion.setText("");
        txtPersonaje.setText("");
    }

    private void mostrarCajas() {
        txtDescripcion.setVisible(true);
        txtPersonaje.setVisible(true);
        lblDescripcion.setVisible(true);
        lblPregunta.setVisible(true);
        btnAgregarImagen.setVisible(true);
        btnAceptar.setVisible(true);
        btnVolverAJugar.setVisible(false);
    }

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        JFileChooser explorador = new JFileChooser();
        int result = explorador.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            imgSeleccionada = explorador.getSelectedFile();
            ImageIcon imagenPersonaje = new ImageIcon(imgSeleccionada.getPath());
            Image img = imagenPersonaje.getImage().getScaledInstance(lblimagenPersonaje.getWidth(), lblimagenPersonaje.getHeight(), Image.SCALE_SMOOTH);
            imagenPersonaje = new ImageIcon(img);
            lblimagenPersonaje.setIcon(imagenPersonaje);
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
    }//GEN-LAST:event_btnVolverAJugarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        mostrarCajas();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnVolverAJugar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblGenio;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblimagenPersonaje;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPersonaje;
    // End of variables declaration//GEN-END:variables
}
