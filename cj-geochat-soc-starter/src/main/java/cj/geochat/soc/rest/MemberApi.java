package cj.geochat.soc.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.soc.api.IMemberApi;
import cj.geochat.soc.entity.Member;
import cj.geochat.soc.service.IMemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
@Tag(description = "频道成员管理", name = "频道成员管理")
@Slf4j
public class MemberApi implements IMemberApi {
    @Autowired
    IMemberService memberService;

    @GetMapping(path = "/addMember")
    @Operation(summary = "添加成员到频道")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String addMember(String channel, String member) {
       return memberService.addMember(channel, member);
    }

    @GetMapping(path = "/removeMember")
    @Operation(summary = "从频道移除成员")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeMember(String channel, String member) {
        memberService.removeMember(channel, member);
    }

    @GetMapping(path = "/getMember")
    @Operation(summary = "获取成员")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public Member getMember(String id) {
        return memberService.getMember(id);
    }

    @GetMapping(path = "/updateOnline")
    @Operation(summary = "更新成员在线状态")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateOnline(String member, boolean online) {
        memberService.updateOnline(member, online);
    }

    @GetMapping(path = "/listMemberByChannel")
    @Operation(summary = "分页列出指定频道的成员")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Member> listMemberByChannel(String channel, int limit, int offset) {
        return memberService.listMemberByChannel(channel, limit, offset);
    }

    @GetMapping(path = "/listMemberByChannelAndOnline")
    @Operation(summary = "分页列出指定频道和在线状态的成员")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Member> listMemberByChannelAndOnline(String channel, boolean online, int limit, int offset) {
        return memberService.listMemberByChannel(channel, online, limit, offset);
    }

    @GetMapping(path = "/listChannelByMember")
    @Operation(summary = "分页列出成员所在的所有频道")
    @ApiResult
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listChannelByMember(String member, int limit, int offset) {
        return memberService.listChannelByMember(member, limit, offset);
    }
}
