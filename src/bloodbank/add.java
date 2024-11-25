/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bloodbank;
import javax.swing.*;
import java.sql.*;
import java.awt.Color;
/**
 *
 * @author anand
 */
public class add extends javax.swing.JFrame {

    /** Creates new form add */
    public add() {
        initComponents();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","Sharath@1220");
            String q="select max(id) from donor";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(q);
            while(rs.next()){
                int id=rs.getInt(1);
                lblid.setText(String.valueOf(id+1));
            }
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    public add(int id){
        initComponents();
        lblid.setText(String.valueOf(id));
        save.setText("Update");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","Sharath@1220");
            String q="select * from donor where id=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            String n,m,g,e,c,b,f;
            int i,a;
            while(rs.next()){
                i=rs.getInt(1);
                n=rs.getString(2);
                a=rs.getInt(3);
                m=rs.getString(4);
                g=rs.getString(5);
                e=rs.getString(6);
                c=rs.getString(7);
                b=rs.getString(8);
                f=rs.getString(9);
                
                txtname.setText(n);
                txtage.setText(String.valueOf(a));
                txtmob.setText(m);
                ddlgender.setSelectedItem(g);
                txtemail.setText(e);
                txtcity.setText(c);
                txtfname.setText(f);
                ddlblood.setSelectedItem(b);
            }
            
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblid = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        txtmob = new javax.swing.JTextField();
        ddlgender = new javax.swing.JComboBox<>();
        txtcity = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtfname = new javax.swing.JTextField();
        ddlblood = new javax.swing.JComboBox<>();
        btnexit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 80));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setText("ADD NEW DONOR");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 11, 308, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, 683, 10));

        jLabel2.setText("ID : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 102, 34, -1));

        jLabel3.setText("Enter name: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 91, -1));

        jLabel4.setText("Enter age: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 71, -1));

        jLabel5.setText("Enter city: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 102, 75, -1));

        jLabel6.setText("Select Blood Group: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 176, 130, -1));

        jLabel7.setText("Enter Email: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 241, 90, -1));

        jLabel8.setText("Enter Mobile No. :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 118, -1));

        jLabel9.setText("Enter Father Name: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 319, -1, -1));

        save.setBackground(new java.awt.Color(223, 143, 119));
        save.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 110, -1));

        reset.setBackground(new java.awt.Color(243, 208, 208));
        reset.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Update details.png"))); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 120, -1));

        back.setBackground(new java.awt.Color(255, 117, 117));
        back.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exit application.png"))); // NOI18N
        back.setText("Close");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 110, -1));

        jLabel10.setText("Select gender: ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 91, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 438, 683, -1));

        lblid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(255, 5, 5));
        lblid.setText("id");
        getContentPane().add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 101, 40, -1));

        txtname.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 200, -1));

        txtage.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(txtage, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 200, -1));

        txtmob.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(txtmob, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 200, -1));

        ddlgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        getContentPane().add(ddlgender, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 200, -1));

        txtcity.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(txtcity, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 230, -1));

        txtemail.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 230, -1));

        txtfname.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(txtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 230, -1));

        ddlblood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        getContentPane().add(ddlblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 230, -1));

        btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-close-window-30.png"))); // NOI18N
        btnexit.setFocusable(false);
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 0, 22, 22));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/all page background image.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        int a=JOptionPane.showConfirmDialog(null,"DO YOU WANT TO CLOSE APPLICATION","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        txtname.setText(" ");
        txtmob.setText(" ");
        txtage.setText(" ");
        txtcity.setText(" ");
        txtemail.setText(" ");
        txtfname.setText(" ");
    }//GEN-LAST:event_resetActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String n=save.getText();
        String name=txtname.getText();
        String a=txtage.getText();
        String phone=txtmob.getText();
        String city=txtcity.getText();
        String email=txtemail.getText();
        String father=txtfname.getText();
        String gender=ddlgender.getSelectedItem().toString();
        String bg=ddlblood.getSelectedItem().toString();
        
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(this,"Please Enter name");
            txtname.setBackground(new Color(246, 53, 40));
            return;
        }
        if(!a.matches("\\d+")||a.isEmpty()){
            JOptionPane.showMessageDialog(this,"Please Enter Valid age");
            txtage.setBackground(new Color(246, 53, 40));
            return;
        }
        int age=Integer.parseInt(a);
        if(age<18||age>65){
            JOptionPane.showMessageDialog(this,"Donor can not donate blood");
            return;
        }
        if(phone.matches("^[0-9]*$")==false || phone.length()!=10){
            JOptionPane.showMessageDialog(this,"Please check Phone Number");
            txtmob.setBackground(new Color(246, 53, 40));
            return;
        }
        if(city.isEmpty()){
            JOptionPane.showMessageDialog(this,"Please Enter city name");
            txtcity.setBackground(new Color(246, 53, 40));
            return;
        }
        if(email.matches("[a-zA-Z0-9\\-\\.]+@[a-z]+\\.[a-z]{2,3}")==false){
            JOptionPane.showMessageDialog(this,"Please check email");
            txtemail.setBackground(new Color(246, 53, 40));
            return;
        }
        if(father.isEmpty()){
            JOptionPane.showMessageDialog(this,"Please Enter Father name");
            txtfname.setBackground(new Color(246, 53, 40));
            return;
        }
        if(n.equals("Update")){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","Sharath@1220");
                String q="update donor set name=?,age=?,phone=?,gender=?,email=?,city=?,bloodgroup=?,fathername=? where id=?";
                PreparedStatement ps=con.prepareStatement(q);
                ps.setString(1,name);
                ps.setInt(2,age);
                ps.setString(3,phone);
                ps.setString(4,gender);
                ps.setString(5,email);
                ps.setString(6,city);
                ps.setString(7,bg);
                ps.setString(8,father);
                ps.setInt(9,Integer.parseInt(lblid.getText()));
                int b=ps.executeUpdate();
                if(b>0){
                    JOptionPane.showMessageDialog(this,"Data Updated Successfully");
                    new view().setVisible(true);
                    dispose();
                    return;
                }   
            }
            catch(Exception e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","Sharath@1220");
            String q="insert into donor(name,age,phone,gender,email,city,bloodgroup,fathername) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setString(3,phone);
            ps.setString(4,gender);
            ps.setString(5,email);
            ps.setString(6,city);
            ps.setString(7,bg);
            ps.setString(8,father);
            int b=ps.executeUpdate();
            if(b>0){
                JOptionPane.showMessageDialog(this,"Data Saved Successfully");
                new add().setVisible(true);
                dispose();
            }
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        
    }//GEN-LAST:event_saveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnexit;
    private javax.swing.JComboBox<String> ddlblood;
    private javax.swing.JComboBox<String> ddlgender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblid;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtcity;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txtmob;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables

}
