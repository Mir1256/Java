package Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Author {
    private final String name;
    private final List<Book> books = new ArrayList<>();
    public static final Author UNKNOWN_AUTHOR = new Author("Неизвестный автор");

    public Author(String name) {
        this.name = (name == null || name.isBlank()) ? "Неизвестный автор" : name;
    }

    public void addBook(Book book) {
        // Добавляем книгу, только если её еще нет в списке (защита от дубликатов)
        if (book != null && !books.contains(book)) {
            books.add(book);
        }
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public String getName() {
        return name;
    }

    public String getBooksAsString() {
        if (books.isEmpty()) return "Книг нет";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            sb.append(books.get(i).getTitle());
            if (i < books.size() - 1) {
                sb.append("; ");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}