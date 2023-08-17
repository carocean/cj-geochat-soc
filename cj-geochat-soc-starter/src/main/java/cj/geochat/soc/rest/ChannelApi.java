package cj.geochat.soc.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.soc.api.IChannelApi;
import cj.geochat.soc.entity.Channel;
import cj.geochat.soc.service.IChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channel")
@Tag(description = "频道管理", name = "频道管理")
@Slf4j
public class ChannelApi implements IChannelApi {
    @Autowired
    IChannelService channelService;

    @GetMapping(path = "/createChannel")
    @Operation(summary = "创建频道")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createChannel(String name, String type, @RequestParam(required = false) String note) {
        Channel channel = new Channel();
        channel.setName(name);
        channel.setNote(note);
        channel.setType(type);
        return channelService.addChannel(channel);
    }

    @GetMapping(path = "/removeChannel")
    @Operation(summary = "移除频道")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeChannel(String id) {
        channelService.removeChannel(id);
    }

    @GetMapping(path = "/updateChannelName")
    @Operation(summary = "更新频道名")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateChannelName(String id, String name) {
        channelService.updateChannelName(id, name);
    }

    @GetMapping(path = "/getChannel")
    @Operation(summary = "获取频道")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public Channel getChannel(String id) {
        return channelService.getChannel(id);
    }

    @GetMapping(path = "/listChannel")
    @Operation(summary = "分页列出频道")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Channel> listChannel(int limit, int offset) {
        return channelService.listChannel(limit, offset);
    }

    @GetMapping(path = "/listChannelByType")
    @Operation(summary = "分页列出指定类型的频道")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Channel> listChannelByType(String type, int limit, int offset) {
        return channelService.listChannelByType(type, limit, offset);
    }
}
