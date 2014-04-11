package org.myhnuhai.service.impl;

import org.myhnuhai.domain.User;
import org.myhnuhai.repository.repo.impl.UserRepository;
import org.myhnuhai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 14-1-16.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;


    /**
     * 统计User对象
     *
     * @return
     */
    @Override
    public long countUser() {
        return userRepository.count();
    }

    /**
     * 根据User编号删除对象
     *
     * @param id
     */
    @Override
    public void deleteUserById(String id) {
        userRepository.delete(id);
    }

    /**
     * 删除User对象
     *
     * @param user
     */
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    /**
     * 根据id判断对象是否存在
     *
     * @param id
     * @return
     */
    @Override
    public boolean isExists(String id) {
        return userRepository.exists(id);
    }

    /**
     * 查询所有User对象
     *
     * @return
     */
    @Override
    public List<User> findAllUser() {

        return userRepository.findAll();
    }

    /**
     * 根据User编号查询对象
     *
     * @param id
     * @return
     */
    @Override
    public User findUserByid(String id) {
        return userRepository.findOne(id);
    }

    /**
     * 根据UserName查询对象
     *
     * @param uname
     * @return
     */
    @Override
    public User findUserByUserName(String uname) {
        return userRepository.findUserByUserName(uname);
    }

    /**
     * 保存User对象
     *
     * @param user
     * @return
     */
    @Override
    public User saveUser(User user) {
        return (User)userRepository.save(user);
    }

    /**
     * 保存User列表
     *
     * @param users
     * @return
     */
    @Override
    public List<User> saveUsers(Iterable<User> users) {
        return userRepository.save(users);
    }
}
