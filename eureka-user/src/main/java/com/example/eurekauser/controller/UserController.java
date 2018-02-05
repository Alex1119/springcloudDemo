package com.example.eurekauser.controller;

import com.example.core.model.UserInfo;
import com.example.core.service.UserInfoRepository;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserInfoRepository mUserInfoRepository;

    @GetMapping(value = "/addUser")
    public int addUser(){
        UserInfo mUserInfo = new UserInfo();
        mUserInfo.setAccountId(UUID.randomUUID().toString().replaceAll("-", ""));
        mUserInfo.setDepartCode("departCode");
        mUserInfo.setDepartName("departName");
        mUserInfo.setOpenId("openId");
        mUserInfo.setFromType(1);
        return mUserInfoRepository.Insert(mUserInfo);
    }

    @GetMapping(value = "/list")
    public PageInfo<UserInfo> list(@RequestParam("pageSize") int pageSize,
                                   @RequestParam("pageNum") int pageNum,
                                   @RequestParam("openId") String openId,
                                   @RequestParam("departCode") String departCode){
        return mUserInfoRepository.ListByPager(pageNum, pageSize, openId, departCode);
    }

}
