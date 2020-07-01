/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import view.Login;
import static view.User.jTable2;
import static view.User.jTable3;

/**
 *
 * @author Bima
 */
public class control_user {
    public static void logoutuser(){
        Login lg = new Login();
        lg.setVisible(true);
    }
    public static void jtable2(){
        try {
            String sql = "select Serial AS NO,Customer_Name AS NAME from served_queue ORDER BY Serial DESC LIMIT 1";
            java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
                    java.sql.Statement stm=conn.createStatement();
                    java.sql.ResultSet rs=stm.executeQuery(sql);
            //pst = conn.prepareStatement(sql);
            //rs = pst.executeQuery();
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void jtable3(){
        try {
            String sql = "select Serial AS NO,Customer_Name AS NAME from service";
            java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
                    java.sql.Statement stm=conn.createStatement();
                    java.sql.ResultSet rs=stm.executeQuery(sql);
            //pst = conn.prepareStatement(sql);
            //rs = pst.executeQuery();
            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
