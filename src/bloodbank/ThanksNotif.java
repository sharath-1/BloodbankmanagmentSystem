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
import java.sql.*;

public class ThanksNotif extends JFrame {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/BloodBankDB";
    private static final String DB_USER = "root"; // Replace with your MySQL username
    private static final String DB_PASSWORD = ""; // Replace with your MySQL password

    private JTextField txtDonorID;
    private JTextArea txtMessage;

    public ThanksNotif() {
        // Setting up the JFrame
        setTitle("Thank You Notification");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // Input panel
        JPanel panelInput = new JPanel(new GridLayout(2, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Donor ID:"));
        txtDonorID = new JTextField();
        panelInput.add(txtDonorID);

        JButton btnSendThanks = new JButton("Send Notification");
        panelInput.add(btnSendThanks);

        // Output area
        txtMessage = new JTextArea();
        txtMessage.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtMessage);

        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button action
        btnSendThanks.addActionListener(e -> sendThankYouNotification());
    }

    private void sendThankYouNotification() {
        String donorID = txtDonorID.getText().trim();

        if (donorID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a donor ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Clear the previous message
        txtMessage.setText("");

        // Database query to fetch donor details
        String query = "SELECT name, blood_type FROM Donors WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, Integer.parseInt(donorID));
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String bloodType = rs.getString("blood_type");

                // Display the thank-you notification
                txtMessage.setText("Thank You Notification\n");
                txtMessage.append("-----------------------------\n");
                txtMessage.append("Dear " + name + ",\n");
                txtMessage.append("Thank you for donating blood! Your contribution (Blood Type: " + bloodType + ") is greatly appreciated and will help save lives.\n");
                txtMessage.append("We look forward to your continued support in the future.\n\n");
            } else {
                txtMessage.setText("No donor found with ID: " + donorID);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Donor ID. Please enter a numeric ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ThanksNotif app = new ThanksNotif();
            app.setVisible(true);
        });
    }
}
