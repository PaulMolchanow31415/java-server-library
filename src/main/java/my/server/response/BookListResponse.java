package my.server.response;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import my.server.entity.BookEntity;
import lombok.Data;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookListResponse extends BaseResponse {
    private Iterable<BookEntity> data;

    public BookListResponse(Iterable<BookEntity> data) {
        super(true, "Список книг");
        this.data = data;
    }
}
