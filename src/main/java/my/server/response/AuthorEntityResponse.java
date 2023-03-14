package my.server.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import my.server.entity.AuthorEntity;
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthorEntityResponse extends BaseResponse {
    private AuthorEntity data;

    public AuthorEntityResponse(boolean success, String message, AuthorEntity data) {
        super(success, message);
        this.data = data;
    }
}

