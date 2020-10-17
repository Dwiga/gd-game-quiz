import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

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
    JButton a, b, c;
    
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
    
    ArrayList<Integer> soal = new ArrayList<>();
    Random rn = new Random();
    private int cariSoal(int n, int jum){
        int random = rn.nextInt(jum);
        int nume = 0;
        if(soal.contains(n)){
            cariSoal(random, jum);
        }else{
            nume = n-1;
            soal.add(nume);
        }
        return nume;
    }
    
    public question(User user){
        JFrame frame = new JFrame();
        frame.setTitle("Quiss");
        frame.setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        initGUI(frame, user);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    private void initGUI(JFrame frame, User user){
        JSONObject obj = new JSONObject(readJsonFromAssets());
        JSONObject data = obj.getJSONObject("data");
        JSONObject soal = data.getJSONArray("level").getJSONObject(user.level-1).getJSONArray("soal").getJSONObject(user.nume);
        String q = soal.getString("q");
        String benar = soal.getString("true");
        JSONArray j = soal.getJSONArray("a");
        
        JLabel lblName = new JLabel("Pertanyaan : " + q);
        lblName.setBounds(450, 80, 700, 30);
        
        JSONObject pilgan1 = j.getJSONObject(0);
        a = new JButton(pilgan1.getString("abjad") + ". " + pilgan1.getString("text"));
        a.setBounds(450, 110, 200, 50);
        
        a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(benar.equals("A")){
                    benar(user, user.nume);
                }
            }
        });
        
        JSONObject pilgan2 = j.getJSONObject(1);
        b = new JButton(pilgan2.getString("abjad") + ". " + pilgan2.getString("text"));
        b.setBounds(450, 170, 200, 50);
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(benar.equals("B")){
                    int poin = user.poin + 1;
                    user.setPoin(poin);
                }
            }
        });
        
        JSONObject pilgan3 = j.getJSONObject(2);
        c = new JButton(pilgan3.getString("abjad") + ". " + pilgan3.getString("text"));
        c.setBounds(450, 230, 200, 50);
        
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(benar.equals("C")){
                    System.out.println("Benar");
                }
            }
        });
        
        frame.add(lblName);
        frame.add(a);
        frame.add(b);
        frame.add(c);
    }
    
    private void benar(User user, int nume){
        user.setFinished(user.finished + "," + nume);
        String jwb[] = user.finished.split(",");
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
