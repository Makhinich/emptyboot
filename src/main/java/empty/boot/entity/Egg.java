package empty.boot.entity;

import javax.persistence.*;

@Entity
@Table(name = "eggs")
public class Egg extends Model {

    @Column(name = "size")
    private Integer size;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public Basket getBasket() {
        return basket;
    }

    public Integer getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public Egg setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Egg setColor(String color) {
        this.color = color;
        return this;
    }

    public Egg setBasket(Basket basket) {
        this.basket = basket;
        return this;
    }

    @Override
    public String toString() {
        return "Egg{" +
                "size=" + size +
                ", color='" + color + '\'' +
                ", basket=" + basket +
                "} " + super.toString();
    }
}
