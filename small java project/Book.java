public class Book {
    private String kitabTitle;
    private String lekhak;
    private String isbn;
    private boolean kyaUdhaar;

    public Book(String kitabTitle, String lekhak, String isbn) {
        this.kitabTitle = kitabTitle;
        this.lekhak = lekhak;
        this.isbn = isbn;
        this.kyaUdhaar = false;
    }

    public String getKitabTitle() { return kitabTitle; }
    public String getLekhak() { return lekhak; }
    public String getIsbn() { return isbn; }
    public boolean isKyaUdhaar() { return kyaUdhaar; }

    public void udhaarLeLo() { this.kyaUdhaar = true; }
    public void udhaarWapasKare() { this.kyaUdhaar = false; }

    @Override
    public String toString() {
        return String.format("%s by %s (ISBN: %s) %s", kitabTitle, lekhak, isbn, (kyaUdhaar ? "[Borrowed]" : "[Available]"));
    }
}
