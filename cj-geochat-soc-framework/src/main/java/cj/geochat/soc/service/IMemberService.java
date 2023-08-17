package cj.geochat.soc.service;

import cj.geochat.soc.entity.Member;

import java.util.List;

public interface IMemberService {
    String addMember(String channel, String member);

    void removeMember(String channel, String member);

    Member getMember(String id);

    void updateOnline(String member, boolean online);
    List<Member> listMemberByChannel(String channel, int limit, int offset);

    List<Member> listMemberByChannel(String channel, boolean online, int limit, int offset);

    List<String> listChannelByMember(String member, int limit, int offset);
}
