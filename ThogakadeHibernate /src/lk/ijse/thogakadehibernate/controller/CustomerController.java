package lk.ijse.thogakadehibernate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.thogakadehibernate.business.BOFactory;
import lk.ijse.thogakadehibernate.business.BOType;
import lk.ijse.thogakadehibernate.business.SuperBO;
import lk.ijse.thogakadehibernate.business.custom.CustomerBO;
import lk.ijse.thogakadehibernate.business.custom.Impl.CustomerBOImpl;
import lk.ijse.thogakadehibernate.business.custom.ItemBO;
import lk.ijse.thogakadehibernate.dto.CustomerDTO;
import lk.ijse.thogakadehibernate.dto.ItemDTO;
import lk.ijse.thogakadehibernate.tm.Order;

import java.time.LocalDate;
import java.util.List;

public class CustomerController {


    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public Button btnAdd;
    public TextField txtId;
    public Button btnDelete;
    public Button btnUpdate;
    public TableView tblCustomer;
    public TableColumn clmId;
    public TableColumn clmName;
    public TableColumn clmAddress;
    public TableColumn clmContact;
    public Button btnSearch;
    public TableView tblItem;
    public TableColumn clmItemCode;
    public TableColumn clmItemName;
    public TableColumn clmUnitPrice;
    public TableColumn clmQTYOnHand;
    public TextField txtItemCode;
    public TextField txtItemName;
    public TextField txtUnitPrice;
    public TextField txtQTYOnHand;
    public TextArea txtAreaCustomer;
    public ChoiceBox choiceBoxCustomer;
    public Label lblDate;
    public Button btnCustomerAdd;
    public ChoiceBox choiceBoxItem;
    public TextArea txtAreaItemDetail;
    public Button btnAddItem;
    public TextField txtTransQTY;
    public TableView tblOrderList;
    public TableColumn clmItemCodeTrans;
    public TableColumn clmQTYTrans;
    public TextField txtOrderId;
    public Button btnOrder;

