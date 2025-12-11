import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> pustakList;

    public Library() {
        this.pustakList = new ArrayList<>();
    }

    // Add a new book to the library
    public void addPustak(Book book) {
        pustakList.add(book);
    }

    // Borrow a book by ISBN
    public boolean udhaarKaro(String isbn) {
        Optional<Book> opt = pustakList.stream()
                .filter(b -> b.getIsbn().equals(isbn) && !b.isKyaUdhaar())
                .findFirst();
        if (opt.isPresent()) {
            opt.get().udhaarLeLo();
            return true;
        }
        return false;
    }

    // Return a book by ISBN
    public boolean udhaarWapasKare(String isbn) {
        Optional<Book> opt = pustakList.stream()
                .filter(b -> b.getIsbn().equals(isbn) && b.isKyaUdhaar())
                .findFirst();
        if (opt.isPresent()) {
            opt.get().udhaarWapasKare();
            return true;
        }
        return false;
    }

    // Generate a simple report of all books
    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library Report:\n");
        for (Book b : pustakList) {
            sb.append(b.toString()).append("\n");
        }
        return sb.toString();
    }
}
