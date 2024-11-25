/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbank;

/**
 *
 * @author sharathbandela
 */
public class RejectBloodRequest {

    // Method to simulate rejection of a blood request based on Request ID
    public void rejectRequest(String requestID) {
        // Simulate database interaction (just printing for this case)
        System.out.println("Blood request rejected: Request ID = " + requestID);
    }

    // Main method to test rejection functionality
    public static void main(String[] args) {
        RejectBloodRequest rejectBloodRequest = new RejectBloodRequest();

        // Example request ID to reject
        String requestID = "12345";

        // Reject the request
        rejectBloodRequest.rejectRequest(requestID);
    }
}
