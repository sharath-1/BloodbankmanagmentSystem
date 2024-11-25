/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbank;

/**
 *
 * @author sharathbandela
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonorAccountDAO {
    public static boolean saveDonor(String username, String password) {
        String sql = "INSERT INTO donors (username, password) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true; // Account created successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Error occurred
        }
    }
}
