import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalGUI {
    JFrame hospitalFrame;

    public HospitalGUI() {
        hospitalFrame = new JFrame("Hospital Management");
        hospitalFrame.setSize(500, 400);
        hospitalFrame.setLayout(null);

        JLabel label = new JLabel("Hospital Dashboard");
        label.setBounds(180, 20, 200, 30);
        hospitalFrame.add(label);

        JButton manageInventoryButton = new JButton("Manage Blood Inventory");
        manageInventoryButton.setBounds(150, 70, 200, 30);
        manageInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manageBloodInventory();
            }
        });
        hospitalFrame.add(manageInventoryButton);

        JButton viewInventoryButton = new JButton("View Blood Inventory");
        viewInventoryButton.setBounds(150, 110, 200, 30);
        viewInventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewBloodInventory();
            }
        });
        hospitalFrame.add(viewInventoryButton);

        JButton approveRequestButton = new JButton("Approve Blood Request");
        approveRequestButton.setBounds(150, 150, 200, 30);
        hospitalFrame.add(approveRequestButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(150, 190, 200, 30);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hospitalFrame.dispose();
            }
        });
        hospitalFrame.add(logoutButton);

        hospitalFrame.setVisible(true);
    }

    private void manageBloodInventory() {
        // Example logic for managing inventory
        JOptionPane.showMessageDialog(hospitalFrame, "Managing Blood Inventory.");
    }

    private void viewBloodInventory() {
        // Example logic for viewing inventory
        JOptionPane.showMessageDialog(hospitalFrame, "Viewing Blood Inventory.");
    }
}
