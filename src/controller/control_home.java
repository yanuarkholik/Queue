/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import static view.Home.jComboBox2;
import static view.Home.jTextField10;
//import static view.Home.jTextField7;
import static view.Home.jTextField8;
import static view.Home.jTextField9;
import static view.Home.jTable2;
import static view.Home.jTextField2;
import static view.Home.jTextField4;
import static view.Home.jTextField6;
import static view.Home.jTextField7;
import view.Login;

/**
 *
 * @author Bima
 */
public class control_home {
//    Connection conn;
//    PreparedStatement pst;
//    ResultSet rs;

   

    public static void jTable2() {
        try {
            //Connection conn;
            //PreparedStatement pst;
            //ResultSet rs;
            String sql = "select Serial,Customer_Name,Type_Of_Service,Description from service";
            java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            jTable2.setModel(DbUtils.resultSetToTableModel(res));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public static void Delete() {
        String sql = "delete from service  where Serial=?";
        try {
//            Connection conn;
//            PreparedStatement pst;
//            ResultSet rs;
            java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
//          pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField7.getText());
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void Update() {
        String sql = "UPDATE service set Customer_Name='"+jTextField9.getText()+"',Type_Of_Service='"+jComboBox2.getSelectedItem()+"',Description='"+jTextField8.getText()+"' where Serial='"+jTextField10.getText()+"'";
        try {
//            Connection conn;
//            PreparedStatement pst;
//            ResultSet rs;
              java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                pst.execute();
            //pst = conn.prepareStatement(sql);
            //pst.setString(1, jTextField9.getText());
//            pst.setString(2, (String) jComboBox2.getSelectedItem());
//            pst.setString(3, jTextField8.getText());
//            pst.setString(4, jTextField10.getText());
            //pst.execute();
            JOptionPane.showMessageDialog(null, "Updated In Queue...!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void logout(){
        Login lg = new Login();
        lg.setVisible(true);
        //setVisible(false);
    }
    public static void complete(){
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure to completed this task?, the task will be deleted");
        switch (answer) {
            case JOptionPane.YES_OPTION:
                Delete();
                jTable2();
                jTextField4.setText("");
                jTextField2.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                jTextField4.setEnabled(true);
                jTextField2.setEnabled(true);
                jTextField6.setEnabled(true);
                break;
            case JOptionPane.NO_OPTION:
                jTextField4.setText("");
                jTextField2.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                jTextField4.setEnabled(true);
                jTextField2.setEnabled(true);
                jTextField6.setEnabled(true);
                break;
    }
    }
    public static void selecttable(){
        Object[] choices = {"Start", "Update"};
        Object defaultChoice = choices[0];
        int answer = JOptionPane.showOptionDialog(null,
                "Please choose which one of the service do you want?",
                "PLEASE SELECT",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                choices,
                defaultChoice);

        switch (answer) {
            case JOptionPane.YES_OPTION:
                //CLEARING SHOWING TEXTFIELD
                jTextField9.setText("");
                jTextField8.setText("");
                jTextField10.setText("");
                //IF SELECT START
                try {
                    int row = jTable2.getSelectedRow();
                    String Table_click = (jTable2.getModel().getValueAt(row, 0).toString());
                    String sql = "select * from service where Serial='" + Table_click + "'";
                    java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
                    java.sql.Statement stm=conn.createStatement();
                    java.sql.ResultSet rs=stm.executeQuery(sql);
                    //pst = conn.prepareStatement(sql);
                    //rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Customer_name");
                        jTextField4.setText(add1);
                        String add2 = rs.getString("Type_Of_Service");
                        jTextField2.setText(add2);
                        String add3 = rs.getString("Description");
                        jTextField6.setText(add3);
                        String add4 = rs.getString("Serial");
                        jTextField7.setText(add4);
                    }
                } catch (Exception e) {

                }
                break;
            case JOptionPane.NO_OPTION:
                //CLEARING SHOWING TEXTFIELD
                jTextField4.setText("");
                jTextField2.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                //IF SELECT UPDATE
                try {
                    int row = jTable2.getSelectedRow();
                    String Table_click = (jTable2.getModel().getValueAt(row, 0).toString());
                    String sql = "select * from service where Serial='" + Table_click + "'";
                    java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
                    java.sql.Statement stm=conn.createStatement();
                    java.sql.ResultSet rs=stm.executeQuery(sql);
                    //pst = conn.prepareStatement(sql);
                    //rs = pst.executeQuery();
                    if (rs.next()) {
                        String add1 = rs.getString("Customer_name");
                        jTextField9.setText(add1);
                        String add2 = rs.getString("Type_Of_Service");
                        jComboBox2.setSelectedItem(add2);
                        String add3 = rs.getString("Description");
                        jTextField8.setText(add3);
                        String add4 = rs.getString("Serial");
                        jTextField10.setText(add4);
                    }
                } catch (Exception e) {

                }
                break;
            case JOptionPane.CANCEL_OPTION:

        }

    }
}
