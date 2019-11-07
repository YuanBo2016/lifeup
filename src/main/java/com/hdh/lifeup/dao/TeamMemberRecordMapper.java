package com.hdh.lifeup.dao;

import com.hdh.lifeup.base.SuperMapper;
import com.hdh.lifeup.model.domain.TeamMemberRecordDO;
import com.hdh.lifeup.model.dto.PageDTO;
import com.hdh.lifeup.model.dto.RecordDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;

/**
 * TeamMemberRecordMapper interface<br/>
 *
 * @author hdonghong
 * @since 2018/09/02
 */
public interface TeamMemberRecordMapper extends SuperMapper<TeamMemberRecordDO> {

    /**
     * 获取某个团队成员动态
     * @param teamId 团队
     * @param pageDTO 条件
     * @return 列表
     */
    @Select("select r.*, u.nickname, u.user_head from team_member_record r, user_info u " +
            "where r.user_id = u.user_id " +
            "and r.team_id = #{teamId} " +
            "order by r.create_time desc limit #{page.currentPage}, #{page.size} ")
    List<RecordDTO> getMemberRecords(@Param("teamId") Long teamId, @Param("page") PageDTO pageDTO);

    @Select("<script>" +
            "select r.*, u.nickname, u.user_head from team_member_record r, user_info u " +
            "where r.user_id = u.user_id " +
            "and u.user_id in " +
                "<foreach item='id' index='index' collection='userIds' open='(' separator=',' close=')'>" +
                "${id}" +
                "</foreach>" +
            "<if test='filter == 1'> and r.user_activity != '' </if>" +
            "order by r.create_time desc limit #{page.currentPage}, #{page.size} " +
            "</script>")
    List<RecordDTO> getRecordsByUserIds(@Param("userIds") Collection<Long> userIds, @Param("page") PageDTO pageDTO, @Param("filter") int filter);


    /** 获取所有人可见的动态数据 */
    @Select("<script>" +
            "select r.*, u.nickname, u.user_head from team_member_record r, user_info u " +
            "where r.user_id = u.user_id " +
            "and r.activity_icon != 1 " +
            "and r.activity_scope = 3 " +
            "<if test='filter == 1'> and r.user_activity != '' </if>" +
            "order by r.create_time desc limit #{page.currentPage}, #{page.size} " +
            "</script>")
    List<RecordDTO> getRecords(@Param("page") PageDTO pageDTO, @Param("filter") int filter);
}
