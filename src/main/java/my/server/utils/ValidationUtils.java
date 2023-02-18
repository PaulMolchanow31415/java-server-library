package my.server.utils;

import my.server.entity.BookEntity;
import my.server.exception.ValidationException;

public class ValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationException {
        StringBuilder errorsMessage = new StringBuilder();
        String title = book.getTitle();
        String author = book.getAuthor();
        String publisher = book.getPublisher();
        String kind = book.getKind();
        String year = book.getYearPub();

        if (title == null || title.isBlank() || title.length() < 3 || title.length() > 255) {
            errorsMessage.append("Не правильно введено заглавие\n");
        }
        if (author == null || author.isBlank() || !author.matches("\\w{2,64}\\s\\w{2,64}")) {
            errorsMessage.append("Не правильно введено название автора\n");
        }
        if (publisher == null || publisher.isBlank() || publisher.length() < 3 || publisher.length() > 255) {
            errorsMessage.append("Не правильно введен издатель\n");
        }
        if (kind == null || kind.isBlank() || kind.length() < 3 || kind.length() > 255) {
            errorsMessage.append("Не правильно введен жанр книги\n");
        }
        if (year == null || year.isBlank() || !year.matches("^\\d{4}$")) {
            errorsMessage.append("Не правильно введен год издания\n");
        }

        if (errorsMessage.length() > 0) {
            throw new ValidationException(errorsMessage.toString());
        }
    }
}
