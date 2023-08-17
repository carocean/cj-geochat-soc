package cj.geochat.soc.service;

import cj.geochat.soc.entity.Member;
import cj.geochat.soc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService implements IMemberService {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public String addMember(String channel, String member) {
        Member m = new Member();
        m.setChannel(channel);
        m.setMember(member);
        m.setTime(System.currentTimeMillis());
        m.setOnline(false);
        memberRepository.insert(m);
        return m.getId();
    }

    @Override
    public void removeMember(String channel, String member) {
        memberRepository.deleteByChannelAndMember(channel, member);
    }

    @Override
    public void updateOnline(String member, boolean online) {
        Query query = Query.query(Criteria.where("member").is(member));
        BasicUpdate updateDefinition = new BasicUpdate(String.format(
                """
                        {
                            "$set":{"online":%s}
                        }
                        """
                , online
        ));
        mongoTemplate.updateMulti(query, updateDefinition, Member.class);
    }

    @Override
    public Member getMember(String id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public List<Member> listMemberByChannel(String channel, int limit, int offset) {
        Page<Member> page = memberRepository.findByChannel(channel, PageRequest.of(offset, limit));
        return page.stream().toList();
    }

    @Override
    public List<Member> listMemberByChannel(String channel, boolean online, int limit, int offset) {
        Page<Member> page = memberRepository.findByChannelAndOnline(channel, online, PageRequest.of(offset, limit));
        return page.stream().toList();
    }

    @Override
    public List<String> listChannelByMember(String member, int limit, int offset) {
        Query query = Query.query(Criteria.where("member").is(member));
        query.skip(offset);
        query.limit(limit);
        List<String> list = mongoTemplate.findDistinct(query, "channel", Member.class, String.class);
        return list;
    }
}