    CustomerBO customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOType.CUSTOMER);
    ItemBO itemBO= (ItemBO) BOFactory.getInstance().getBO(BOType.ITEM);

    public void initialize(){
        clmId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        getAllOnAction();
        clmItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        clmItemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        clmQTYOnHand.setCellValueFactory(new PropertyValueFactory<>("QTYOnHand"));
        clmUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        itemAddToTable();
        lblDate.setText(String.valueOf(LocalDate.now()));
        choiceBoxCustomerIDSet();
        choiceBoxCustomer.setOnAction(this::customerSelectOnAction);
        choiceBoxItemIDSet();
        choiceBoxItem.setOnAction(this::itemSelectOnAction);
        clmQTYTrans.setCellValueFactory(new PropertyValueFactory<>("qty"));
        clmItemCodeTrans.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));

    }


    private void choiceBoxItemIDSet() {
        try {
            List<ItemDTO> all = itemBO.getAll();
            for (ItemDTO itemDTO : all) {
                choiceBoxItem.getItems().add(itemDTO.getItemCode());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void choiceBoxCustomerIDSet() {
        try {
            List<CustomerDTO> all = customerBO.getAll();
            for (CustomerDTO customerDTO : all) {
                choiceBoxCustomer.getItems().add(customerDTO.getId());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //********************CustomerControllingPartStartHere****************
    private void getAllOnAction() {
        try {
            List<CustomerDTO> all = customerBO.getAll();
            ObservableList<CustomerDTO>observableList= FXCollections.observableArrayList();

            for (int i = 0; i < all.size(); i++) {
                CustomerDTO customerDTO = new CustomerDTO(all.get(i).getId(),all.get(i).getName(),all.get(i).getAddress(),all.get(i).getContact());
                observableList.add(customerDTO);
            }

            tblCustomer.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addOnAction(ActionEvent actionEvent) {



        CustomerDTO customerDTO = new CustomerDTO(txtId.getText(),txtName.getText(),txtAddress.getText(),txtContact.getText());

        try {
            boolean b = customerBO.addCustomer(customerDTO);
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION,"Added Success");
            }else {
                new Alert(Alert.AlertType.ERROR,"Added Fail");

            }
            getAllOnAction();
            txtId.setText(null);
            txtName.setText(null);
            txtContact.setText(null);
            txtAddress.setText(null);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void updateOnAction(ActionEvent actionEvent) {
        CustomerDTO customerDTO = new CustomerDTO(txtId.getText(),txtName.getText(),txtAddress.getText(),txtContact.getText());

        try {
            boolean b = customerBO.updateCustomer(customerDTO);
            getAllOnAction();
            txtId.setText(null);
            txtName.setText(null);
            txtContact.setText(null);
            txtAddress.setText(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteOnAction(ActionEvent actionEvent) {

        try {
            boolean b = customerBO.deleteCustomer(txtId.getText());
            if (b){
                new Alert(Alert.AlertType.CONFIRMATION,"Added Success");
            }else {
                new Alert(Alert.AlertType.ERROR,"Added Fail");

            }
            getAllOnAction();
            txtId.setText(null);
            txtName.setText(null);
            txtContact.setText(null);
            txtAddress.setText(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            CustomerDTO search = customerBO.search(txtId.getText());
            txtId.setText(search.getId());
            txtName.setText(search.getName());
            txtAddress.setText(search.getAddress());
            txtContact.setText(search.getContact());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //********************CustomerControllingPartEndHere****************

    //********************ItemControllingPartStartHere****************

    public void btnItemSearch(ActionEvent actionEvent) {
        try {
            ItemDTO search = itemBO.search(txtItemCode.getText());
            if (search==(null)){
                new Alert(Alert.AlertType.INFORMATION,"No Found").show();
            }else {
                txtItemCode.setText(search.getItemCode());
                txtItemName.setText(search.getItemName());
                txtUnitPrice.setText(String.valueOf(search.getUnitPrice()));
                txtQTYOnHand.setText(String.valueOf(search.getQTYOnHand()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnItemAdd(ActionEvent actionEvent) {
        ItemDTO itemDTO = new ItemDTO(txtItemCode.getText(),
                txtItemName.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQTYOnHand.getText()));
        try {
            boolean add = itemBO.addItem(itemDTO);
            if ((add)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Added").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Added show").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        itemAddToTable();
        txtItemCode.setText(null);
        txtItemName.setText(null);
        txtUnitPrice.setText(null);
        txtQTYOnHand.setText(null);
    }

    public void btnItemDelete(ActionEvent actionEvent) {
        try {
            boolean delete = itemBO.deleteItem(txtItemCode.getText());
            if (delete){
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Deleted Fali").show();

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        itemAddToTable();
        txtItemCode.setText(null);
        txtItemName.setText(null);
        txtUnitPrice.setText(null);
        txtQTYOnHand.setText(null);
    }

    public void btnItemUpdate(ActionEvent actionEvent) {
        ItemDTO itemDTO = new ItemDTO(txtItemCode.getText(),
                txtItemName.getText(),
                Double.parseDouble(txtUnitPrice.getText()),
                Integer.parseInt(txtQTYOnHand.getText()));
        try {
            boolean update = itemBO.updateItem(itemDTO);
            if ((update)) {
                new Alert(Alert.AlertType.CONFIRMATION, "updated").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "update fail").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }itemAddToTable();
        txtItemCode.setText(null);
        txtItemName.setText(null);
        txtUnitPrice.setText(null);
        txtQTYOnHand.setText(null);
    }

    private void itemAddToTable() {
        try {
            List<ItemDTO> all = itemBO.getAll();
            ObservableList<ItemDTO>observableList=FXCollections.observableArrayList();

            for (int i = 0; i <all.size() ; i++) {
                observableList.add(new ItemDTO(all.get(i).getItemCode(),all.get(i).getItemName(),all.get(i).getUnitPrice(),all.get(i).getQTYOnHand()));
            }
            tblItem.setItems(observableList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void customerSelectOnAction(Event event) {
        Object value = choiceBoxCustomer.getValue();
        String custId = value.toString();
        System.out.println(custId);

        try {
            CustomerDTO search = customerBO.search(custId);
            txtAreaCustomer.clear();
            txtAreaCustomer.appendText(search.getId()+" : "+search.getName()+" : "+search.getAddress()+" : "+search.getContact());

        } catch (Exception e) {
            e.printStackTrace();
        }
        btnCustomerAdd.setDisable(false);


        
    }

    public void customerAddOnAction(ActionEvent actionEvent) {
        btnCustomerAdd.setDisable(true);
        choiceBoxCustomer.setDisable(true);
    }



    private void itemSelectOnAction(Event event) {
        Object value = choiceBoxItem.getValue();
        String itemCode = value.toString();
        System.out.println(itemCode);

        try {
            ItemDTO search = itemBO.search(itemCode);
            txtAreaItemDetail.clear();
            txtAreaItemDetail.appendText( "Name :"+search.getItemName()+"\t UnitPrice : "+search.getUnitPrice()+" \t QTYOnHand: "+search.getQTYOnHand());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void orderIdOnAction(ActionEvent actionEvent) {
        String text = txtOrderId.getText();
        txtOrderId.setDisable(true);
    }

    public void orderOnAction(ActionEvent actionEvent) {

    }

    public void addItemOnAction(ActionEvent actionEvent) {
        int i = Integer.parseInt(txtTransQTY.getText());
        ObservableList<Order>observableList=FXCollections.observableArrayList();
        String value = choiceBoxItem.getValue().toString();
        Order order = new Order(value,i);
        observableList.add(order);
        tblOrderList.setItems(observableList);



    }


    //********************ItemControllingPartEndHere****************





}
