/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.JavaConnector;
import java.sql.Connection;
import javax.swing.JOptionPane;
import view.User;
import static view.User.jComboBox1;
import static view.User.jTextField1;
import static view.User.jTextField3;
import controller.control_user;

/**
 *
 * @author Bima
 */
public class model_user {
    public static void addqueue(){
        //SET CURRENT SPESIFIC TIME
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);
        //QUERYINNG
        String sql = "INSERT INTO service(Customer_Name,Type_Of_Service,Description,Detail_Date) VALUES (?,?,?,?)";
        try {
            java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField1.getText());
            pst.setString(2, (String) jComboBox1.getSelectedItem());
            pst.setString(3, jTextField3.getText());
            pst.setString(4, currentTime);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added In Queue...!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        String sql_log = "INSERT INTO log(Customer_Name,Type_Of_Service,Description,Detail_Date) VALUES (?,?,?,?)";
        try {
            java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql_log);
            pst.setString(1, jTextField1.getText());
            pst.setString(2, (String) jComboBox1.getSelectedItem());
            pst.setString(3, jTextField3.getText());
            pst.setString(4, currentTime);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        jTextField1.setText("");
        jTextField3.setText("");
        control_user.jtable3();
        control_user.jtable2();
    }
}
