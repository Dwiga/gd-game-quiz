
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        frame.setVisible(true);
    }
    
    private void initGUI(JFrame frame, User user){
        JSONObject obj = new JSONObject(readJsonFromAssets());
        JSONObject data = obj.getJSONObject("data");
        String soal = data.getJSONArray("level").getJSONObject(user.level-1).getJSONArray("soal").getJSONObject(user.nume).getString("q");
        
        JLabel lblName = new JLabel("Name :" + soal);
        lblName.setBounds(580, 70, 200, 30);
        
        frame.add(lblName);
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
