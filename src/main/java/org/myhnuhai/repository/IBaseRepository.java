package org.myhnuhai.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 11-3-28.
 */
public interface IBaseRepository<T,ID extends Serializable> {

    public long count();

    public void delete(T entity) ;

    public void delete(ID id) ;

    public void delete(Iterable<T> entities);

    public  void deleteAll();

    public boolean exists(ID id);

    public List<T> findAll();

    public Iterable<T> findAll(Iterable<ID> ids);

    public Page<T> findAll(Pageable pageable);

    public List<T> findAll(Sort sort);

    public T findOne(ID id);

    public <S extends T> List<S> save(Iterable<S> entities);

    public <S extends T> S save(S entity);

}
