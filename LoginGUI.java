import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginGUI {
    public LoginGUI() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 300);
        loginFrame.setLayout(null);

        JLabel accountTypeLabel = new JLabel("Select Account Type:");
        accountTypeLabel.setBounds(50, 30, 200, 30);
        loginFrame.add(accountTypeLabel);

        JComboBox<String> accountTypeCombo = new JComboBox<>(new String[] { "Hospital", "Donor" });
        accountTypeCombo.setBounds(200, 30, 100, 30);
        loginFrame.add(accountTypeCombo);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 80, 100, 30);
        loginFrame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 80, 150, 30);
        loginFrame.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 130, 100, 30);
        loginFrame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 150, 30);
        loginFrame.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 180, 100, 30);
        loginFrame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountType = accountTypeCombo.getSelectedItem().toString();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                String query = accountType.equals("Hospital")
                        ? "SELECT * FROM hospital_accounts WHERE username = ? AND password = ?"
                        : "SELECT * FROM donor_accounts WHERE username = ? AND password = ?";

                try (Connection conn = DatabaseConnection.getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(query)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        loginFrame.dispose();
                        if (accountType.equals("Hospital")) {
                            new HospitalGUI();
                        } else {
                            new DonorGUI();
                        }
                    } else {
                        JOptionPane.showMessageDialog(loginFrame, "Invalid credentials.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(loginFrame, "Login failed: " + ex.getMessage());
                }
            }
        });

        loginFrame.setVisible(true);
    }
}
