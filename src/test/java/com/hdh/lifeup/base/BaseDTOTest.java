package com.hdh.lifeup.base;

import com.hdh.lifeup.domain.UserInfoDO;
import com.hdh.lifeup.dto.UserInfoDTO;
import org.junit.Test;

public class BaseDTOTest {

    @Test
    public void convertToDo() throws Exception {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserId(1L)
                .setNickName("bbb")
                .setUserPhone("15522112921")
                .setUserAddress("广东省广州市天河区龙口东路创逸大厦11202")
                .setUserPassword("a");
        UserInfoDO userInfoDO = userInfoDTO.convertToDo(UserInfoDO.class);
        System.out.println(userInfoDO);
    }


    @Test
    public void convertForDto() throws Exception {
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setNickName("nick")
                .setUserPhone("15522112951")
                .setUserAddress("2018-08-18 08:44:12 广东省广州市天河区龙口东路创逸大厦11202")
                .setUserPassword("a");
        UserInfoDTO userInfoDTO = BaseDTO.convertForDto(userInfoDO, UserInfoDTO.class);
        System.out.println(userInfoDTO);
    }


    @Test
    public void convertForDto1() throws Exception {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setNickName("nick")
                .setUserPhone("15522112951")
                .setUserAddress("2018-08-18 08:44:12 广东省广州市天河区龙口东路创逸大厦11202")
                .setUserPassword("a");
        userInfoDTO = userInfoDTO.convertForDto(userInfoDO);
        System.out.println(userInfoDTO);
    }

}