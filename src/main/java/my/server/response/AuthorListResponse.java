package my.server.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import my.server.entity.AuthorEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuthorListResponse extends BaseResponse {
    private Iterable<AuthorEntity> data;

    public AuthorListResponse(Iterable<AuthorEntity> data) {
        super(true, "Список авторов");
        this.data = data;
    }
}
