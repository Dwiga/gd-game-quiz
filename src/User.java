/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dwihy
 */
public class User {
    String nama;
    int poin;
    int level;
    
    void setNama(String nama){
        this.nama = nama;
    }
    
    void setPoin(int poin){
        this.poin = poin;
    }
    
    void setAll(String nama, int poin, int level){
        this.poin = poin;
        this.nama = nama;
        this.level = level;
    }
}
