package empty.boot.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "baskets")
public class Basket extends Model {

    @Column(name = "name")
    private String name;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "basketId")
//    private List<Egg> eggs;
//    public List<Egg> getEggs() {
//        return eggs;
//    }
//
//    public void setEggs(List<Egg> eggs) {
//        this.eggs = eggs;
//    }

    public String getName() {
        return name;
    }

    public Basket setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
