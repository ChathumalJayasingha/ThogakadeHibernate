package lk.ijse.thogakadehibernate.business.custom;

import lk.ijse.thogakadehibernate.business.SuperBO;
import lk.ijse.thogakadehibernate.dao.CrudDAO;
import lk.ijse.thogakadehibernate.dto.CustomerDTO;
import lk.ijse.thogakadehibernate.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO {
    boolean addItem(ItemDTO itemDTO)throws Exception;
    boolean deleteItem(String itemCode)throws Exception;
    boolean updateItem(ItemDTO itemDTO)throws Exception;
    ItemDTO search(String itemCode)throws Exception;
    List<ItemDTO> getAll()throws Exception;
}
