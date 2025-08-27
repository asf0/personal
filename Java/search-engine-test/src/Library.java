
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooks(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0].trim();
                String author = parts[1].trim();
                String yearString = parts[2].trim();

                int year = Integer.parseInt(yearString);

                Book book = new Book(title, author, year);
                books.add(book);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByKeyword(String keyword) {
        keyword = keyword.toLowerCase();
        for (Book book : books) {
            String title = book.getTitle().toLowerCase();
            String author = book.getAuthor().toLowerCase();
            String year = String.valueOf(book.getPublicationYear()).toLowerCase();

            if (title.contains(keyword) || author.contains(keyword) || year.contains(keyword)){
                return book;
            }


        }
        return null;
    }


    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}
