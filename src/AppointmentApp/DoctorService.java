package AppointmentApp;

//7-Doctor islemleri

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    //8-Sistemde doktorlar kayıtlı olsun.
    List<Doctor> doctorList=new ArrayList<>();

    public DoctorService() {
        Doctor doctor1=new Doctor(11,"Dr. Michelangelo","Göz");
        Doctor doctor2=new Doctor(22,"Dr. Rafael","KBB");
        Doctor doctor3=new Doctor(33,"Dr. Leonardo","Genel Cerrahi");
        this.doctorList.add(doctor1);
        this.doctorList.add(doctor2);
        this.doctorList.add(doctor3);
    }
    //9-doktor listesi: No: Adı: Branşı: Takvim:randevu için uygun tarihler alt alta
    public void printDoctors(){
        System.out.println("----------------------------- Doktorlar ----------------------------- ");
        for(Doctor doctor: doctorList){
            //System.out.println(doctor.toString());
            System.out.println("No: "+doctor.getId()+" Adı: "+doctor.getName()+" Branşı: "+doctor.getDepartment());
            System.out.println("Takvim: ");
            for(String date: doctor.getDates()){
                System.out.println(date);
            }
        }
        System.out.println("---------------------------------------------------------------------- ");
    }
    //10-id ile doctor bulma
    public Doctor getDoctorById(int id) {
        for (Doctor  dr:this.doctorList){
            if(dr.getId()==id){
                return dr;
            }
        }
        return null;
    }
}
