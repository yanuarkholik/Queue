/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import javax.swing.JOptionPane;
import view.Home;
import static view.Login.jComboBox1;
import static view.Login.jPasswordField1;
import static view.Login.jTextField1;
import view.User;

/**
 *
 * @author Bima
 */
public class control_login extends view.Login{
    public  void login(){
        String user = jTextField1.getText();
        String pass = jPasswordField1.getText();
        String option = jComboBox1.getSelectedItem().toString();

        if (user.equals("") || pass.equals("") || option.equals("Select")) {
            JOptionPane.showMessageDialog(rootPane, "Some fields are missing!", "Error,", 1);
        } else {
            try {
                
                String sql = "select * from user where username='"+user+"' and password='"+pass+"'";                
                java.sql.Connection conn=(Connection)JavaConnector.ConnecrDb();
                    java.sql.Statement stm=conn.createStatement();
                    java.sql.ResultSet rs=stm.executeQuery(sql);
                //pst = conn.prepareStatement(sql);
                //pst.setString(1, user);
                //pst.setString(2, pass);
                //rs = pst.executeQuery();
                
                if (rs.next()) {
                    String sl = rs.getString("role");
                    String un = rs.getString("username");
                    if (option.equalsIgnoreCase("Admin")&& sl.equalsIgnoreCase("admin")) {
                        Home ad = new Home(un);
                        ad.setVisible(true);
                        setVisible(false);
                    }
                    if (option.equalsIgnoreCase("Guest")&& sl.equalsIgnoreCase("guest")) {
                        User gp = new User(un);
                        gp.setVisible(true);
                        setVisible(false);
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Username or password not matched", "Login Error", 1);
                }
            } catch (Exception e) {

            }
        }

    }
}
