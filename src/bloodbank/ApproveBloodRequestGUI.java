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

public class ApproveBloodRequestGUI extends JFrame {
    private JTextField txtRequestID;
    private JTextArea txtOutput;

    public ApproveBloodRequestGUI() {
        setTitle("Approve Blood Request");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLayout(new BorderLayout());

        // Panel for user input
        JPanel panelInput = new JPanel(new GridLayout(2, 2));
        panelInput.add(new JLabel("Blood Request ID:"));
        txtRequestID = new JTextField();
        panelInput.add(txtRequestID);

        // Button to approve request
        JButton btnApproveRequest = new JButton("Approve Request");
        panelInput.add(btnApproveRequest);

        // Output area to display the result
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        JScrollPane scrollOutput = new JScrollPane(txtOutput);

        // Add components to the JFrame
        add(panelInput, BorderLayout.CENTER);
        add(scrollOutput, BorderLayout.SOUTH);

        // Button click listener to approve the blood request
        btnApproveRequest.addActionListener(e -> approveRequest());
    }

    private void approveRequest() {
        String requestID = txtRequestID.getText();

        // Simulating the approval of the request and showing the result in the console
        if (requestID.isEmpty()) {
            txtOutput.append("Please enter a valid Blood Request ID.\n");
        } else {
            txtOutput.append("Blood request approved: Request ID = " + requestID + "\n");

            // Output to console
            System.out.println("Blood request approved: Request ID = " + requestID);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ApproveBloodRequestGUI().setVisible(true);
        });
    }
}
