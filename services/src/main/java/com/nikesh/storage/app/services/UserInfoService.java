package com.nikesh.storage.app.services;

import com.nikesh.storage.app.entities.UserInfo;

/**
 * Service that provides basic crud operation on {@link com.nikesh.storage.app.entities.UserInfo}
 *
 * @author Nikesh Maharjan
 *         nikeshmhr@gmail.com
 */
public interface UserInfoService {

    /**
     * Saves the given {@link UserInfo} entity.
     *
     * @param userInfo
     * @return the saved {@link UserInfo} entity
     */
    UserInfo saveUserInfo(UserInfo userInfo);

    /**
     * Updates the existing record with new {@link UserInfo}.
     *
     * @param userInfo
     * @return the updated {@link UserInfo} entity
     */
    UserInfo updateUserInfo(UserInfo userInfo);

    /**
     * Returns reference to the {@link UserInfo} entity for given {@link UserInfo#userId}
     *
     * @param userId must not be null or empty
     * @return a reference to the {@link UserInfo} entity with given {@link UserInfo#userId}
     */
    UserInfo findUserByUserId(String userId);

}
