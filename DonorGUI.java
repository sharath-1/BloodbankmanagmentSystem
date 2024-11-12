import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonorGUI {
    JFrame donorFrame;

    public DonorGUI() {
        donorFrame = new JFrame("Donor Dashboard");
        donorFrame.setSize(500, 400);
        donorFrame.setLayout(null);

        JLabel label = new JLabel("Donor Dashboard");
        label.setBounds(180, 20, 200, 30);
        donorFrame.add(label);

        JButton viewEligibilityButton = new JButton("View Donation Eligibility");
        viewEligibilityButton.setBounds(150, 70, 200, 30);
        viewEligibilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEligibility();
            }
        });
        donorFrame.add(viewEligibilityButton);

        JButton bookAppointmentButton = new JButton("Book Donation Appointment");
        bookAppointmentButton.setBounds(150, 110, 200, 30);
        bookAppointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookAppointment();
            }
        });
        donorFrame.add(bookAppointmentButton);

        JButton viewHistoryButton = new JButton("View Donation History");
        viewHistoryButton.setBounds(150, 150, 200, 30);
        viewHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewHistory();
            }
        });
        donorFrame.add(viewHistoryButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(150, 190, 200, 30);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                donorFrame.dispose();
            }
        });
        donorFrame.add(logoutButton);

        donorFrame.setVisible(true);
    }

    private void viewEligibility() {
        JOptionPane.showMessageDialog(donorFrame, "Viewing donation eligibility.");
    }

    private void bookAppointment() {
        JOptionPane.showMessageDialog(donorFrame, "Booking a donation appointment.");
    }

    private void viewHistory() {
        JOptionPane.showMessageDialog(donorFrame, "Viewing donation history.");
    }
}
