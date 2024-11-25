/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodbank;

/**
 *
 * @author sharathbandela
 */
public class NotifyReceiverOfBloodAvailability {
    private String bloodType;
    private int stockLevel;
    private String receiverEmail;
    private String requestID;

    // Constructor
    public NotifyReceiverOfBloodAvailability(String bloodType, int stockLevel, String receiverEmail, String requestID) {
        this.bloodType = bloodType;
        this.stockLevel = stockLevel;
        this.receiverEmail = receiverEmail;
        this.requestID = requestID;
    }

    // Method to notify receiver
    public void notifyReceiver() {
        if (stockLevel > 0) {
            System.out.println("Notification: Blood available for the following request:");
            System.out.println("Request ID: " + requestID);
            System.out.println("Blood Type: " + bloodType);
            System.out.println("Stock Level: " + stockLevel);
            System.out.println("Receiver Email: " + receiverEmail);
            System.out.println("Message: Blood is available for your request. Please contact the blood bank for further details.");
        } else {
            System.out.println("Notification: Blood unavailable for the following request:");
            System.out.println("Request ID: " + requestID);
            System.out.println("Blood Type: " + bloodType);
            System.out.println("Message: Unfortunately, the requested blood type is currently out of stock.");
        }
    }

    // Main method to simulate blood availability notification
    public static void main(String[] args) {
        // Simulating a blood availability request
        String bloodType = "O+";
        int stockLevel = 5;  // Assume we have 5 units of this blood type available
        String receiverEmail = "receiver@example.com";
        String requestID = "REQ12345";

        // Create an instance of NotifyReceiverOfBloodAvailability
        NotifyReceiverOfBloodAvailability notification = new NotifyReceiverOfBloodAvailability(bloodType, stockLevel, receiverEmail, requestID);

        // Notify the receiver about blood availability
        notification.notifyReceiver();
    }
}
