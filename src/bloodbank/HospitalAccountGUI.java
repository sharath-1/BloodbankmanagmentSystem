/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbank;

/**
 *
 * @author sharathbandela
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HospitalAccountGUI extends JFrame {
    private JTextField txtName, txtHospitalID, txtContactInfo;
    private JTextArea txtOutput;

    public HospitalAccountGUI() {
        setTitle("Create Hospital Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        JPanel panelInput = new JPanel(new GridLayout(4, 2));
        panelInput.add(new JLabel("Hospital Name:"));
        txtName = new JTextField();
        panelInput.add(txtName);

        panelInput.add(new JLabel("Hospital ID:"));
        txtHospitalID = new JTextField();
        panelInput.add(txtHospitalID);

        panelInput.add(new JLabel("Contact Info:"));
        txtContactInfo = new JTextField();
        panelInput.add(txtContactInfo);

        JButton btnCreateAccount = new JButton("Create Account");
        panelInput.add(btnCreateAccount);
        btnCreateAccount.addActionListener(e -> createAccount());

        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        JScrollPane scrollOutput = new JScrollPane(txtOutput);

        add(panelInput, BorderLayout.CENTER);
        add(scrollOutput, BorderLayout.SOUTH);
    }

    private void createAccount() {
        String name = txtName.getText();
        String hospitalID = txtHospitalID.getText();
        String contactInfo = txtContactInfo.getText();

        // Simulate account creation by printing to console
        System.out.println("Hospital Account Created:");
        System.out.println("Hospital Name: " + name);
        System.out.println("Hospital ID: " + hospitalID);
        System.out.println("Contact Info: " + contactInfo);
        
        // Show the output in the JTextArea
        txtOutput.setText("Account created for: \n");
        txtOutput.append("Hospital Name: " + name + "\n");
        txtOutput.append("Hospital ID: " + hospitalID + "\n");
        txtOutput.append("Contact Info: " + contactInfo + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalAccountGUI().setVisible(true));
    }
}
