package lk.ijse.thogakadehibernate.business.custom;

import lk.ijse.thogakadehibernate.business.SuperBO;
import lk.ijse.thogakadehibernate.dto.OrdersDTO;

public interface OrdersBO extends SuperBO {
    boolean addOrder(OrdersDTO ordersDTO)throws Exception;
}
