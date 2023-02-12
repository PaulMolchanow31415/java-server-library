package my.server.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import my.server.entity.BookEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class BookEntityResponse extends BaseResponse {
    private Iterable<BookEntity> data;

    public BookEntityResponse(Iterable<BookEntity> data) {
        super(true, "Данные о книге");
        this.data = data;
    }
}
