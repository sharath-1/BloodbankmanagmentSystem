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

public class ReceiverRequest extends JFrame {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/BloodBankDB";
    private static final String DB_USER = "root"; // Replace with your MySQL username
    private static final String DB_PASSWORD = "Sharath@1220"; // Replace with your MySQL password

    private JTextField txtReceiverName;
    private JTextArea txtResult;

    public ReceiverRequest() {
        // Setting up the JFrame
        setTitle("Search Blood Requests by Receiver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // Input panel
        JPanel panelInput = new JPanel(new GridLayout(2, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelInput.add(new JLabel("Receiver Name:"));
        txtReceiverName = new JTextField();
        panelInput.add(txtReceiverName);

        JButton btnSearch = new JButton("Search");
        panelInput.add(btnSearch);

        // Result area
        txtResult = new JTextArea();
        txtResult.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResult);

        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add button action
        btnSearch.addActionListener(e -> searchBloodRequests());
    }

    private void searchBloodRequests() {
        String receiverName = txtReceiverName.getText().trim();
        if (receiverName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a receiver name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Clear the previous result
        txtResult.setText("");

        // Database query
        String query = """
                SELECT r.id AS RequestID, r.status AS Status, rec.name AS ReceiverName, rec.blood_type AS BloodType
                FROM BloodRequests r
                JOIN Receiver rec ON r.receiver_id = rec.id
                WHERE rec.name LIKE ?;
                """;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, "%" + receiverName + "%"); // Wildcard search for name
            ResultSet rs = pstmt.executeQuery();

            // Check if results exist
            boolean hasResults = false;
            while (rs.next()) {
                hasResults = true;
                int requestId = rs.getInt("RequestID");
                String status = rs.getString("Status");
                String name = rs.getString("ReceiverName");
                String bloodType = rs.getString("BloodType");

                txtResult.append("Request ID: " + requestId + "\n");
                txtResult.append("Status: " + status + "\n");
                txtResult.append("Receiver Name: " + name + "\n");
                txtResult.append("Blood Type: " + bloodType + "\n");
                txtResult.append("-----------------------------\n");
            }

            if (!hasResults) {
                txtResult.setText("No blood requests found for the receiver: " + receiverName);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReceiverRequest app = new ReceiverRequest();
            app.setVisible(true);
        });
    }
}
