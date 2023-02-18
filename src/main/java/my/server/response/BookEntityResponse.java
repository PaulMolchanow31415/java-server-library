package my.server.response;

import lombok.Data;
import my.server.entity.BookEntity;

@Data
public class BookEntityResponse extends BaseResponse {
    private BookEntity data;

    public BookEntityResponse(boolean success, String message, BookEntity data) {
        super(success, message);
        this.data = data;
    }
}
