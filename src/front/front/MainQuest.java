
package front;

import back.Arbol;
import back.NodoArbol;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MainQuest extends javax.swing.JPanel {

    Arbol datos = new Arbol();
    EndGame panelGameOver = new EndGame(datos, datos.getRaiz());
    Personaje panelAdivinado;
    InGame panelJuego;
    
    public MainQuest() {
        initComponents();
        
        
    }
        public MainQuest(InGame panelJuego) {
        initComponents();
        
        this.panelJuego = panelJuego;
    }
    
    public MainQuest(Arbol datos,InGame panelJuego){
        initComponents();
        this.datos = datos;
        this.panelJuego = panelJuego;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        dirImagen = new javax.swing.JLabel();
        txtPersonaje = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(6, 118, 243));
        setLayout(null);

        jPanel2.setBackground(new java.awt.Color(11, 18, 98));
        jPanel2.setLayout(null);

        dirImagen.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        dirImagen.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(dirImagen);
        dirImagen.setBounds(190, 250, 310, 50);

        txtPersonaje.setBackground(new java.awt.Color(91, 191, 255));
        txtPersonaje.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        txtPersonaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPersonajeKeyTyped(evt);
            }
        });
        jPanel2.add(txtPersonaje);
        txtPersonaje.setBounds(10, 150, 500, 50);

        jButton1.setBackground(new java.awt.Color(91, 191, 255));
        jButton1.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jButton1.setText("Añadir Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 250, 170, 50);

        btnAceptar.setBackground(new java.awt.Color(91, 191, 255));
        btnAceptar.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAceptar);
        btnAceptar.setBounds(210, 380, 110, 40);

        jLabel3.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("En quien estas pensando?");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(140, 70, 240, 50);

        add(jPanel2);
        jPanel2.setBounds(340, 10, 520, 440);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/genio.jpg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(0, 80, 350, 300);
    }// </editor-fold>//GEN-END:initComponents
  
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if(txtPersonaje.getText().isBlank() || dirImagen.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "No puede haber ningun dato vacio");
        }else{
            NodoArbol raiz = new NodoArbol(txtPersonaje.getText(), dirImagen.getText());
            datos.setRaiz(raiz);
            this.setVisible(false);
            this.remove(this);
            panelJuego.datos = datos;
            panelJuego.setVisible(true);
        }
        
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                JFileChooser fc = new JFileChooser();
        
        int seleccion = fc.showOpenDialog(this);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            
            File fichero = fc.getSelectedFile();
            
            this.dirImagen.setText(fichero.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPersonajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPersonajeKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        if (!((key >= 48 && key <= 57) || (key >= 65 && key <= 90) || (key >= 97 && key <= 122) || (key == 32) || (key == 127))) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPersonajeKeyTyped
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel dirImagen;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtPersonaje;
    // End of variables declaration//GEN-END:variables
}
