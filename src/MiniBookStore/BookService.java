package MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a- ProductService implement et ve metotlari Book icin doldur
public class BookService implements ProductService {

    //3-booklari saklamak icin list olustur

    List<Book> bookList = new ArrayList<>();

    //4-baslangicta kitaplar olsun

    public BookService() {

        Book book1 = new Book(1, "Vadideki Zambak", "150 Lira", 15, "Balzac", "Penguin");
        Book book2 = new Book(2, "Suc ve Ceza", "150 Lira", 25, "Dostoyevski", "Penguin");
        Book book3 = new Book(3, "Sefiller", "125 Lira", 10, "Victor Hugo", "Dream");
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }

    //5-bookla yapabileceği işlemlerin menüsü
    @Override
    public void processMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("1-Kitaplari Listele");
            System.out.println("2-Kitap Ekle");
            System.out.println("3-Kitap Sil");
            System.out.println("4-Yayinevine göre filtrele");
            System.out.println("0-Cikis");
            System.out.println("Seciminiz:");

            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz...");
                    break;
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    System.out.println("Yayınevi: ");
                    String pub = scanner.next();
                    filterProduct(pub);
                    break;
                default:
                    System.out.println("Hatali giris!");
                    break;
            }
        }
    }

    //6-bookları formatla yazdır
    @Override
    public void listProduct() {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("%-2s | %-15s | %-15s | %-10s | %-7s | %-5s \n", "ID", "Kitap Adı", "Yazar Adı", "Yayınevi", "Birim Fiyat", "Stok");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Book book : this.bookList) {
            System.out.printf("%-2s | %-15s | %-15s | %-10s | %-7s | %-5s \n",
                    book.getId(), book.getName(), book.getAuthorName(), book.getPublisher(), book.getPrice(), book.getStok());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    //7-kullanıcıdan alınan bilgilerle book oluştur, listeye ekle
    @Override
    public void addProduct() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Kitap adı: ");
        String bookName = inp.nextLine();
        System.out.println("Yazar adı :");
        String authorName = inp.nextLine();
        System.out.println("Yayınevi: ");
        String pub = inp.nextLine();
        System.out.println("Birim Fiyat");
        String unitPrice = inp.nextLine();
        System.out.println("Stok :");
        int stock = inp.nextInt();
        Book newbook = new Book(this.bookList.get(bookList.size() - 1).getId() + 1, bookName, unitPrice, stock, authorName, pub);
        this.bookList.add(newbook);
        listProduct();
    }

    //8-kullanicidan id al, id ile book bul, listeden kaldir
    @Override
    public void removeProduct() {
        Scanner scan = new Scanner(System.in);

        boolean isExist = true;
        System.out.println("Kitap id:");
        int id = scan.nextInt();

        for (Book book : this.bookList) {
            if (book.getId() == id) {
                isExist = true;
                this.bookList.remove(book);
                System.out.println("Kitap silindi");
            } else {
                isExist = false;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Kitap bulunamadi");
        }

    }

    //9-Tüm listedeki kitaplarin yayinevine bak, filter ile ayni ise yazdir.
    @Override
    public void filterProduct(String filter) {
        for (Book book : this.bookList) {
            if (book.getPublisher().equalsIgnoreCase(filter)) {//Penguin-penguin
                System.out.printf("%-2s | %-15s | %-15s | %-10s | %-7s | %-5s \n",
                        book.getId(), book.getName(), book.getAuthorName(), book.getPublisher(), book.getPrice(), book.getStok());
            }
        }
    }
}
