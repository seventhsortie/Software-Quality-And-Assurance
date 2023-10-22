package test;

import javamilestone.ContactService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        service.addContact("1", "Mikayla", "David", "1234567890", "123 Main St");
        assertNotNull(service.getContact("1"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact("1", "Mikayla", "David", "1234567890", "123 Main St");
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        service.addContact("1", "Mikayla", "David", "1234567890", "123 Main St");
        service.updateContact("1", "Mikayla", "Smith", "0987654321", "321 Main St");
        assertNotNull(service.getContact("1"));
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        service.addContact("1", "Mikayla", "David", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact("1", "John", "Doe", "0987654321", "321 Main St"));
    }

    @Test
    public void testDeleteNonExistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("1"));
    }

    @Test
    public void testUpdateNonExistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("1", "Mikayla", "Smith", "0987654321", "321 Main St"));
    }
}
