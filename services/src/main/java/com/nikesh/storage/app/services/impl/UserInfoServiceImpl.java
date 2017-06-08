package com.nikesh.storage.app.services.impl;

import com.nikesh.storage.app.entities.UserInfo;
import com.nikesh.storage.app.repositories.UserInfoRepository;
import com.nikesh.storage.app.services.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Nikesh Maharjan
 *         nikeshmhr@gmail.com
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    // todo validation needed, if userInfo has id then throw exception as invalid entity to persist.
    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public UserInfo updateUserInfo(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public UserInfo findUserByUserId(String userId) {
        return userInfoRepository.findUserByUserId(userId);
    }
}
