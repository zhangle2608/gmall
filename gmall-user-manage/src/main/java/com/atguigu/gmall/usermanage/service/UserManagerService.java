package com.atguigu.gmall.usermanage.service;

import com.atguigu.gmall.usermanage.bean.UserInfo;


import java.util.List;

public interface UserManagerService {
    public List<UserInfo> getUserInfoList(UserInfo userInfoQuery);

    public UserInfo getUserInfo(int userId);

    public void delete(UserInfo userInfoQuery);

    public void addUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);
}
