package cj.geochat.soc.doc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("channel")
@Data
public class Channel {
    @Id
    @Indexed
    String id;
    @Field
    String name;
    @Field
    @Indexed
    String type;
    @Field
    String note;
}
