package my.server.utils;

import my.server.entity.AuthorEntity;
import my.server.entity.BookEntity;
import my.server.entity.PublisherEntity;
import my.server.exception.ValidationException;

public class ValidationUtils {
    public static final String authorRegex = "^[A-Z|А-Я][a-z|а-я]{2,32}$";
    public static final String yearRegex = "^\\d{4}$";

    public static void validate(BookEntity book) throws ValidationException {
        StringBuilder errorsMessage = new StringBuilder();

        /* unique */
        String title = book.getTitle();
        String section = book.getSection();
        String origin = book.getOrigin();
        String year = book.getYearPub();

        /* author */
        Long authorId = book.getAuthor().getId();
        /* publisher */
        Long publisherId = book.getPublisher().getId();

        /* unique */
        if (title == null || title.isBlank() || title.length() < 3 || title.length() > 255) {
            errorsMessage.append("Не правильно введено заглавие\n");
        }
        if (section == null || section.isBlank() || section.length() < 3 || section.length() > 255) {
            errorsMessage.append("Не правильно введена секция\n");
        }
        if (origin == null || origin.isBlank() || origin.length() < 3 || origin.length() > 255) {
            errorsMessage.append("Не правильно введено происхождение книги\n");
        }
        if (year == null || year.isBlank() || !year.matches(yearRegex)) {
            errorsMessage.append("Не правильно введен год издания\n");
        }
        if (authorId == null) {
            errorsMessage.append("Поле автора не должно быть пустым\n");
        }
        if (publisherId == null) {
            errorsMessage.append("Поле издательства не должно быть пустым\n");
        }

        if (errorsMessage.length() > 0) {
            throw new ValidationException(errorsMessage.toString());
        }
    }

    public static void validate(AuthorEntity author) throws ValidationException {
        StringBuilder errorsMessage = new StringBuilder();

        if (author.getName() == null
                || author.getName().isBlank() || !author.getName().matches(authorRegex)) {
            errorsMessage.append("Не правильно введено имя автора\n");
        }
        if (author.getSurname() == null
                || author.getSurname().isBlank() || !author.getSurname().matches(authorRegex)) {
            errorsMessage.append("Не правильно введена фамилия автора\n");
        }
        if (author.getPatronymic() == null
                || author.getPatronymic().isBlank() || !author.getPatronymic().matches(authorRegex)) {
            errorsMessage.append("Не правильно введено отчество автора\n");
        }

        if (errorsMessage.length() > 0) {
            throw new ValidationException(errorsMessage.toString());
        }
    }

    public static void validate(PublisherEntity publisher) throws ValidationException {
        StringBuilder errorsMessage = new StringBuilder();

        if (publisher.getName() == null || publisher.getName().isBlank()
                || publisher.getName().length() < 3 || publisher.getName().length() > 255) {
            errorsMessage.append("Не правильно введено название издателя\n");
        }
        if (publisher.getCity() == null || publisher.getCity().isBlank()
                || publisher.getCity().length() < 3 || publisher.getCity().length() > 255) {
            errorsMessage.append("Не правильно введен город издателя\n");
        }

        if (errorsMessage.length() > 0) {
            throw new ValidationException(errorsMessage.toString());
        }
    }

    public static void validate(Object entity) throws ValidationException, ClassNotFoundException {
        if (entity instanceof BookEntity) {
            validate((BookEntity) entity);
        } else if (entity instanceof AuthorEntity) {
            validate((AuthorEntity) entity);
        } else if (entity instanceof PublisherEntity) {
            validate((PublisherEntity) entity);
        } else {
            throw new ClassNotFoundException("Валидатора обработчика для данного класса не существует "
                    + Object.class.getName() + " " + Object.class.getSuperclass());
        }
    }
}
