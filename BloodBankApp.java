import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BloodBankApp {
    protected static Object hospitalAccounts;
    protected static Object donorAccounts;

    public BloodBankApp() {
        JFrame createAccountFrame = new JFrame("Create Account");
        createAccountFrame.setSize(400, 300);
        createAccountFrame.setLayout(null);

        JLabel accountTypeLabel = new JLabel("Select Account Type:");
        accountTypeLabel.setBounds(50, 30, 200, 30);
        createAccountFrame.add(accountTypeLabel);

        JComboBox<String> accountTypeCombo = new JComboBox<>(new String[] { "Hospital", "Donor" });
        accountTypeCombo.setBounds(200, 30, 100, 30);
        createAccountFrame.add(accountTypeCombo);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 80, 100, 30);
        createAccountFrame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 80, 150, 30);
        createAccountFrame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 130, 100, 30);
        createAccountFrame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 150, 30);
        createAccountFrame.add(passwordField);

        JButton createButton = new JButton("Create Account");
        createButton.setBounds(150, 180, 150, 30);
        createAccountFrame.add(createButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountType = accountTypeCombo.getSelectedItem().toString();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(createAccountFrame, "Username and Password cannot be empty.");
                    return;
                }

                try (Connection conn = DatabaseConnection.getConnection()) {
                    String query = accountType.equals("Hospital")
                            ? "INSERT INTO hospital_accounts (username, password) VALUES (?, ?)"
                            : "INSERT INTO donor_accounts (username, password) VALUES (?, ?)";

                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(createAccountFrame, accountType + " account created successfully.");
                    createAccountFrame.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(createAccountFrame, "Account creation failed: " + ex.getMessage());
                }
            }
        });

        createAccountFrame.setVisible(true);

    public static void main(String[] args) {
        launch(args);
    }
    }
}
