package lk.ijse.thogakadehibernate.dto;

public class OrderDetailDTO {
    private String orderId;
    private String itemCode;
    private int qty;

    public OrderDetailDTO(String orderId, String itemCode, int qty) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.qty = qty;
    }

    public OrderDetailDTO() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId='" + orderId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                '}';
    }
}
