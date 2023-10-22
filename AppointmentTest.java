package test;

import meeting.Appointment;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    @Test
    public void testAppointmentConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, new Date(), "description");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", new Date(), "description");
        });

        Date pastDate = new Date(System.currentTimeMillis() - 10000);
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", pastDate, "description");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(), null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", new Date(), "This description does not seem to fit within the fifty character limit.");
        });
    }

    @Test
    public void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment validAppointment = new Appointment("123", futureDate, "Valid description");
        assertNotNull(validAppointment);
    }

    @Test
    public void testGetId() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("123", futureDate, "Valid description");
        assertEquals("123", appointment.getId());
    }

    @Test
    public void testGetDate() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("123", futureDate, "Valid description");
        assertEquals(futureDate, appointment.getDate());
    }

    @Test
    public void testGetDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("123", futureDate, "Valid description");
        assertEquals("Valid description", appointment.getDescription());
    }

    @Test
    public void testGetAppointmentID() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("123", futureDate, "Valid description");
        assertEquals("123", appointment.getAppointmentID());
    }

    @Test
    public void testGetAppointmentDate() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("123", futureDate, "Valid description");
        assertEquals(futureDate, appointment.getAppointmentDate());
    }

    @Test
    public void testFullValidConstructor() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        Appointment appointment = new Appointment("123", futureDate, "Valid description");
        assertEquals("123", appointment.getId());
        assertEquals(futureDate, appointment.getDate());
        assertEquals("Valid description", appointment.getDescription());
    }
}
