package empty.boot.repository;

import empty.boot.entity.Basket;

public interface BasketRepository extends DataRepository<Basket> {

    Basket getByName(String name);

}
