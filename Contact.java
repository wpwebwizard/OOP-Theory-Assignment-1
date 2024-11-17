public class Contact {
    private String contactID;
    private String name;

    // Constructor
    public Contact(String contactID, String name) {
        this.contactID = contactID;
        this.name = name;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getName() {
        return name;
    }

    // Display contact details
    public void displayContact() {
        System.out.println("Contact ID: " + contactID + ", Name: " + name);
    }
}
