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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CreateHospitalAcc extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JTextArea txtOutput;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/BloodBankDB";
    private static final String DB_USER = "root"; // Replace with your MySQL username
    private static final String DB_PASSWORD = "Sharath@1220"; // Replace with your MySQL password

    public CreateHospitalAcc() {
        setTitle("Hospital Account Creation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel panelInput = new JPanel(new GridLayout(3, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createTitledBorder("Create Hospital Account"));

        panelInput.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        panelInput.add(txtUsername);

        panelInput.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        panelInput.add(txtPassword);

        JButton btnRegister = new JButton("Register Hospital");
        panelInput.add(new JLabel()); // Placeholder
        panelInput.add(btnRegister);

        // Output Area
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        JScrollPane scrollOutput = new JScrollPane(txtOutput);

        // Add components to frame
        add(panelInput, BorderLayout.CENTER);
        add(scrollOutput, BorderLayout.SOUTH);

        // Register button action
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerHospital();
            }
        });
    }

    private void registerHospital() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            txtOutput.append("Error: Username or Password cannot be empty.\n");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO HospitalAccounts (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                txtOutput.append("Hospital account created successfully for username: " + username + "\n");
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            txtOutput.append("Error: Username already exists. Please choose a different username.\n");
        } catch (SQLException e) {
            txtOutput.append("Database error: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CreateHospitalAcc frame = new CreateHospitalAcc();
            frame.setVisible(true);
        });
    }
}
