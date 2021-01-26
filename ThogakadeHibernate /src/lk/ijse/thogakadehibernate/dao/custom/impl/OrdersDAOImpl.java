package lk.ijse.thogakadehibernate.dao.custom.impl;

import lk.ijse.thogakadehibernate.dao.custom.OrdersDAO;
import lk.ijse.thogakadehibernate.entity.Orders;
import lk.ijse.thogakadehibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {
    @Override
    public boolean add(Orders orders) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(orders);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(Orders orders) throws Exception {
        return false;
    }

    @Override
    public Orders search(String s) throws Exception {
        return null;
    }

    @Override
    public List<Orders> getAll() throws Exception {
        return null;
    }
}
