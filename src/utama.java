/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Komputasi 1
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

public class utama extends javax.swing.JFrame {
    
    public String readJsonFromAssets(){
        String json = null;
        try {
            String dir = System.getProperty("user.dir") + "\\src\\data.json";
            File jsn = new File(dir);
            Scanner sc = new Scanner(jsn);
            String data = "";
            while (sc.hasNextLine()){
                data += sc.nextLine();
            }
            json = data;
            sc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
    
    /**
     * Creates new form utama
     */
    User user = new User();
    Random rn = new Random();
    
    private int cariSoal(int n, int jum, User user){
        int random = rn.nextInt(jum);
        
        String[] fns = user.finished.split("");
        ArrayList<String> f = new ArrayList<>();
        for(int i = 0; i < fns.length; i++){
            f.add(fns[i]);
        }
        
        if(f.contains(n+"")){
            cariSoal(random, jum, user);
        }else{
            user.setFinished(user.finished + n);
            user.setNume(n);
        }
        return user.nume;
    }
    
    public utama() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(204, 166, 166));
        // mengambil ukuran layar
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtNama = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setText("MULAI");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPreferredSize(new java.awt.Dimension(100, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 300, 100, 60);

        jButton2.setText("KELUAR");
        jButton2.setPreferredSize(new java.awt.Dimension(100, 60));
        jButton2.setRequestFocusEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(250, 300, 100, 60);

        txtNama.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtNama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNama);
        txtNama.setBounds(140, 230, 210, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakgambar1.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -20, 500, 440);

        jTextField2.setBackground(new java.awt.Color(204, 204, 0));
        jTextField2.setText("txtNama");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(140, 220, 210, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
        user.setAll(txtNama.getText(), 0, 1, "");
        JSONObject obj = new JSONObject(readJsonFromAssets());
        JSONObject data = obj.getJSONObject("data");
        JSONArray lvl = data.getJSONArray("level");
        user.setJml(lvl.getJSONObject(user.level-1).getJSONArray("soal").length());
        int random = rn.nextInt(user.jmlsoal);
        int noal = cariSoal(random, user.jmlsoal, user);
        user.setNume(noal);
        //System.out.println(lvl.getJSONObject(user.level-1).getJSONArray("soal").getJSONObject(0).getInt("no"));
        question q = new question(user);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new utama().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}
