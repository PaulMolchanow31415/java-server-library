package my.server.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import my.server.entity.AuthorEntity;
import my.server.entity.PublisherEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class PublisherListResponse extends BaseResponse {
    private Iterable<PublisherEntity> data;

    public PublisherListResponse(Iterable<PublisherEntity> data) {
        super(true, "Список издательств");
        this.data = data;
    }
}
