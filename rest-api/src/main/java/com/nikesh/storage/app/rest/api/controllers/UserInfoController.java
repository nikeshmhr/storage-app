package com.nikesh.storage.app.rest.api.controllers;

import com.nikesh.storage.app.entities.UserInfo;
import com.nikesh.storage.app.rest.api.constants.ResourceConstants;
import com.nikesh.storage.app.services.UserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class with endpoints related to application users.
 *
 * @author Nikesh Maharjan
 *         nikeshmhr@gmail.com
 */
@RestController
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping(ResourceConstants.UserResource.BASE)
    public ResponseEntity<UserInfo> createNewUser(@RequestBody UserInfo userInfo) {
        UserInfo savedUserInfo = userInfoService.saveUserInfo(userInfo);

        return ResponseEntity.ok().body(savedUserInfo);
    }

}
