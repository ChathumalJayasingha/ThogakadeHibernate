package lk.ijse.thogakadehibernate.dao.custom.impl;

import lk.ijse.thogakadehibernate.dao.custom.ItemDAO;
import lk.ijse.thogakadehibernate.entity.Customer;
import lk.ijse.thogakadehibernate.entity.Item;
import lk.ijse.thogakadehibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Item item = session.get(Item.class, s);
        if (item!=null){
            session.delete(item);
        }
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(Item item) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(item);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public Item search(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Item item = session.get(Item.class,s);
        Query query = session.createQuery("from Item where id=?1 ");
        query.setParameter(1,s);
        List<Item>list = query.list();
        for (Item item1 : list) {
            System.out.println(item1.getItemCode()+":"+item1.getItemName()+":"+item1.getUnitPrice()+":"+item1.getQTYOnHand());
        }


        transaction.commit();
        session.close();
        return item;
    }

    @Override
    public List<Item> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Item ");
        List<Item>list = query.list();
        for (Item item : list) {
            System.out.println(item);
        }

        transaction.commit();
        session.close();
        return  list;
    }
}
