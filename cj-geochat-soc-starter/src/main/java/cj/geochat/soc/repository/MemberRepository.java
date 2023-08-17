package cj.geochat.soc.repository;

import cj.geochat.soc.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository  extends MongoRepository<Member,String> {
    Page<Member> findByChannel(String channel, Pageable pageable);
    Page<Member> findByChannelAndOnline(String channel,boolean online, Pageable pageable);

    void deleteByChannelAndMember(String channel, String member);
}
