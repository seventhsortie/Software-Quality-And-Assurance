package javamilestone;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID exists");
        }
        Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
        contacts.put(contactID, newContact);
    }

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID is non-existent");
        }
        contacts.remove(contactID);
    }

    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID is non-existent");
        }
        Contact existingContact = contacts.get(contactID);
        if (firstName != null) {
            existingContact.setFirstName(firstName);
        }
        if (lastName != null) {
            existingContact.setLastName(lastName);
        }
        if (phone != null) {
            existingContact.setPhone(phone);
        }
        if (address != null) {
            existingContact.setAddress(address);
        }
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
