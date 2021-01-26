package lk.ijse.thogakadehibernate.tm;

public class Order {
    private String itemCode;
    private int qty;

    public Order() {
    }

    public Order(String itemCode, int qty) {
        this.itemCode = itemCode;
        this.qty = qty;
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
        return "Order{" +
                "itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                '}';
    }
}
