/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.pindahActivity;
import Model.koneksi;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author irwan
 */
public class listNama extends javax.swing.JFrame {

    Statement stmt;
    ResultSet rs;
    pindahActivity ph = new pindahActivity();
    private DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    /**
     * Creates new form Formulir
     */
    public listNama() {
        initComponents();

        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;

        this.setLocation(x, y);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        
        tbPerjalananDinas.setModel(model);
        model.addColumn("No.");
        model.addColumn("Nip");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        showData();
    }
    
    public void showData(){
        
        String sql = "SELECT *FROM profil";
        try {
            Connection conn=(Connection) koneksi.configDB();
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            int i = 0;
            
            while(rs.next()){
                Object[] o=new Object[4];
                o[0]=rs.getInt("id");
                o[1]=rs.getLong("nip");
                o[2]=rs.getString("nama");
                o[3]=rs.getString("jabatan");
                model.addRow(o);
            }
            
            stmt.close();
            conn.close();
//            System.out.println(tbPerjalananDinas.getRowCount());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    public String showDataLengkap(int id){
        String text = null;
        String sql = "SELECT *FROM profil where id = "+id+"";
        try {
            Connection conn=(Connection) koneksi.configDB();
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                  text = "Nama : "+rs.getString("nama")+"\nNip : "+rs.getLong("nip")+"\nJabatan : "+rs.getString("jabatan")+"\nPerjalanan Dinas : "+rs.getString("perjalanan")+"\nNomor KTP : "+rs.getLong("nomor_ktp")+"\nTanggal Pergi : "+rs.getString("tanggal_pergi")+"\nTanggal Pulang : "+rs.getString("tanggal_pulang");
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        return text;
    }
    
    public void atur(){
        int baris = tbPerjalananDinas.getRowCount();
        
        String sql = "alter table profil auto_increment = "+baris+"";
        try {
            Connection conn=(Connection) koneksi.configDB();
            stmt = (Statement) conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                  System.out.println("Suksess");
           }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbPerjalananDinas = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        txArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPerjalananDinas.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tbPerjalananDinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Nip", "Nama", "Jabatan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPerjalananDinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPerjalananDinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPerjalananDinas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 490, 270));

        txArea.setColumns(20);
        txArea.setRows(5);
        jScrollPane3.setViewportView(txArea);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 220, 270));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbPerjalananDinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPerjalananDinasMouseClicked
        int x = tbPerjalananDinas.getSelectedRow();
//        txArea.setText(showDataLengkap(x+2));
    int baris = tbPerjalananDinas.getSelectedRow();
    int kolom = tbPerjalananDinas.getSelectedColumn();
    String dataTerpilih = tbPerjalananDinas.getValueAt(baris, kolom).toString();
    String kolom1 = tbPerjalananDinas.getValueAt(baris, 0).toString();
//    System.out.println(showDataLengkap(Integer.parseInt(kolom1)));
    txArea.setText(showDataLengkap(Integer.parseInt(kolom1)));
    }//GEN-LAST:event_tbPerjalananDinasMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(listNama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(listNama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(listNama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(listNama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new listNama().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbPerjalananDinas;
    private javax.swing.JTextArea txArea;
    // End of variables declaration//GEN-END:variables
}
