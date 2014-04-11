package org.myhnuhai.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 11-3-28.
 */
public abstract class BaseRepository<T,ID extends Serializable> implements IBaseRepository<T,ID> {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void delete(T entity) {
        Assert.notNull(entity, "The given entity must not be null!");
       this.mongoOperations.remove(entity);
    }
    @Override
    public void delete(Iterable<T> entities) {
        Assert.notNull(entities, "The given Iterable of entities not be null!");

        for (T entity : entities) {
            delete(entity);
        }
    }

    protected MongoOperations getMongoOperations(){
        return  this.mongoOperations;
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> entities) {

        Assert.notNull(entities, "The given Iterable of entities not be null!");

        List<S> result = new ArrayList<S>();
        for (S entity : entities) {
            save(entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public <S extends T> S save(S entity) {
        Assert.notNull(entity, "Entity must not be null!");
        mongoOperations.save(entity);
        return entity;
    }

    protected Query getIdQuery(ID id){
        return Query.query(getIdCriteria(id));
    }

    protected Criteria getIdCriteria(ID id){
        return Criteria.where("id").is(id);
    }


}
