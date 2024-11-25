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

public class DonorCreationGUI {
    private JPanel panel;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JTextArea outputArea;

    public DonorCreationGUI() {
        // Main panel
        panel = new JPanel(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Create Donor Account"));

        // Input fields
        inputPanel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        inputPanel.add(txtUsername);

        inputPanel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        inputPanel.add(txtPassword);

        JButton btnCreate = new JButton("Create Account");
        inputPanel.add(btnCreate);

        // Output area
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        panel.add(inputPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        // Action listener for button
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createDonorAccount();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    private void createDonorAccount() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            outputArea.append("All fields are required.\n");
            return;
        }

        boolean success = DonorAccountDAO.saveDonor(username, password);

        if (success) {
            outputArea.append("Account created successfully:\n");
            outputArea.append("Username: " + username + "\n\n");

            // Clear input fields
            txtUsername.setText("");
            txtPassword.setText("");
        } else {
            outputArea.append("Error: Could not create account. Username may already exist.\n");
        }
    }
}
