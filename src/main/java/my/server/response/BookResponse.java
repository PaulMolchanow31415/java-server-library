package my.server.response;

import my.server.entity.BookEntity;
import lombok.Data;

@Data
public class BookResponse extends BaseResponse{
    private BookEntity book;

    public BookResponse(boolean success, String message, BookEntity book) {
        super(success, message);
        this.book = book;
    }

    public BookResponse(BookEntity book) {
        super(true, "Book data");
        this.book = book;
    }
}
