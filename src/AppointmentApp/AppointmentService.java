package AppointmentApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//11-Randevu islmeleri
public class AppointmentService {

    Scanner inp=new Scanner(System.in);
    List<Appointment> appoinments=new ArrayList<>();
    //12-randevu oluşturma
    public void getAppoinment(DoctorService doctorService){
        //13-randevu alınacak dr seçimi
        doctorService.printDoctors();
        System.out.println("Randevu almak istediğiniz doktoru seçiniz(no): ");
        int selectDoctor=inp.nextInt();//11,22,33
//13-hatalı no ile giriş
        if(doctorService.getDoctorById(selectDoctor)!=null){
            Doctor doctor=doctorService.getDoctorById(selectDoctor);
            //14-seçilen doktorun randevu tarihleri dolu mu
            if(!doctor.getDates().isEmpty()){
                System.out.println("Lütfen isminizi girirniz:");
                String name=inp.nextLine();
                name=inp.nextLine();
                System.out.println("Sayın "+name+" randevu alabileceğiniz tarihler: ");
                for(int i=0;i<doctor.getDates().size();i++){
                    System.out.println((i+1)+" - "+doctor.getDates().get(i));//1-02.02.2023
                    //2-03.02.2023
                }
                System.out.println("Randevu almak istediğiniz tarihin numarasını giriniz:");
                int select=inp.nextInt();
//14-hatalı giriş: doğru tarih seçildi mi
                if(select>0 && select<=doctor.getDates().size()){
                    Appointment appoinment=new Appointment(name,doctor,doctor.getDates().get(select-1));
                    this.appoinments.add(appoinment);
                    System.out.println("Sayın "+name+", Randevu tarihiniz: "+doctor.getDates().get(select-1));
                    System.out.println("Randevu no: "+appoinment.getId()+" ile randevu bilgilerinizi görüntüleyebilirsiniz.");
//15-randevu başarılı bir şekilde oluşturulunca doktorun takviminden seçilen tarih kaldırılsın
                    doctor.getDates().remove(select-1);
                }else{
                    System.out.println("Hatalı giriş!!!");
                }
            }else{
                System.out.println(doctor.getName()+" nun bu hafta tüm randevuları dolmuştur, daha sonra tekrar deneyiniz.");
            }
        }
        else{
            System.out.println("Hatalı giriş!");
        }

    }
    //16-randevu bilgilerini yazdır
    public void printAppoinment(){
        boolean isExist=true;
        System.out.println("Randevu giriniz: ");
        int appId=inp.nextInt();
        for(Appointment app: this.appoinments){
            if (app.getId()==appId){
                isExist=true;
                System.out.println("--------------------------------------");
                System.out.println(appId+" No'lu Randevu Bilgileri ");
                System.out.println("Hasta adı     : "+app.getName());
                System.out.println("Branş         : "+app.getDoctor().getDepartment());
                System.out.println("Doktor        : "+app.getDoctor().getName());
                System.out.println("Randevu tarihi: "+app.getDate());
                System.out.println("--------------------------------------");
                break;
            }else{
                isExist=false;
            }
        }
        if (!isExist){
            System.out.println("Randevu bulunamadı...");
        }
    }
}
