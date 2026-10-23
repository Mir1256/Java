package Java;

public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Айзек Азимов");
        Author author2 = new Author("Роберт Шекли");

        // Книга с двумя авторами
        Book book1 = new Book("Основание", author1, author2);

        // Книга с одним автором
        Book book2 = new Book("Конец вечности", author1);

        // Книга без авторов (автоматически подставится Неизвестный автор)
        Book book3 = new Book("Загадочная рукопись");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println("\n--- Библиотека Азимова ---");
        System.out.println(author1.getBooksAsString());

        System.out.println("\n--- Библиотека Шекли ---");
        System.out.println(author2.getBooksAsString());
    }
}