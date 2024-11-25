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

public class BloodBankManagementSystem extends JFrame {

    private JTextField txtRequestId, txtReason, txtDonorName, txtBloodType, txtQuantity;
    private JTextField txtReceiverName, txtHospitalDetails, txtExpiryDate, txtLowInventory, txtNotification;
    private JTextArea txtOutput;

    public BloodBankManagementSystem() {
        // Set up the main frame
        setTitle("Blood Bank Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main panel with tabbed panes for use cases
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add individual tabs for use cases
        tabbedPane.addTab("Approve Request", createApproveRequestPanel());
        tabbedPane.addTab("Reject Request", createRejectRequestPanel());
        tabbedPane.addTab("Add Donation", createAddDonationPanel());
        tabbedPane.addTab("Track Shipments", createTrackShipmentsPanel());
        tabbedPane.addTab("Urgent Requests", createUrgentRequestsPanel());
        tabbedPane.addTab("Set Expiry Alerts", createExpiryAlertsPanel());
        tabbedPane.addTab("Low Inventory Alerts", createLowInventoryAlertsPanel());
        tabbedPane.addTab("View Request History", createRequestHistoryPanel());
        tabbedPane.addTab("Notify Receiver", createNotifyReceiverPanel());
        tabbedPane.addTab("Generate Reports", createGenerateReportsPanel());
        tabbedPane.addTab("Hospital Information", createHospitalInformationPanel());
        tabbedPane.addTab("Block Donor", createBlockDonorPanel());

        // Output panel to display results
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtOutput);

        add(tabbedPane, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    // Panel to Approve a Blood Request
    private JPanel createApproveRequestPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblRequestId = new JLabel("Request ID:");
        txtRequestId = new JTextField();

        JButton btnApprove = new JButton("Approve");
        btnApprove.addActionListener(e -> approveBloodRequest());

        panel.add(lblRequestId);
        panel.add(txtRequestId);
        panel.add(new JLabel()); // Empty cell
        panel.add(btnApprove);

        return panel;
    }

    // Panel to Reject a Blood Request
    private JPanel createRejectRequestPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblRequestId = new JLabel("Request ID:");
        txtRequestId = new JTextField();

        JLabel lblReason = new JLabel("Reason:");
        txtReason = new JTextField();

        JButton btnReject = new JButton("Reject");
        btnReject.addActionListener(e -> rejectBloodRequest());

        panel.add(lblRequestId);
        panel.add(txtRequestId);
        panel.add(lblReason);
        panel.add(txtReason);
        panel.add(new JLabel()); // Empty cell
        panel.add(btnReject);

        return panel;
    }

    // Panel to Add Blood Donation Details
    private JPanel createAddDonationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblDonorName = new JLabel("Donor Name:");
        txtDonorName = new JTextField();

        JLabel lblBloodType = new JLabel("Blood Type:");
        txtBloodType = new JTextField();

        JLabel lblQuantity = new JLabel("Quantity:");
        txtQuantity = new JTextField();

        JButton btnAddDonation = new JButton("Add Donation");
        btnAddDonation.addActionListener(e -> addBloodDonation());

        panel.add(lblDonorName);
        panel.add(txtDonorName);
        panel.add(lblBloodType);
        panel.add(txtBloodType);
        panel.add(lblQuantity);
        panel.add(txtQuantity);
        panel.add(new JLabel()); // Empty cell
        panel.add(btnAddDonation);

        return panel;
    }

    // Panel to Track Blood Shipments
    private JPanel createTrackShipmentsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel lblRequestId = new JLabel("Request ID:");
        txtRequestId = new JTextField();

        JButton btnTrack = new JButton("Track Shipment");
        btnTrack.addActionListener(e -> trackBloodShipment());

        panel.add(lblRequestId);
        panel.add(txtRequestId);
        panel.add(new JLabel()); // Empty cell
        panel.add(btnTrack);

        return panel;
    }

    // Panel to Handle Urgent Blood Requests
    private JPanel createUrgentRequestsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel lblRequestId = new JLabel("Urgent Request ID:");
        txtRequestId = new JTextField();

        JButton btnHandle = new JButton("Handle Urgent Request");
        btnHandle.addActionListener(e -> handleUrgentRequest());

        panel.add(lblRequestId);
        panel.add(txtRequestId);
        panel.add(new JLabel()); // Empty cell
        panel.add(btnHandle);

        return panel;
    }

    // Panel to Set Blood Expiration Alerts
    private JPanel createExpiryAlertsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel lblExpiryDate = new JLabel("Expiry Date:");
        txtExpiryDate = new JTextField();

        JButton btnSetAlert = new JButton("Set Expiry Alert");
        btnSetAlert.addActionListener(e -> setExpiryAlert());

        panel.add(lblExpiryDate);
        panel.add(txtExpiryDate);
        panel.add(new JLabel()); // Empty cell
        panel.add(btnSetAlert);

        return panel;
    }

    // Panel to Set Low Inventory Alerts
    private JPanel createLowInventoryAlertsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel lblLowInventory = new JLabel("Critical Level:");
        txtLowInventory = new JTextField();

        JButton btnSetAlert = new JButton("Set Low Inventory Alert");
        btnSetAlert.addActionListener(e -> setLowInventoryAlert());

        panel.add(lblLowInventory);
        panel.add(txtLowInventory);
        panel.add(new JLabel()); // Empty cell
        panel.add(btnSetAlert);

        return panel;
    }

    // Panel to Notify Receivers
    private JPanel createNotifyReceiverPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel lblNotification = new JLabel("Notification Message:");
        txtNotification = new JTextField();

        JButton btnNotify = new JButton("Notify Receiver");
        btnNotify.addActionListener(e -> notifyReceiver());

        panel.add(lblNotification);
        panel.add(txtNotification);
        panel.add(new JLabel()); // Empty cell
        panel.add(btnNotify);

        return panel;
    }

    // Additional panels like Generate Reports, Block Donors, View History, etc., follow similar patterns...

    // Methods for various functionalities
    private void approveBloodRequest() {
        txtOutput.append("Request approved: " + txtRequestId.getText() + "\n");
    }

    private void rejectBloodRequest() {
        txtOutput.append("Request rejected: " + txtRequestId.getText() + ", Reason: " + txtReason.getText() + "\n");
    }

    private void addBloodDonation() {
        txtOutput.append("Donation added: Donor " + txtDonorName.getText() + ", Blood Type " + txtBloodType.getText() +
                ", Quantity " + txtQuantity.getText() + "\n");
    }

    private void trackBloodShipment() {
        txtOutput.append("Tracking shipment for request: " + txtRequestId.getText() + "\n");
    }

    private void handleUrgentRequest() {
        txtOutput.append("Handled urgent request: " + txtRequestId.getText() + "\n");
    }

    private void setExpiryAlert() {
        txtOutput.append("Set expiry alert for date: " + txtExpiryDate.getText() + "\n");
    }

    private void setLowInventoryAlert() {
        txtOutput.append("Set low inventory alert for level: " + txtLowInventory.getText() + "\n");
    }

    private void notifyReceiver() {
        txtOutput.append("Notified receiver with message: " + txtNotification.getText() + "\n");
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BloodBankManagementSystem frame = new BloodBankManagementSystem();
            frame.setVisible(true);
        });
    }
}
