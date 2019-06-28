package empty.boot.service;

import empty.boot.repository.BasketRepository;
import empty.boot.repository.EggRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    EggRepository eggRepository;


}
