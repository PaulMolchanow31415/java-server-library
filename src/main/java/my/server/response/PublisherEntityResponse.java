package my.server.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import my.server.entity.PublisherEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class PublisherEntityResponse extends BaseResponse {
    private PublisherEntity data;

    public PublisherEntityResponse(boolean success, String message, PublisherEntity data) {
        super(success, message);
        this.data = data;
    }
}

