package cj.geochat.soc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Member {
    @Id
    @Indexed
    String id;
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
