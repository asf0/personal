import java.io.*;
import java.util.List;

public class LibrarySerializer {

    public void saveLibrary(List<Book> books, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> loadLibrary(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return null;
        }

        if (file.length() == 0) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                @SuppressWarnings("unchecked")
                List<Book> books = (List<Book>) obj;
                return books;
            }
            return null;
        } catch (EOFException e) {
            System.err.println("The file is empty or corrupted: " + fileName);
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading library: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}