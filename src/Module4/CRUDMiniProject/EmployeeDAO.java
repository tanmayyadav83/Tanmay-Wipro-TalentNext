package com.example.crud.dao;

import com.example.crud.model.Employee;
import com.example.crud.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {

    public Integer add(Employee e) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            Integer id = (Integer) s.save(e);
            tx.commit();
            return id;
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }

    public boolean update(Employee e) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            s.update(e);
            tx.commit();
            return true;
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            return false;
        }
    }

    public boolean delete(int id) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            tx = s.beginTransaction();
            Employee e = s.get(Employee.class, id);
            if (e != null) {
                s.delete(e);
                tx.commit();
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            if (tx != null) tx.rollback();
            return false;
        }
    }

    public Employee findById(int id) {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.get(Employee.class, id);
        }
    }

    public List<Employee> findAll() {
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createQuery("from Employee", Employee.class).list();
        }
    }
}
