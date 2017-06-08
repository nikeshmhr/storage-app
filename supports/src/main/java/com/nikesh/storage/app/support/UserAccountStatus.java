package com.nikesh.storage.app.support;

/**
 * Enum that represents the account status of any particular user.
 *
 * @author Nikesh Maharjan
 *         nikeshmhr@gmail.com
 */
public enum UserAccountStatus {

    /**
     * Means user is active and can use service by logging in. This is the only state that qualifies any particular user
     * to use services.
     */
    ACTIVE,

    /**
     * Means user has deactivated his/her account and isn't using service.
     * If any user is in inactive state, he/she is not visible to any other users.
     * User with this status virtually doesn't exists until he/she logs in again.
     * The only possible way of getting out of this state is by logging in again.
     */
    INACTIVE,

    /**
     * Means user has registered (signed up) to use our services, but isn't authorized to use the system due to
     * incomplete registration process. This is the default state that new users will be in after registering until
     * verification process is complete, after which he/she will be ACTIVE state and will be eligible to use our services.
     */
    PENDING

}
