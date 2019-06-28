package empty.boot.repository;

import empty.boot.entity.Egg;

import java.util.List;

public interface EggRepository extends DataRepository<Egg> {

    List<Egg> getByBasketId(long id);

    void deleteByBasketId(long id);

}
