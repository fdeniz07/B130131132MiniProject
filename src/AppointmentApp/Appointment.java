package AppointmentApp;

//6-Randevu:
//            -id : otomatik üretilsin
//            -hasta adı,Doktor,randevu tarihi
public class Appointment {

    private static int count=0;
    private int id;
    private String name;
    private Doctor doctor;
    private String date;

    public Appointment(String name, Doctor doctor, String date) {
        count++;
        this.id=count;
        this.name = name;
        this.doctor = doctor;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
