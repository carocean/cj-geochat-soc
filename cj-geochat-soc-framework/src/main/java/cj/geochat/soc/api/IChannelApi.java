package cj.geochat.soc.api;

import cj.geochat.soc.entity.Channel;

import java.util.List;

public interface IChannelApi {
    String createChannel(String name, String type, String note);

    void removeChannel(String id);

    void updateChannelName(String id, String name);

    Channel getChannel(String id);

    List<Channel> listChannel(int limit, int offset);

    List<Channel> listChannelByType(String type, int limit, int offset);
}
