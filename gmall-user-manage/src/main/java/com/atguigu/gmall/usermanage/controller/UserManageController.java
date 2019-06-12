package com.atguigu.gmall.usermanage.controller;

import com.atguigu.gmall.usermanage.bean.UserInfo;
import com.atguigu.gmall.usermanage.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class UserManageController {
    @Autowired
    UserManagerService userManagerService;

    @RequestMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @RequestMapping("/users")
    public ResponseEntity<List<UserInfo>> getUserList(UserInfo userInfo) {
        List<UserInfo> userInfos = null;
        userInfos = userManagerService.getUserInfoList(userInfo);
        return ResponseEntity.ok(userInfos);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> insertUserInfo(UserInfo userInfo) {
        userManagerService.addUserInfo(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUserInfo(UserInfo userInfo) {
        userManagerService.updateUserInfo(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUserInfo(UserInfo userInfo) {
        userManagerService.delete(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<UserInfo> getUserInfo(int userId) {
        System.out.println(userId);
        UserInfo userInfoResult = null;
        userInfoResult = userManagerService.getUserInfo(userId);
        return ResponseEntity.ok(userInfoResult);
    }

}
