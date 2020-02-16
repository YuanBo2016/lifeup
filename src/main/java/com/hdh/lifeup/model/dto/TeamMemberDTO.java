package com.hdh.lifeup.model.dto;

import com.hdh.lifeup.base.BaseDTO;
import com.hdh.lifeup.model.domain.TeamMemberDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * TeamMemberDTO class<br/>
 *
 * @author hdonghong
 * @since 2018/09/11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class TeamMemberDTO extends BaseDTO<TeamMemberDO> {

    private static final long serialVersionUID = -7050659369013952349L;

    private Long memberId;

    private Long userId;

    private Long teamId;

    private String teamRole;

    private LocalDateTime createTime;

    /**
     * 当地时区
     */
    private String localTimeZone;

    /**
     * 当地时间
     */
    private LocalDateTime localCreateTime;
}
