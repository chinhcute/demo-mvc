package mvc.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;
@Component
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetailsEntity> orderDetailsEntityList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderDetailsEntity> getOrderDetailsEntityList() {
        return orderDetailsEntityList;
    }

    public void setOrderDetailsEntityList(List<OrderDetailsEntity> orderDetailsEntityList) {
        this.orderDetailsEntityList = orderDetailsEntityList;
    }


}
