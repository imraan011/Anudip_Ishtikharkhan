import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryApp {
    private Library library;
    private JFrame frame;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField isbnField;
    private JTextField isbnActionField;
    private JTextArea reportArea;

    public LibraryApp() {
        library = new Library();
        initUI();
    }

    private void initUI() {
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout(10, 10));

        // Panel for adding a book
        JPanel addPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        addPanel.setBorder(BorderFactory.createTitledBorder("Add Book"));
        titleField = new JTextField();
        authorField = new JTextField();
        isbnField = new JTextField();
        JButton addButton = new JButton("Add");
        addPanel.add(new JLabel("Title:"));
        addPanel.add(titleField);
        addPanel.add(new JLabel("Author:"));
        addPanel.add(authorField);
        addPanel.add(new JLabel("ISBN:"));
        addPanel.add(isbnField);
        addPanel.add(new JLabel());
        addPanel.add(addButton);

        // Panel for borrow/return actions
        JPanel actionPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        actionPanel.setBorder(BorderFactory.createTitledBorder("Borrow / Return"));
        isbnActionField = new JTextField();
        JButton borrowButton = new JButton("Borrow");
        JButton returnButton = new JButton("Return");
        actionPanel.add(new JLabel("ISBN:"));
        actionPanel.add(isbnActionField);
        actionPanel.add(borrowButton);
        actionPanel.add(returnButton);

        // Report area
        JPanel reportPanel = new JPanel(new BorderLayout());
        reportPanel.setBorder(BorderFactory.createTitledBorder("Report"));
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(reportArea);
        JButton reportButton = new JButton("Generate Report");
        reportPanel.add(reportButton, BorderLayout.NORTH);
        reportPanel.add(scroll, BorderLayout.CENTER);

        // Add panels to frame
        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        topPanel.add(addPanel);
        topPanel.add(actionPanel);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(reportPanel, BorderLayout.CENTER);

        // Action listeners
        addButton.addActionListener(e -> {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            String isbn = isbnField.getText().trim();
            if (!title.isEmpty() && !author.isEmpty() && !isbn.isEmpty()) {
                library.addPustak(new Book(title, author, isbn));
                JOptionPane.showMessageDialog(frame, "Book added.");
                titleField.setText("");
                authorField.setText("");
                isbnField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
            }
        });

        borrowButton.addActionListener(e -> {
            String isbn = isbnActionField.getText().trim();
            if (!isbn.isEmpty()) {
                boolean success = library.udhaarKaro(isbn);
                JOptionPane.showMessageDialog(frame, success ? "Book borrowed." : "Book not available.");
            }
        });

        returnButton.addActionListener(e -> {
            String isbn = isbnActionField.getText().trim();
            if (!isbn.isEmpty()) {
                boolean success = library.udhaarWapasKare(isbn);
                JOptionPane.showMessageDialog(frame, success ? "Book returned." : "Book not found or not borrowed.");
            }
        });

        reportButton.addActionListener(e -> {
            reportArea.setText(library.generateReport());
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Run on Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(LibraryApp::new);
    }
}
