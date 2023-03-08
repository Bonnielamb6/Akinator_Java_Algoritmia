/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package front;


import back.Arbol;
import back.NodoArbol;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author cocol
 */
public class Personaje extends javax.swing.JPanel {

    /**
     * Creates new form Personaje
     */
    Arbol datos = new Arbol();
    NodoArbol nodo = new NodoArbol();
    EndGame panelGameOver = new EndGame(datos, nodo);
    InGame panelJuego;
    
//    public Personaje(NodoArbol nodo, EndGame panelGameOver) {
//        initComponents();
//        this.nodo = nodo;
//        this.panelGameOver = panelGameOver;
//        btnVolverAJugar.setVisible(false);
//    }
    
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNo = new javax.swing.JButton();
        btnSi = new javax.swing.JButton();
        lblPersonaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnVolverAJugar = new javax.swing.JButton();

        setBackground(new java.awt.Color(6, 118, 243));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(null);

        btnNo.setBackground(new java.awt.Color(91, 191, 255));
        btnNo.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        add(btnNo);
        btnNo.setBounds(660, 390, 110, 40);

        btnSi.setBackground(new java.awt.Color(91, 191, 255));
        btnSi.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnSi.setText("Si");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });
        add(btnSi);
        btnSi.setBounds(410, 390, 110, 40);

        lblPersonaje.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        lblPersonaje.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPersonaje.setText("Tu personaje es:");
        add(lblPersonaje);
        lblPersonaje.setBounds(350, 110, 500, 50);
        add(jLabel1);
        jLabel1.setBounds(480, 160, 240, 200);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/genio.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 80, 350, 300);

        btnVolverAJugar.setBackground(new java.awt.Color(91, 191, 255));
        btnVolverAJugar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnVolverAJugar.setText("Volver a jugar");
        btnVolverAJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAJugarActionPerformed(evt);
            }
        });
        add(btnVolverAJugar);
        btnVolverAJugar.setBounds(480, 380, 200, 60);
    }// </editor-fold>//GEN-END:initComponents

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
        lblPersonaje.setText("SOY BUENISIMO LA PTM, QUIERES VOLVER A JUGAR??");
        btnVolverAJugar.setVisible(true);
        
    }//GEN-LAST:event_btnSiActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        lblPersonaje.setText("Tu personaje es: "+ nodo.getTexto());
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
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JButton btnVolverAJugar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPersonaje;
    // End of variables declaration//GEN-END:variables
}
