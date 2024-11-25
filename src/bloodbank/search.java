/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bloodbank;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author anand
 */
public class search extends javax.swing.JFrame {

    /** Creates new form search */
    public search() {
        initComponents();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","Sharath@1220");
            String q="select city,bloodgroup from donor";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(q);
            String blood,city;
            while(rs.next()){
                city=rs.getString(1);
                blood=rs.getString(2);
                
                ddlcity.addItem(city);
                ddlblood.addItem(blood);
                        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        btnclose = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ddlcity = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ddlblood = new javax.swing.JComboBox<>();
        btnsearch = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(280, 80));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setText("Search Donor");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 326, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 654, 10));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "AGE", "MOBILE NO.", "GENDER", "EMAIL", "CITY", "BLOOD GROUP", "FATHER"
            }
        ));
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 680, 309));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 644, -1));

        btnclose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exit application.png"))); // NOI18N
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, 101, -1));

        btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-close-window-30.png"))); // NOI18N
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 0, 24, 25));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bloodbank/Location.png"))); // NOI18N
        jLabel2.setText("Location");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 81, 91, -1));

        getContentPane().add(ddlcity, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 82, 127, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Blood group.png"))); // NOI18N
        jLabel3.setText("Blood Group");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 81, 113, -1));

        getContentPane().add(ddlblood, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 82, 137, -1));

        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bloodbank/search1.png"))); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 101, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 122, 654, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/all page background image.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
       int a=JOptionPane.showConfirmDialog(null,"DO YOU WANT TO CLOSE APPLICATION","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        String city=ddlcity.getSelectedItem().toString();
        String blood=ddlblood.getSelectedItem().toString();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","Sharath@1220");
            DefaultTableModel model=new DefaultTableModel(new String[]{"Id","NAME","AGE","MOBILE NO.","GENDER","EMAIL","CITY","BLOOD","FATHER"},0);
            Table.setModel(model);
            String sql="select * from donor where bloodgroup=? and city=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,blood);
            st.setString(2,city);
            ResultSet rs=st.executeQuery();
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
                
                model.addRow(new Object[]{i,n,a,m,g,e,c,b,f});
            }
        }
        catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }//GEN-LAST:event_btnsearchActionPerformed

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
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox<String> ddlblood;
    private javax.swing.JComboBox<String> ddlcity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables

}
