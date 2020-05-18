/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Formulir;
import View.listNama;
import View.Interface;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author irwan
 */
public class pindahActivity {
    public void pindah(int x) throws SQLException{
        if(x==1){
            new Formulir().setVisible(true);
        }else if(x==2){
            new listNama().setVisible(true);
        }
    }
    
    
    
}
