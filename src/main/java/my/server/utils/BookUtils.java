package my.server.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import my.server.entity.BookEntity;

@Data
@AllArgsConstructor
public class BookUtils {
    private BookEntity book;

    public static boolean isCorrectDate(String date) {
        return date.matches("^\\d{4}$");
    }

    public static boolean isCorrectAuthor(String name) {
        return name.matches("\\w{3,31}");
    }

    public static boolean isCorrectTitle(String title) {
        return title != null && title.length() != 0;
    }

    public static boolean isCorrectKind(String kind) {
        return kind != null && kind.length() != 0;
    }

    public static boolean isCorrectPublisher(String publisher) {
        return publisher != null && publisher.length() != 0;
    }

    public static boolean fullValidate(BookEntity book) {
        return !isCorrectAuthor(book.getAuthor())
                || !isCorrectTitle(book.getTitle())
                || !isCorrectDate(book.getYearPub())
                || !isCorrectPublisher(book.getPublisher())
                || !isCorrectKind(book.getKind());
    }

    public boolean fullValidate() {
        return isCorrectAuthor(book.getAuthor())
                && isCorrectTitle(book.getTitle())
                && isCorrectDate(book.getYearPub())
                && isCorrectPublisher(book.getPublisher())
                && isCorrectKind(book.getKind());
    }
}
