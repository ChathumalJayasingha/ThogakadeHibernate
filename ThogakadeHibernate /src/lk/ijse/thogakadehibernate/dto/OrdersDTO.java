package lk.ijse.thogakadehibernate.dto;

import java.util.Date;

public class OrdersDTO {
    private String oid;
    private Date date;
    private String customerId;

    public OrdersDTO() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "oid='" + oid + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
