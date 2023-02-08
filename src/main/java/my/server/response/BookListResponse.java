package my.server.response;

import lombok.RequiredArgsConstructor;
import my.server.entity.BookEntity;
import lombok.Data;

@Data
@RequiredArgsConstructor
public class BookListResponse extends BaseResponse {
    private Iterable<BookEntity> data;

    public BookListResponse(Iterable<BookEntity> data) {
        super(true, "Список книг");
        this.data = data;
    }
}
