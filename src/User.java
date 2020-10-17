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
    String nama; // nama user
    int poin; // poin benar
    int level; // level user 
    int nume; // nomor soal
    String finished; // nomor soal yang sudah selesai
    int jmlsoal;
    
    void setFinished(String finished){
        this.finished = finished;
    }
    
    void setNama(String nama){
        this.nama = nama;
    }
    
    void setPoin(int poin){
        this.poin = poin;
    }
    
    void setNume(int nume){
        this.nume = nume;
    }
    
    void setJml(int jml){
        this.jmlsoal = jml;
    }
    
    void setAll(String nama, int poin, int level){
        this.poin = poin;
        this.nama = nama;
        this.level = level;
    }
}
