
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwihy
 */
public class question extends javax.swing.JFrame{
    public question(User user){
        JFrame frame = new JFrame();
        frame.setTitle("Quiss");
        frame.setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        initGUI(frame, user);
        frame.setVisible(true);
    }
    
    private void initGUI(JFrame frame, User user){
        
    }
    
//    public static void main(String[] args) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new question().setVisible(true);
//            }
//        });
//    }
}
