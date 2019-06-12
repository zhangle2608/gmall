package com.atguigu.gmall.usermanage.service.impl;

import com.atguigu.gmall.usermanage.bean.UserInfo;
import com.atguigu.gmall.usermanage.mapper.UserInfoMapper;
import com.atguigu.gmall.usermanage.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserManagerServiceImpl implements UserManagerService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> getUserInfoList(UserInfo userInfoQuery) {
        List<UserInfo> userInfos = null;
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName", "%" + userInfoQuery.getLoginName()+ "%");
        userInfos = userInfoMapper.selectByExample(example);
        return userInfos;
    }

    @Override
    public UserInfo getUserInfo(int userId) {
        UserInfo userInfo = null;
        userInfo = userInfoMapper.selectByPrimaryKey(userId);
        return userInfo;
    }

    @Override
    public void delete(UserInfo userInfoQuery) {

        userInfoMapper.deleteByPrimaryKey(userInfoQuery.getId());
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        userInfoMapper.insertSelective(userInfo);

    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("loginName","%" + userInfo.getLoginName() + "%");
        userInfo.setLoginName("tom");
        userInfoMapper.updateByExampleSelective(userInfo,example);

    }
}
