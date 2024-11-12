import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountGUI {
    public CreateAccountGUI() {
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

                if (accountType.equals("Hospital")) {
                    BloodBankApp.hospitalAccounts.put(username, password);
                } else {
                    BloodBankApp.donorAccounts.put(username, password);
                }

                JOptionPane.showMessageDialog(createAccountFrame, accountType + " account created successfully.");
                createAccountFrame.dispose();
            }
        });

        createAccountFrame.setVisible(true);

    }
}