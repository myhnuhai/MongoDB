package org.myhnuhai.service;

import org.myhnuhai.domain.User;

import java.util.List;

/**
 * Created by Administrator on 14-1-16.
 */
public interface IUserService {
    /**
     * 统计User对象
     * @return
     */
    public long countUser();

    /**
     * 根据User编号删除对象
     * @param id
     */
    public void deleteUserById(String id);

    /**
     * 删除User对象
     * @param user
     */
    public void delete(User user);

    /**
     * 根据id判断对象是否存在
     * @param id
     * @return
     */
    public boolean isExists(String id);

    /**
     * 查询所有User对象
     * @return
     */
    public List<User> findAllUser();

    /**
     * 根据User编号查询对象
     * @param id
     * @return
     */
    public User findUserByid(String id);

    /**
     * 根据UserName查询对象
     * @param uname
     * @return
     */
    public User findUserByUserName(String uname);
    /**
     * 保存User对象
     * @param user
     * @return
     */
    public User saveUser(User user);

    /**
     * 保存User列表
     * @param users
     * @return
     */
    public List<User> saveUsers(Iterable<User> users);
}
