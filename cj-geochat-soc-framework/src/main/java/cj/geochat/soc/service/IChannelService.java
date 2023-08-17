package cj.geochat.soc.service;

import cj.geochat.soc.entity.Channel;

import java.util.List;

public interface IChannelService {
    String addChannel(Channel channel);

    void removeChannel(String id);

    void updateChannelName(String id, String name);

    Channel getChannel(String id);
    List<Channel> listChannel(int limit, int offset);

    List<Channel> listChannelByType(String type,int limit, int offset);
}
