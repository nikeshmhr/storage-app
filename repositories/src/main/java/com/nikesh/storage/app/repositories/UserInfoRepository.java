package com.nikesh.storage.app.repositories;

import com.nikesh.storage.app.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nikesh Maharjan
 *         nikeshmhr@gmail.com
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findUserByUserId(String userId);

}
