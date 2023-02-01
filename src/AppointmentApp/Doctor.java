package AppointmentApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor {

    private int id;
    private String name;
    private String department;
    private List<String> dates = new ArrayList<>();

    //4- doctor nesnesi olusturuldugunda randevu tarihleri de olsun


    public Doctor(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        LocalDate day = LocalDate.now(); //sisteme girilen gün:01.02

        for (int i = 0; i < 3; i++) { //test edebilmek icin 3 yaptik, 7 olmali
            day.plusDays(1);//02.02,03.02.04.02
            this.dates.add(day.toString());
        }
    }

    //5-getter-setter metodlarini olustur


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getDates() {
        return dates;
    }
}
