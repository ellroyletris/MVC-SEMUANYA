/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.controller.controller_siswa;
import com.koneksi.koneksi;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import com.view.tampilan;
/**
 *
 * @author PC LAB 2
 */
public class model_siswa implements controller_siswa {
    String jk;

    @Override
    public void Simpan(tampilan t) throws SQLException {
       if (t.rbLaki.isSelected()){
            jk = "Laki-laki";
        } else {
            jk = "Perempuan";
        }
        try{
Connection con = koneksi.getcon();
String sql = "Insert Into siswa Values(?,?,?,?)";
PreparedStatement prepare = con.prepareStatement(sql);
prepare.setString(1, t.txtNIS.getText());
prepare.setString(2, t.txtNama.getText());
prepare.setString(3, jk);
prepare.setString(4, (String) t.cbJurusan.getSelectedItem());
prepare.executeUpdate();
JOptionPane.showMessageDialog(null, "sudah masuk kok daddy");
prepare.close();
} catch (Exception e){
System.out.println(e);
} finally {

        } 
    }

    @Override
    public void Reset(tampilan t) throws SQLException {
        t.txtNama.setText("");
        t.txtNIS.setText("");
       
        
    }

    @Override
    public void Ubah(tampilan t) throws SQLException {
        
        if (t.rbLaki.isSelected()){
            jk = "Laki-laki";
        } else {
            jk = "Perempuan";
        }
    try {
    Connection con = koneksi.getcon();
    String sql = "UPDATE siswa SET nama=?, jenis_kelamin=?, " + "jurusan=? WHERE NIS=?";
    PreparedStatement prepare = con.prepareStatement(sql);
    prepare.setString(4, t.txtNIS.getText());
    prepare.setString(1, t.txtNama.getText());
    prepare.setString(2, jk);
    prepare.setString(3, (String) t.cbJurusan.getSelectedItem());
    prepare.executeUpdate();
    JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
    prepare.close();
} catch (Exception e){
        System.out.println(e);
} finally {
    //
}
    }

    @Override
    public void Hapus(tampilan t) throws SQLException {
        try{
            Connection con = koneksi.getcon();
            String sql ="DELETE FROM SISWA WHERE NIS =?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            prepare.close();
        } catch (Exception e){
            System.out.println(e);
    } finally{
            
        }
                
      }
   }

