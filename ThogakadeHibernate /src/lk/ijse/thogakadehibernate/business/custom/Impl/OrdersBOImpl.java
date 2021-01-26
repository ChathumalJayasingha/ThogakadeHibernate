package lk.ijse.thogakadehibernate.business.custom.Impl;

import lk.ijse.thogakadehibernate.business.custom.OrdersBO;
import lk.ijse.thogakadehibernate.dao.DAOFactory;
import lk.ijse.thogakadehibernate.dao.DAOType;
import lk.ijse.thogakadehibernate.dao.custom.OrdersDAO;
import lk.ijse.thogakadehibernate.dto.OrdersDTO;
import lk.ijse.thogakadehibernate.entity.Orders;

public class OrdersBOImpl implements OrdersBO {

    OrdersDAO ordersDAO= (OrdersDAO) DAOFactory.getInstance().getDAO(DAOType.ORDERS);

    @Override
    public boolean addOrder(OrdersDTO ordersDTO) throws Exception {
        Orders orders = new Orders();
        orders.setOrderId(ordersDTO.getOid());
        orders.setDate(ordersDTO.getDate());
        orders.setCustomer(ordersDTO.getCustomerId());
    }

}
