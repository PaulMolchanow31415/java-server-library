package my.server.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import my.server.entity.BookEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookListResponse extends BaseResponse {
    private Iterable<BookEntity> data;

    public BookListResponse(Iterable<BookEntity> data) {
        super(true, "Список книг");
        this.data = data;
    }
}
