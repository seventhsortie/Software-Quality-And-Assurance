package meeting;

import java.util.Date;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private final String description;

    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null || appointmentID.length() > 10 || appointmentDate == null || appointmentDate.before(new Date()) || description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return appointmentDate;
    }

    public String getId() {
        return appointmentID;
    }
}
