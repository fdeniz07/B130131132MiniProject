package MiniBookStore;

public class NoteBook extends Product{

    private String brand;
    private String sheet;

    public NoteBook() {
    }

    public NoteBook(int id, String name, String price, String stok, String brand, String sheet) {
        super(id, name, price, stok);
        this.brand = brand;
        this.sheet = sheet;
    }


}
