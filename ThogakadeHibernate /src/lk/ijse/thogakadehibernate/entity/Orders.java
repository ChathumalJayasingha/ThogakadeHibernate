package lk.ijse.thogakadehibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Orders {
    @Id
    private String orderId;
    private Date date;
    @OneToOne
    @JoinColumn(name = "id")
    private Customer customer;

    public Orders() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                '}';
    }
}
