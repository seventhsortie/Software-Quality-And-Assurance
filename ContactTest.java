package test;

import javamilestone.Contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "First", "Last", "1234567890", "Address"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", null, "Last", "1234567890", "Address"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", "First", null, "1234567890", "Address"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", "First", "Last", null, "Address"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("ID", "First", "Last", "1234567890", null));
    }

    @Test
    public void testValidContact() {
        Contact validContact = new Contact("ID", "First", "Last", "1234567890", "Address");
        assertNotNull(validContact);
    }

    @Test
    public void testGetters() {
        Contact contact = new Contact("ID", "First", "Last", "1234567890", "Address");
        assertEquals("ID", contact.getContactID());
        assertEquals("First", contact.getFirstName());
        assertEquals("Last", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("Address", contact.getAddress());
    }

    @Test
    public void testSetters() {
        Contact contact = new Contact("ID", "First", "Last", "1234567890", "Address");
        contact.setFirstName("NewFirst");
        assertEquals("NewFirst", contact.getFirstName());
        contact.setLastName("NewLast");
        assertEquals("NewLast", contact.getLastName());
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
        contact.setAddress("NewAddress");
        assertEquals("NewAddress", contact.getAddress());
    }

    @Test
    public void testSettersException() {
        Contact contact = new Contact("ID", "First", "Last", "1234567890", "Address");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    @Test
    public void testUpdateAndGetCombination() {
        Contact contact = new Contact("ID", "First", "Last", "1234567890", "Address");
        contact.setFirstName("NewFirst");
        assertEquals("NewFirst", contact.getFirstName());
        contact.setLastName("NewLast");
        assertEquals("NewLast", contact.getLastName());
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
        contact.setAddress("NewAddress");
        assertEquals("NewAddress", contact.getAddress());
    }

    @Test
    public void testMultipleUpdates() {
        Contact contact = new Contact("ID", "First", "Last", "1234567890", "Address");
        contact.setFirstName("NewFirst");
        contact.setFirstName("AnotherFirst");
        assertEquals("AnotherFirst", contact.getFirstName());
    }

    @Test
    public void testContactIDSetter() {
        Contact contact = new Contact("ID", "First", "Last", "1234567890", "Address");
        contact.setContactID("NewID");
        assertEquals("NewID", contact.getContactID());
    }

    @Test
    public void testContactIDSetterException() {
        Contact contact = new Contact("ID", "First", "Last", "1234567890", "Address");
        assertThrows(IllegalArgumentException.class, () -> contact.setContactID(null));
    }
}
