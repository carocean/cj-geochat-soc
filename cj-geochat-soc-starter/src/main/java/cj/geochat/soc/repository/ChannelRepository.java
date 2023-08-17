package cj.geochat.soc.repository;

import cj.geochat.soc.entity.Channel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChannelRepository extends MongoRepository<Channel,String> {
    Page<Channel> findAllBy(Pageable pageable);

    Page<Channel> findByType(String type, Pageable pageable);

}
