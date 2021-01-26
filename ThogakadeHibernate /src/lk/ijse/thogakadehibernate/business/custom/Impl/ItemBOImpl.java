package lk.ijse.thogakadehibernate.business.custom.Impl;

import javafx.collections.FXCollections;
import lk.ijse.thogakadehibernate.business.custom.ItemBO;
import lk.ijse.thogakadehibernate.dao.DAOFactory;
import lk.ijse.thogakadehibernate.dao.DAOType;
import lk.ijse.thogakadehibernate.dao.custom.CustomerDAO;
import lk.ijse.thogakadehibernate.dao.custom.ItemDAO;
import lk.ijse.thogakadehibernate.dto.ItemDTO;
import lk.ijse.thogakadehibernate.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
     ItemDAO itemDAO= (ItemDAO) DAOFactory.getInstance().getDAO(DAOType.ITEM);



    @Override
    public boolean addItem(ItemDTO itemDTO) throws Exception {
        Item item = new Item(itemDTO.getItemCode(),itemDTO.getItemName(),itemDTO.getUnitPrice(),itemDTO.getQTYOnHand());
        boolean add = itemDAO.add(item);
        return add;
    }

    @Override
    public boolean deleteItem(String itemCode) throws Exception {
        return itemDAO.delete(itemCode);

    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws Exception {
        Item item = new Item(itemDTO.getItemCode(),itemDTO.getItemName(),itemDTO.getUnitPrice(),itemDTO.getQTYOnHand());
        return itemDAO.update(item);
    }

    @Override
    public ItemDTO search(String s) throws Exception {
        Item search = itemDAO.search(s);
        return new ItemDTO(search.getItemCode(),search.getItemName(),search.getUnitPrice(),search.getQTYOnHand());

    }

    @Override
    public List<ItemDTO> getAll() throws Exception {
        List<Item> all = itemDAO.getAll();
        List<ItemDTO>dto= FXCollections.observableArrayList();

        for (int i = 0; i <all.size() ; i++) {
            ItemDTO itemDTO = new ItemDTO(all.get(i).getItemCode(),all.get(i).getItemName(),all.get(i).getUnitPrice(),all.get(i).getQTYOnHand());
            dto.add(itemDTO);
            System.out.println(itemDTO);
        }
        return dto;
    }
}
