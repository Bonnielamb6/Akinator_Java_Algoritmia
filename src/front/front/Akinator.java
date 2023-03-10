
package front;

import back.NodoArbol;
import back.Arbol;
import java.awt.BorderLayout;
import javax.swing.JPanel;


public class Akinator extends javax.swing.JFrame {

    Arbol datos = new Arbol();
    NodoArbol activo = datos.getRaiz();
    
    Bienvenida panelBienvenida= new Bienvenida();

    public Akinator() {
        initComponents();
        mostrarPanel(panelBienvenida);
                
    }
    
    public void mostrarPanel(JPanel p){
        p.setSize(860, 460);
        p.setLocation(0,0);
        contenido.add(p,BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenido = new javax.swing.JPanel();
        btnJugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Akinator");
        setResizable(false);

        contenido.setBackground(new java.awt.Color(204, 153, 0));
        contenido.setPreferredSize(new java.awt.Dimension(860, 460));

        btnJugar.setBackground(new java.awt.Color(0, 51, 51));
        btnJugar.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                .addContainerGap(355, Short.MAX_VALUE)
                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(335, 335, 335))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoLayout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(btnJugar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        /*
        Mostrar panel de juego
        */
        EndGame panelGameOver = new EndGame (datos,activo);
        
        Personaje panelPersonaje = new Personaje(datos,activo,panelGameOver);
        
        InGame panelJuego = new InGame(datos,panelPersonaje,panelGameOver);
        
        Personaje panelAdivinado = new Personaje(datos,activo,panelGameOver,panelJuego);
        panelAdivinado = panelPersonaje;
        panelAdivinado.panelJuego = panelJuego;
        MainQuest panelPreguntaInicial = new MainQuest(datos,panelJuego);
        
        panelGameOver.panelJuego = panelJuego;
        
        mostrarPanel(panelJuego);
        
        
        mostrarPanel(panelPreguntaInicial);

        mostrarPanel(panelGameOver);
        mostrarPanel(panelAdivinado);
        panelBienvenida.setVisible(false);
        panelAdivinado.setVisible(false);
        panelGameOver.setVisible(false);
        panelJuego.setVisible(false);
        btnJugar.setVisible(false);
    }//GEN-LAST:event_btnJugarActionPerformed

    public void iniciarPartida(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Akinator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Akinator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Akinator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Akinator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Akinator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JPanel contenido;
    // End of variables declaration//GEN-END:variables
}
