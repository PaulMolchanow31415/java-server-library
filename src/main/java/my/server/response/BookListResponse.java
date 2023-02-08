package my.server.response;

import my.server.entity.BookEntity;
import lombok.Data;

import java.util.ArrayList;

@Data
public class BookListResponse extends BaseResponse {
    private Iterable<BookEntity> books = new ArrayList<>();
    private BookEntity book;

    public BookListResponse(boolean success, String message, BookEntity book) {
        super(success, message);
        this.book = book;
    }

    public BookListResponse(BookEntity book) {
        super(true, "Book data");
        this.book = book;
    }

    public BookListResponse(Iterable<BookEntity> bookEntities) {
        super(true, "Books data");
        this.books = bookEntities;
    }
}
