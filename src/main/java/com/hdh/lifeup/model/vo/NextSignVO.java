package com.hdh.lifeup.model.vo;

import com.hdh.lifeup.model.dto.TeamSubTaskDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * NextSignVO class<br/>
 *
 * @author hdonghong
 * @since 2018/09/03
 */
@ApiModel("即将要签到的信息VO类")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class NextSignVO implements Serializable {

    private static final long serialVersionUID = -2991679595328300361L;

    private Long teamId;

    private Long teamRecordId;

    @ApiModelProperty(value = "奖励属性")
    private List<String> rewardAttrs;

    @ApiModelProperty(value = "奖励经验")
    private Integer rewardExp;

    private Integer teamFreq;

    @ApiModelProperty(value = "团队标题，也是事项标题")
    private String teamTitle;

    @ApiModelProperty("下一次开始签到的时间")
    private LocalDateTime nextStartTime;

    @ApiModelProperty("下一次结束签到的时间")
    private LocalDateTime nextEndTime;

    @ApiModelProperty(value = "金币 取值区间[0, 99]")
    private Integer coin = 0;

    /** 金币随机量 取值区间[0, 99]*/
    @ApiModelProperty(value = "金币 取值区间[0, 99]")
    private Integer coinVariable = 0;

    /**
     * 子任务列表
     */
    @ApiModelProperty(value = "子任务列表")
    private List<TeamSubTaskDTO> subTaskList;
}
