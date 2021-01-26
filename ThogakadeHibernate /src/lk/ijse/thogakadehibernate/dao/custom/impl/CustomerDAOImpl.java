package lk.ijse.thogakadehibernate.dao.custom.impl;

import lk.ijse.thogakadehibernate.dao.custom.CustomerDAO;
import lk.ijse.thogakadehibernate.entity.Customer;
import lk.ijse.thogakadehibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer customer) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
         session.save(customer);
            transaction.commit();
            session.close();
              return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class,s);
        if (customer!=null){
            session.delete(customer);
            System.out.println("delete persistent object");
        }

        transaction.commit();
        session.close();
        return true;


    }

    @Override
    public boolean update(Customer customer) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public Customer search(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class,s);
        Query query = session.createQuery("from Customer where id=?1 ");
        query.setParameter(1,s);
        List<Customer>list = query.list();
        for (Customer customer1 : list) {
            System.out.println(customer1.getId()+":"+customer1.getName()+":"+customer1.getAddress()+":"+customer1.getContact());
        }


        transaction.commit();
        session.close();
        return customer;
    }

    @Override
    public List<Customer> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Customer ");
        List<Customer>list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }

        transaction.commit();
        session.close();
        return  list;
    }

}
