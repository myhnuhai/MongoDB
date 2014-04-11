package org.myhnuhai.repository.repo.impl;

import org.myhnuhai.domain.User;
import org.myhnuhai.repository.BaseRepository;
import org.myhnuhai.repository.repo.IUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 14-1-16.
 */
@Repository
public class UserRepository extends BaseRepository implements IUserRepository {

    @Override
    public long count() {
        return this.getMongoOperations().count(new Query(),User.class);
    }

    @Override
    public void delete(Serializable serializable) {

        this.getMongoOperations().remove(getIdQuery(serializable), User.class);
    }

    @Override
    public void deleteAll() {
        this.getMongoOperations().remove(new Query(),User.class);
    }

    @Override
    public boolean exists(Serializable serializable) {
        return this.getMongoOperations().exists(getIdQuery(serializable),User.class);
    }

    @Override
    public List findAll() {
        return this.getMongoOperations().find(new Query(),User.class);
    }

    @Override
    public Iterable  findAll(Iterable  iterable) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List findAll(Sort sort) {
        return null;
    }

    @Override
    public User findOne(Serializable serializable) {
        return this.getMongoOperations().findOne(getIdQuery(serializable),User.class);
    }

    @Override
    public User findUserByUserName(String uname) {

        List<User> list = this.getMongoOperations().find(Query.query(Criteria.where("username").is(uname)),User.class);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
