package loginpage;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserServices {
    List<String> userNames = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> passwords = new ArrayList<>();


    public void register() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ad-Soyad : ");
        String name = input.nextLine();

        String username;
        boolean existsUsername;

        do {
            System.out.println(" Kullanici adi giriniz:");
            username = input.nextLine().trim();
            existsUsername = this.userNames.contains(username);

            if (existsUsername) {
                System.out.println("Bu username kullanilmis, farkli bir username deneyiniz!");
            }
        } while (existsUsername);

        String email;
        boolean isValid;
        boolean existEmail;

        do {

            System.out.println("Email giriniz: ");
            email = input.nextLine().trim();
            isValid = validateEmail(email); //Email gecerli mi?
            existEmail = this.emails.contains(email); //Email önceden kayitli mi?
            if (existEmail) {
                System.out.println("Bu email adresi zaten kayitli, farkli bir email deneyiniz");
                isValid = false;
            }
        } while (isValid);

        String password;
        boolean isValidPsw;

        do {
            System.out.println("Sifrenizi giriniz: ");
            password = input.next().trim();
            isValidPsw = validatePassword(password);

        } while (!isValidPsw);

        User user = new User(name, username, email, password);
        this.userNames.add(user.username);
        this.emails.add(user.email);
        this.passwords.add(user.password);
        System.out.println("Tebrikler isleminiz basariyla gerceklestirildi.");
        System.out.println("Kullanici adi veya email ile sisteme giris yapabilirsiniz.");
    }

    public void login(){
        Scanner input = new Scanner(System.in);
        System.out.println("Kullanici adi veya email giriniz:");
        String userNameOrEmail = input.nextLine(); //sparrow

        //Kullanicinin girdigi deger email mi userName mi?
        boolean isMail = this.emails.contains(userNameOrEmail);
        boolean isUserName = this.userNames.contains(userNameOrEmail);

        if (isUserName || isMail){

            boolean isWrong=true;

            while (isWrong){
                System.out.println("Sifrenizi giriniz: ");
                String password = input.next();

                //userName / email ile sifre ayni indexte olmali
                int index;
                if (isUserName){
                    index=this.userNames.indexOf(userNameOrEmail);
                }
                else {
                    index=this.emails.indexOf(userNameOrEmail);
                }

                if (this.passwords.get(index).equals(password)){
                    System.out.println("Sisteme giris yaptiniz.");
                    isWrong= false;
                }
                else {
                    System.out.println("Sifreniz yanlis, tekrar deneyiniz.");
                }
            }
        }
        else {
            System.out.println("Sisteme kayitli kullanici bulunamadi.");
            System.out.println("Üyeyseniz bilgilerinizi kontrol ediniz, degilseniz lütfen üye olunuz.");
        }
    }

    public static boolean validateEmail(String email) {
        boolean isValid;
        boolean space = email.contains(" ");
        boolean isContainAt = email.contains("@");

        if (space) {
            System.out.println("Email bosluk iceremez!");
            isValid = false;
        } else if (!isContainAt) {
            System.out.println("Email @ icermelidir");
            isValid = false;
        } else { //asd123-._@gmail.com split=>[asd123-._,gmail.com
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            int notValid = firstPart.replaceAll("[a-zA-Z0-9_.-]", "").length(); //Asd12-._*=>*
            boolean checkStart = notValid == 0;

            boolean checkEnd = secondPart.equals("gmail.com") ||
                    secondPart.equals("hotmail.com") ||
                    secondPart.equals("yahoo.com");

            if (!checkStart) {

                System.out.println("email kücük harf, büyük harf, rakam ve -._ disinda karakter iceremez!");
            } else if (!checkEnd) {

                System.out.println("email gmail.com, hotmail.com veya yahoo.com ile bitmelidir");
            }
            isValid = checkStart && checkEnd;
        }

        if (!isValid) {
            System.out.println("Gecersiz email adresi, tekrar deneyiniz.");
        }

        return isValid;
    }

    public static boolean validatePassword(String password) {
        boolean isValid;
        String upperLetter = password.replaceAll("[^A-Z]", ""); //asDF123 ->DF
        String lowerLetter = password.replaceAll("[^a-z]", "");
        String digit = password.replaceAll("[\\D]", "");
        String symbol = password.replaceAll("[\\P{Punct}]", "");

        boolean space = password.contains(" ");
        boolean lenghtGraterThan6 = password.length() > 5;
        boolean existUpper = upperLetter.length() > 0;
        boolean existLower = lowerLetter.length() > 0;
        boolean existDigit = digit.length() > 0;
        boolean existSymbol = symbol.length() > 0;

        if (space) {
            System.out.println("Sifre bosluk iceremez");
        } else if (!lenghtGraterThan6) {
            System.out.println("Sifre en az 6 karakter olmalidir");
        } else if (!existUpper) {
            System.out.println("Sifreniz en az bir büyük harf icermelidir");
        } else if (!existLower) {
            System.out.println("Sifreniz en az bir kücük harf icermelidir");
        } else if (!existDigit) {
            System.out.println("Sifreniz en az bir rakam icermelidir");
        } else if (!existSymbol) {
            System.out.println("Sifreniz en az bir sembol icermelidir");
        }
        isValid = !space && lenghtGraterThan6 && existUpper && existLower && existDigit && existSymbol;

        if (!isValid) {
            System.out.println("Gecersiz sifre, tekrar deneyiniz.");
        }

        return isValid;
    }
}
