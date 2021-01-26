package lk.ijse.thogakadehibernate.business.custom;

import lk.ijse.thogakadehibernate.business.SuperBO;
import lk.ijse.thogakadehibernate.dto.CustomerDTO;
import lk.ijse.thogakadehibernate.entity.Customer;

import java.util.List;

public interface CustomerBO extends SuperBO {

    boolean addCustomer(CustomerDTO customerDTO)throws Exception;
    boolean deleteCustomer(String id)throws Exception;
    boolean updateCustomer(CustomerDTO customerDTO)throws Exception;
    CustomerDTO search(String id)throws Exception;
    List<CustomerDTO>getAll()throws Exception;


}
