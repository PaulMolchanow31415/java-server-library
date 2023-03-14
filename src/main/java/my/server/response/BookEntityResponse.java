package my.server.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import my.server.entity.BookEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookEntityResponse extends BaseResponse {
    private BookEntity data;

    public BookEntityResponse(boolean success, String message, BookEntity data) {
        super(success, message);
        this.data = data;
    }
}
