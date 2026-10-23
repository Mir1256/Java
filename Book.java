package Java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Book {
    private final String title;
    private final Author[] authors;

    public Book(String title, Author... authors) {
        this.title = (title == null || title.isBlank()) ? "Без названия" : title;

        if (authors == null || authors.length == 0) {
            this.authors = new Author[]{Author.UNKNOWN_AUTHOR};
        } else {
            this.authors = authors;
        }

        for (Author author : this.authors) {
            if (author != null) {
                author.addBook(this);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        String authorsStr;

        if (authors.length == 1) {
            authorsStr = authors[0].toString();
        } else {
            authorsStr = Arrays.stream(authors)
                    .map(Author::toString)
                    .collect(Collectors.joining(", "));
        }

        return "Книга автора(ов) [" + authorsStr + "]: \"" + title + "\"";
    }
}