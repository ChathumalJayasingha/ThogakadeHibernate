package lk.ijse.thogakadehibernate.dao;

import lk.ijse.thogakadehibernate.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakadehibernate.dao.custom.impl.ItemDAOImpl;
import lk.ijse.thogakadehibernate.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.thogakadehibernate.dao.custom.impl.OrdersDAOImpl;

public class DAOFactory {

    public static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAO(DAOType daoType) {
        switch (daoType) {
            case CUSTOMER: return new CustomerDAOImpl();
            case ITEM:return new ItemDAOImpl();
            case ORDERS:return new OrdersDAOImpl();
            case ORDERDETAIL:return new OrderDetailDAOImpl();
            default:return null;
        }


    }
}
