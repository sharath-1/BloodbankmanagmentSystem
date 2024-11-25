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

public class BookCancelAppointment extends JFrame {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/BloodBankDB";
    private static final String DB_USER = "root"; // Replace with your MySQL username
    private static final String DB_PASSWORD = ""; // Replace with your MySQL password

    private JTextField txtAppointmentID, txtDate, txtTime;
    private JTextArea txtOutput;

    public BookCancelAppointment() {
        // JFrame settings
        setTitle("Blood Donation Appointment Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Input panel
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 10, 10));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelInput.add(new JLabel("Appointment ID:"));
        txtAppointmentID = new JTextField();
        panelInput.add(txtAppointmentID);

        panelInput.add(new JLabel("Date (YYYY-MM-DD):"));
        txtDate = new JTextField();
        panelInput.add(txtDate);

        panelInput.add(new JLabel("Time (HH:MM):"));
        txtTime = new JTextField();
        panelInput.add(txtTime);

        JButton btnBookAppointment = new JButton("Book Appointment");
        JButton btnCancelAppointment = new JButton("Cancel Appointment");

        panelInput.add(btnBookAppointment);
        panelInput.add(btnCancelAppointment);

        // Output area
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtOutput);

        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Button actions
        btnBookAppointment.addActionListener(e -> bookAppointment());
        btnCancelAppointment.addActionListener(e -> cancelAppointment());
    }

    private void bookAppointment() {
        String appointmentID = txtAppointmentID.getText().trim();
        String date = txtDate.getText().trim();
        String time = txtTime.getText().trim();

        if (appointmentID.isEmpty() || date.isEmpty() || time.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert into database
        String query = "INSERT INTO Appointments (appointment_id, date, time) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, appointmentID);
            pstmt.setString(2, date);
            pstmt.setString(3, time);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                txtOutput.append("Appointment booked successfully:\n");
                txtOutput.append("Appointment ID: " + appointmentID + "\nDate: " + date + "\nTime: " + time + "\n\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelAppointment() {
        String appointmentID = txtAppointmentID.getText().trim();

        if (appointmentID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an Appointment ID to cancel.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Delete from database
        String query = "DELETE FROM Appointments WHERE appointment_id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, appointmentID);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                txtOutput.append("Appointment canceled successfully:\n");
                txtOutput.append("Appointment ID: " + appointmentID + "\n\n");
            } else {
                txtOutput.append("No appointment found with ID: " + appointmentID + "\n\n");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookCancelAppointment app = new BookCancelAppointment();
            app.setVisible(true);
        });
    }
}
