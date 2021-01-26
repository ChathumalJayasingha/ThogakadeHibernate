package lk.ijse.thogakadehibernate.dao.custom.impl;

import lk.ijse.thogakadehibernate.dao.custom.OrderDetailDAO;
import lk.ijse.thogakadehibernate.entity.OrderDetail;
import lk.ijse.thogakadehibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean add(OrderDetail orderDetail) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(orderDetail);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws Exception {
        return false;
    }

    @Override
    public OrderDetail search(String s) throws Exception {
        return null;
    }

    @Override
    public List<OrderDetail> getAll() throws Exception {
        return null;
    }
}
