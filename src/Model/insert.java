/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author irwan
 */
public class insert {
    String text;
    
    public String data(String nama, String nip, String jabatan, String perj_dinas, String ktp, String tglPergi, String tglPulang){
        try {
            String sql = "INSERT INTO profil(nama, nip, jabatan, perjalanan, nomor_ktp, tanggal_pergi, tanggal_pulang) VALUES ('"+nama+"',"+nip+",'"+jabatan+"','"+perj_dinas+"',"+ktp+","+tglPergi+","+tglPulang+")";
            java.sql.Connection conn=(Connection) koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            text = "Data Berhasil Disimpan";
        } catch (SQLException | HeadlessException e) {
            text = e.getMessage();
        }
        return text;
    }
}
