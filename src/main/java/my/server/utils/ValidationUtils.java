package my.server.utils;

import my.server.entity.BookEntity;
import my.server.exception.ValidationException;

public class ValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationException {
        StringBuilder errorsMessage = new StringBuilder();
        String authorRegex = "\\w{2,64}";
        String yearRegex = "^\\d{4}$";
        String title = book.getTitle();
        String authorName = book.getAuthor().getName();
        String authorSurname = book.getAuthor().getSurname();
        String publisherName = book.getPublisher().getName();
        String publisherCity = book.getPublisher().getCity();
        String kind = book.getKind();
        String year = book.getYearPub();

        if (title == null || title.isBlank() || title.length() < 3 || title.length() > 255) {
            errorsMessage.append("Не правильно введено заглавие\n");
        }
        if (authorName == null || authorName.isBlank() || !authorName.matches(authorRegex)) {
            errorsMessage.append("Не правильно введено имя автора\n");
        }
        if (authorSurname == null || authorSurname.isBlank() || !authorSurname.matches(authorRegex)) {
            errorsMessage.append("Не правильно введена фамилия автора\n");
        }
        if (publisherName == null || publisherName.isBlank() || publisherName.length() < 3 || publisherName.length() > 255) {
            errorsMessage.append("Не правильно введено название издателя\n");
        }
        if (publisherCity == null || publisherCity.isBlank() || publisherCity.length() < 3 || publisherCity.length() > 255) {
            errorsMessage.append("Не правильно введен город издателя\n");
        }
        if (kind == null || kind.isBlank() || kind.length() < 3 || kind.length() > 255) {
            errorsMessage.append("Не правильно введен жанр книги\n");
        }
        if (year == null || year.isBlank() || !year.matches(yearRegex)) {
            errorsMessage.append("Не правильно введен год издания\n");
        }

        if (errorsMessage.length() > 0) {
            throw new ValidationException(errorsMessage.toString());
        }
    }
}
