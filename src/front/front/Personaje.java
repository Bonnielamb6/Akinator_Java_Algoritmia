
package front;

import back.Arbol;
import back.NodoArbol;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Personaje extends javax.swing.JPanel {

    Arbol datos = new Arbol();
    NodoArbol nodo = new NodoArbol();
    EndGame panelGameOver = new EndGame(datos, nodo);
    InGame panelJuego;
    
    public Personaje(Arbol datos,NodoArbol nodo, EndGame panelGameOver){
        initComponents();
        this.nodo = nodo;
        this.panelGameOver = panelGameOver;
        btnVolverAJugar.setVisible(false);
        this.datos=datos;
    }
    
    public Personaje(Arbol datos,NodoArbol nodo, EndGame panelGameOver,InGame panelJuego) {
        initComponents();
        this.nodo = nodo;
        this.panelGameOver = panelGameOver;
        btnVolverAJugar.setVisible(false);
        this.panelJuego = panelJuego;
        this.datos = datos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNo = new javax.swing.JButton();
        btnSi = new javax.swing.JButton();
        lblPersonaje = new javax.swing.JLabel();
        ImgWIn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVolverAJugar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(6, 118, 243));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(null);

        btnNo.setBackground(new java.awt.Color(0, 51, 51));
        btnNo.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        add(btnNo);
        btnNo.setBounds(660, 390, 110, 40);

        btnSi.setBackground(new java.awt.Color(0, 51, 51));
        btnSi.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnSi.setText("Si");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });
        add(btnSi);
        btnSi.setBounds(410, 390, 110, 40);

        lblPersonaje.setFont(new java.awt.Font("Viner Hand ITC", 1, 14)); // NOI18N
        lblPersonaje.setForeground(new java.awt.Color(51, 51, 51));
        lblPersonaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPersonaje.setText("Tu personaje es:");
        add(lblPersonaje);
        lblPersonaje.setBounds(420, 50, 350, 50);
        add(ImgWIn);
        ImgWIn.setBounds(480, 160, 240, 200);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/genio.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 80, 350, 300);

        btnVolverAJugar.setBackground(new java.awt.Color(0, 51, 51));
        btnVolverAJugar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnVolverAJugar.setText("Volver a jugar");
        btnVolverAJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAJugarActionPerformed(evt);
            }
        });
        add(btnVolverAJugar);
        btnVolverAJugar.setBounds(480, 380, 200, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cuadro de dialogo (1).png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(380, 10, 450, 160);
    }// </editor-fold>//GEN-END:initComponents

    private void SetImageLabel(JLabel labelName, String root){
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT)
        );
        labelName.setIcon(icon);
        this.repaint();
    }
    
    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.remove(this);
        panelGameOver.activo = nodo;
        panelGameOver.setVisible(true);
    }//GEN-LAST:event_btnNoActionPerformed

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        // TODO add your handling code here:
        btnNo.setVisible(false);
        btnSi.setVisible(false);
        lblPersonaje.setText("<html>SOY BUENISIMO LA PTM, QUIERES VOLVER A JUGAR??<html>");
        btnVolverAJugar.setVisible(true);
        
    }//GEN-LAST:event_btnSiActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        lblPersonaje.setText("Tu personaje es: "+ nodo.getTexto());
        SetImageLabel(ImgWIn, nodo.getImg());
    }//GEN-LAST:event_formComponentShown

    private void btnVolverAJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAJugarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        panelJuego.setVisible(true);
        panelJuego.datos = datos;
        panelJuego.activo = datos.getRaiz();
        panelJuego.setVisible(true);
        
        btnNo.setVisible(true);
        btnSi.setVisible(true);
        btnVolverAJugar.setVisible(false);
    }//GEN-LAST:event_btnVolverAJugarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgWIn;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JButton btnVolverAJugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPersonaje;
    // End of variables declaration//GEN-END:variables
}
