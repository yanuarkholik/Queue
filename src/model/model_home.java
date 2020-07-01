/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controller.JavaConnector;
import java.sql.Connection;
import javax.swing.JOptionPane;
import static view.Home.jComboBox1;
import static view.Home.jTextField1;
import static view.Home.jTextField3;
import controller.control_home;
import java.io.FileOutputStream;
import static view.Home.jTable2;
import static view.Home.jTextField10;
import static view.Home.jTextField2;
import static view.Home.jTextField4;
import static view.Home.jTextField6;
import static view.Home.jTextField8;
import static view.Home.jTextField9;

/**
 *
 * @author Bima
 */
public class model_home {
    public static void addnewservice(){
        //SET CURRENT SPESIFIC TIME
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
            JOptionPane.showMessageDialog(null, "Added In Log");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        jTextField1.setText("");
        jTextField3.setText("");
        control_home.jTable2();
    }
    public static void runningservices(){
                //SET CURRENT SPESIFIC TIME
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf
                = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(dt);

        jTextField4.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField6.setEnabled(false);
        //QUERYINNG
        String sql = "INSERT INTO served_queue(Customer_Name,Type_Of_Service,Description,Detail_Date) VALUES (?,?,?,?)";
        try {
            java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField4.getText());
            pst.setString(2, jTextField2.getText());
            pst.setString(3, jTextField6.getText());
            pst.setString(4, currentTime);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Queue Started!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    public static void updateservices(){
        control_home.Update();
        control_home.jTable2();
        jTextField9.setText("");
        jTextField8.setText("");
        jTextField10.setText("");
    }
    public static void backuprecent(){
        try {
            //create pdf object
            String file_name = "D:\\RECENT.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));

            //Starting document
            document.open();
            //Starting conn
            String sql = "select * from service";
            java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
                    java.sql.Statement stm=conn.createStatement();
                    java.sql.ResultSet rs=stm.executeQuery(sql);
            //pst = conn.prepareStatement(sql);
            //rs = pst.executeQuery();
            //Table
            PdfPTable tbl = new PdfPTable(4);
            tbl.addCell("Serial ID");
            tbl.addCell("Customer Name");
            tbl.addCell("Type of Service");
            tbl.addCell("Description");

            for (int i = 0; i < jTable2.getRowCount(); i++) {
                String serial = jTable2.getValueAt(i, 0).toString();
                String name = jTable2.getValueAt(i, 1).toString();
                String type = jTable2.getValueAt(i, 2).toString();
                String desc = jTable2.getValueAt(i, 3).toString();

                tbl.addCell(serial);
                tbl.addCell(name);
                tbl.addCell(type);
                tbl.addCell(desc);
            }

            document.add(tbl);

            document.close();
            System.out.println("finished");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public static void backupfull(){
        try {
            //create pdf object
            String file_name = "D:\\FULL.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file_name));

            //Starting document
            document.open();
            //Starting conn
            String sql = "select * from log";
            java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
                    java.sql.Statement stm=conn.createStatement();
                    java.sql.ResultSet rs=stm.executeQuery(sql);
//            pst = conn.prepareStatement(sql);
//            rs = pst.executeQuery();
            //Table
            PdfPTable tbl = new PdfPTable(4);
            tbl.addCell("Serial ID");
            tbl.addCell("Customer Name");
            tbl.addCell("Type of Service");
            tbl.addCell("Description");

            while (rs.next()) {
                String serial = rs.getString("Serial");
                String name = rs.getString("Customer_Name");
                String type = rs.getString("Type_Of_Service");
                String desc = rs.getString("Description");

                tbl.addCell(serial);
                tbl.addCell(name);
                tbl.addCell(type);
                tbl.addCell(desc);
            }

            document.add(tbl);

            document.close();
            System.out.println("finished");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
