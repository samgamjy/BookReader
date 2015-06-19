package by.academy.it.dao;


import by.academy.it.dao.exceptions.DaoException;
//import by.academy.it.util.HibernateUtil;
//import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
@Repository
public class BaseDao<T> implements Dao<T> {
    //    private static Logger log = Logger.getLogger(BaseDao.class);
//    private Transaction transaction = null;
    protected SessionFactory sessionFactory;


    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public void saveOrUpdate(T t) throws DaoException {
//        Session session = getSession();
        getSession().saveOrUpdate(t);
//            log.info("saveOrUpdate(t):" + t);
    }

    public void save(T t) throws DaoException {
//        Session session = getSession();
        getSession().save(t);
//            log.info("save(t):" + t);
    }

    public T get(Serializable id) throws DaoException {
//        log.info("Get class by id:" + id);
        T t = null;
//        try {

//            transaction = getSession().beginTransaction();
            t = (T) getSession().get(getPersistentClass(), id);
//            transaction.commit();
//            log.info("get clazz:" + t);
//        }
        return t;
    }

    public List<T> getAll() throws DaoException {
        List<T> list = Collections.emptyList();
//        try {
//            Session session = getSession();
//            transaction = getSession().beginTransaction();
            Criteria criteria = getSession().createCriteria(getPersistentClass());
            criteria.addOrder(Order.desc("id"));
            list = (List<T>) criteria.list();
//            transaction.commit();
//            log.info("getAll, size=" + list.size());
//        } catch (HibernateException e) {
//            transaction.rollback();
//            log.error("Error get " + getPersistentClass() + " in Dao" + e);
//            throw new DaoException(e);
//        }
        return list;
    }

    public T load(Serializable id) throws DaoException {
//        log.info("Load class by id:" + id);
        T t = null;
//        try {
//            Session session = getSession();
//            transaction = session.beginTransaction();
            t = (T) getSession().load(getPersistentClass(), id);
//            log.info("load() clazz:" + t);
        getSession().isDirty();
//            transaction.commit();
//        } catch (HibernateException e) {
//            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
//            transaction.rollback();
//            throw new DaoException(e);
//        }
        return t;
    }

    public void delete(T t) throws DaoException {
//        try {
            Session session = getSession();
//            transaction = session.beginTransaction();
            session.delete(t);
//            transaction.commit();
//            log.info("Delete:" + t);
//        } catch (HibernateException e) {
//            log.error("Error save or update PERSON in Dao" + e);
//            transaction.rollback();
//            throw new DaoException(e);
//        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

//    public Transaction getTransaction() {
//        return transaction;
//    }
//
//    public void setTransaction(Transaction transaction) {
//        this.transaction = transaction;
//    }
}
