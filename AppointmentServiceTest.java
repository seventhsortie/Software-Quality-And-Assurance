package test;

import meeting.Appointment;
import meeting.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppointmentServiceTest {

    AppointmentService appointmentService;
    Appointment appointment1;
    Appointment appointment2;

    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
        appointment1 = new Appointment("123", new Date(System.currentTimeMillis() + 1000000), "First appointment");
        appointment2 = new Appointment("456", new Date(System.currentTimeMillis() + 2000000), "Second appointment");
    }

    @Test
    public void testAddUniqueAppointment() {
        appointmentService.addAppointment(appointment1);
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment1));
    }

    @Test
    public void testDeleteAppointment() {
        appointmentService.addAppointment(appointment1);
        appointmentService.deleteAppointment("123");
    }
}
