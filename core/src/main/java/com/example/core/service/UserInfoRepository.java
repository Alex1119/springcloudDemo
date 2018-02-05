package com.example.core.service;

import com.example.core.mapper.UserInfoMapper;
import com.example.core.model.UserInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoRepository {

    @Autowired
    UserInfoMapper mUserInfoMapper;

    public PageInfo<UserInfo> ListByPager(int pageNum, int pageSize, String openId, String departCode){
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> userInfos = mUserInfoMapper.userList(openId, departCode);
        return new PageInfo<>(userInfos);
    }

    public int Insert(UserInfo userInfo){
        return mUserInfoMapper.insert(userInfo);
    }

}
