package cj.geochat.soc.service;

import cj.geochat.soc.entity.Channel;
import cj.geochat.soc.repository.ChannelRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService implements IChannelService {
    @Resource
    ChannelRepository channelRepository;

    @Override
    public String addChannel(Channel channel) {
        channelRepository.save(channel);
        return channel.getId();
    }

    @Override
    public void removeChannel(String id) {
        channelRepository.deleteById(id);
    }

    @Override
    public void updateChannelName(String id, String name) {
        Channel channel = channelRepository.findById(id).orElse(null);
        if (channel == null) {
            return;
        }
        channel.setName(name);
        channelRepository.save(channel);
    }

    @Override
    public Channel getChannel(String id) {
        return channelRepository.findById(id).orElse(null);
    }

    @Override
    public List<Channel> listChannel(int limit, int offset) {
        Page<Channel> page = channelRepository.findAllBy(PageRequest.of(offset, limit));
        return page.stream().toList();
    }

    @Override
    public List<Channel> listChannelByType(String type, int limit, int offset) {
        Page<Channel> page = channelRepository.findByType(type, PageRequest.of(offset, limit));
        return page.stream().toList();
    }
}
