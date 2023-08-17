package cj.geochat.soc.doc;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Member {
    @Indexed
    String member;
    @Field
    @Indexed
    String channel;
    @Field
    @Indexed
    boolean online;
    @Field
    @Indexed
    long time;
}
