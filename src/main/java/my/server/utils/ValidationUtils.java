package my.server.utils;

import my.server.entity.BookEntity;
import my.server.exception.ValidationException;

public class ValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationException {
        StringBuilder errorsMessage = new StringBuilder();
        String title = book.getTitle();
        String authorName = book.getAuthor().getName();
        String authorSurname = book.getAuthor().getSurname();
        String publisherName = book.getPublisher().getName();
        String publisherCity = book.getPublisher().getCity();
        String kind = book.getKind();
        String year = book.getYearPub();

        if (title.isBlank() || title.matches("\\w{2,256}")) {
            errorsMessage.append("Не правильно введено заглавие").append("|");
        }
        if (authorName.isBlank() || !authorName.matches("[A-Z|А-Я][a-z|а-я]{2,64}")) {
            errorsMessage.append("Не правильно введено имя автора").append("|");
        }
        if (authorSurname.isBlank() || !authorSurname.matches("[A-Z|А-Я][a-z|а-я]{2,64}")) {
            errorsMessage.append("Не правильно введена фамилия автора").append("|");
        }
        if (publisherName.isBlank() || !publisherName.matches("\\w{2,64}")) {
            errorsMessage.append("Не правильно введен издатель").append("|");
        }
        if (publisherCity.isBlank() || !publisherCity.matches("\\w{2,256}")) {
            errorsMessage.append("Не правильно введен город издателя").append("|");
        }
        if (kind.isBlank() || !kind.matches("\\w{3,64}")) {
            errorsMessage.append("Не правильно введен жанр книги").append("|");
        }
        if (year.isBlank() || !year.matches("^\\d{4}$")) {
            errorsMessage.append("Не правильно введен год издания").append("|");
        }
        if (errorsMessage.length() > 0) {
            throw new ValidationException(errorsMessage.toString());
        }
    }
}
