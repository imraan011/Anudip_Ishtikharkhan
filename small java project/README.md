# Library Management System

A simple Java application for managing a library using a Swing-based graphical user interface (GUI). This project allows users to add books, borrow and return books by ISBN, and generate reports on the library's collection.

## Features

- **Add Books**: Enter book details including title, author, and ISBN to add new books to the library.
- **Borrow Books**: Borrow available books by entering their ISBN.
- **Return Books**: Return borrowed books by entering their ISBN.
- **Generate Reports**: View a list of all books in the library, including their availability status.

## Requirements

- Java Development Kit (JDK) 8 or higher
- A Java runtime environment to run the application

## How to Run

1. Ensure you have Java installed on your system.
2. Compile the Java files:
   ```
   javac *.java
   ```
3. Run the application:
   ```
   java LibraryApp
   ```
4. The GUI window will open, allowing you to interact with the library management system.

## Project Structure

- `Book.java`: Represents a book with attributes like title, author, ISBN, and borrowing status.
- `Library.java`: Manages the collection of books, including adding, borrowing, returning, and reporting.
- `LibraryApp.java`: The main application class that provides the Swing GUI for user interaction.

## Usage

- Use the "Add Book" section to input book details and add them to the library.
- Use the "Borrow / Return" section to borrow or return books by ISBN.
- Click "Generate Report" to view the current status of all books in the library.
