/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package front;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import back.Arbol;
import back.NodoArbol;

/**
 *
 * @author cocol
 */
public class InGame extends javax.swing.JPanel {

    /**
     * Creates new form InGame
     */
    Arbol datos = new Arbol();
    NodoArbol activo = datos.getRaiz();
    EndGame panelGameOver;
    Personaje panelAdivinado;

    public InGame(){
        initComponents();
    }
    
    public InGame(Arbol datos,Personaje panelAdivinado, EndGame panelGameOver){
        initComponents();
        this.datos = datos;
        activo = datos.getRaiz();
        btnSi.setVisible(false);
        btnNo.setVisible(false);
        lblPersonaje.setVisible(false);
        lblPersonaje.setVisible(false);
        this.panelAdivinado = panelAdivinado;
        this.panelGameOver = panelGameOver;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        lblPersonaje = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnComenzar = new javax.swing.JButton();

        setBackground(new java.awt.Color(6, 118, 243));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(null);

        btnSi.setBackground(new java.awt.Color(91, 191, 255));
        btnSi.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnSi.setText("Si");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });
        add(btnSi);
        btnSi.setBounds(440, 250, 110, 40);

        btnNo.setBackground(new java.awt.Color(91, 191, 255));
        btnNo.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        add(btnNo);
        btnNo.setBounds(650, 250, 110, 40);

        lblPersonaje.setFont(new java.awt.Font("Viner Hand ITC", 1, 18)); // NOI18N
        lblPersonaje.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPersonaje.setText("Tu personaje ");
        add(lblPersonaje);
        lblPersonaje.setBounds(350, 110, 500, 50);

        lblPregunta.setMaximumSize(new java.awt.Dimension(100, 100));
        lblPregunta.setMinimumSize(new java.awt.Dimension(100, 100));
        lblPregunta.setPreferredSize(new java.awt.Dimension(100, 100));
        add(lblPregunta);
        lblPregunta.setBounds(440, 180, 350, 100);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/genio.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 80, 350, 300);

        btnComenzar.setBackground(new java.awt.Color(91, 191, 255));
        btnComenzar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnComenzar.setText("Comenzar");
        btnComenzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComenzarActionPerformed(evt);
            }
        });
        add(btnComenzar);
        btnComenzar.setBounds(510, 180, 160, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        // TODO add your handling code here:
        if(activo.getHijoDerecho().getHijoDerecho()==null){
            this.setVisible(false);
            
            panelAdivinado.nodo = activo.avanzarDerecha(activo);
            panelAdivinado.setVisible(true);
            this.finalizar();
        }else{
            activo = activo.avanzarDerecha(activo);
            cambiarTexto();
        }
    }//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        // TODO add your handling code here:
        if(activo.getHijoIzquierdo().getHijoIzquierdo()==null){
            this.setVisible(false);
            
            panelAdivinado.nodo = activo.avanzarIzquierda(activo);
            panelAdivinado.setVisible(true);
            this.finalizar();
            
        }else{
            activo = activo.avanzarIzquierda(activo);
            cambiarTexto();
        }
    }
    
    public void insertarPrimerTexto(){
        
    }
    
    public void cambiarTexto(){
        if(activo!=null){
            lblPregunta.setText(""+activo.getTexto());
            lblPregunta.setVisible(true);
        }
        
    }//GEN-LAST:event_btnNoActionPerformed

    private void btnComenzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComenzarActionPerformed
        // TODO add your handling code here:
        comenzar();
        if(activo.getHijoIzquierdo()==null && activo.getHijoDerecho()==null){
            this.setVisible(false);
            
            panelAdivinado.nodo = activo;
            panelAdivinado.setVisible(true);
            this.finalizar();
        }else{
            cambiarTexto();
        }
        
        
    }//GEN-LAST:event_btnComenzarActionPerformed

    private void comenzar(){
        lblPersonaje.setVisible(true);
        lblPregunta.setVisible(true);
        btnNo.setVisible(true);
        btnSi.setVisible(true);
        btnComenzar.setVisible(false);
        activo = datos.getRaiz();
    }
    
    private void finalizar(){
        lblPersonaje.setVisible(false);
        lblPregunta.setVisible(false);
        btnNo.setVisible(false);
        btnSi.setVisible(false);
        btnComenzar.setVisible(true);
        activo = datos.getRaiz();
        lblPersonaje.setVisible(false);
    }
    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
       activo = datos.getRaiz();
    }//GEN-LAST:event_formComponentShown

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPersonaje;
    private javax.swing.JLabel lblPregunta;
    // End of variables declaration//GEN-END:variables
}
