package org.myhnuhai.repository.repo;

import org.myhnuhai.domain.User;

/**
 * Created by Administrator on 11-3-28.
 */
public interface IUserRepository {

    public User findUserByUserName(String uname);
}
