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

public class MainFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Donor Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);

            // Add the Donor GUI panel
            frame.add(new DonorCreationGUI().getPanel());
            frame.setVisible(true);
        });
    }
}
