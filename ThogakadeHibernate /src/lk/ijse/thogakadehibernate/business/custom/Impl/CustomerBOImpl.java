package lk.ijse.thogakadehibernate.business.custom.Impl;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;
import lk.ijse.thogakadehibernate.business.custom.CustomerBO;
import lk.ijse.thogakadehibernate.dao.DAOFactory;
import lk.ijse.thogakadehibernate.dao.DAOType;
import lk.ijse.thogakadehibernate.dao.SuperDAO;
import lk.ijse.thogakadehibernate.dao.custom.CustomerDAO;
import lk.ijse.thogakadehibernate.dto.CustomerDTO;
import lk.ijse.thogakadehibernate.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOType.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        Customer customer = new Customer(customerDTO.getId(),
                customerDTO.getName(),customerDTO.getAddress(),
                customerDTO.getContact());
        boolean add = customerDAO.add(customer);
        if (add){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
        Customer customer = new Customer(customerDTO.getId(),
                customerDTO.getName(),customerDTO.getAddress(),
                customerDTO.getContact());
        boolean update = customerDAO.update(customer);
        if (update){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public CustomerDTO search(String id) throws Exception {
        Customer search = customerDAO.search(id);
        CustomerDTO customerDTO = new CustomerDTO(search.getId(),search.getName(),search.getAddress(),search.getContact());
        return customerDTO;

    }

    @Override
    public List<CustomerDTO> getAll() throws Exception {
        List<Customer> all = customerDAO.getAll();
        List<CustomerDTO>dto= FXCollections.observableArrayList();

        for (int i = 0; i < all.size(); i++) {
            CustomerDTO customerDTO = new CustomerDTO(all.get(i).getId(), all.get(i).getName(), all.get(i).getAddress(), all.get(i).getContact());
            dto.add(customerDTO);
            System.out.println(customerDTO);
        }return dto;


    }

}
