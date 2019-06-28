package empty.boot.controller;

import empty.boot.entity.Basket;
import empty.boot.entity.Egg;
import empty.boot.repository.BasketRepository;
import empty.boot.repository.EggRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AppController {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    EggRepository eggRepository;

    @GetMapping("/baskets")
    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    @GetMapping("/baskets/{name}")
    public Basket getBasketByName(@PathVariable("name") String name) {
        return basketRepository.getByName(name);
    }

    @PostMapping("/baskets")
    public Basket saveBasket(@RequestBody Basket basket) {
        return basketRepository.save(basket);
    }

    @PutMapping("/baskets")
    public Basket updateBasket(@RequestBody Basket basket) {
        return basketRepository.save(basket);
    }

    @GetMapping("/baskets/{name}/eggs")
    public List<Egg> getBasketsEggs(@PathVariable("name") String name) {
        Basket basket = basketRepository.getByName(name);
        List<Egg> eggs = Collections.emptyList();
        if (basket != null) {
            eggs = eggRepository.getByBasketId(basket.getId());
        }
        return eggs;
    }

    @DeleteMapping("/baskets/{name}")
    @Transactional
    public void deleteBasket(@PathVariable("name") String name)  {
        Basket basket = basketRepository.getByName(name);
        System.out.println(basket + "basket !!!!!!++++++++++++++++++++++");
        if (basket != null) {
            eggRepository.deleteByBasketId(basket.getId());
            basketRepository.delete(basket);
        }
    }

    @Transactional
    @DeleteMapping("/baskets/{name}/eggs/{size}")
    public void deleteEggFromBasket(@PathVariable("name") String name, @PathVariable("size") Integer size) {
        Basket basket = basketRepository.getByName(name);
        if (basket != null) {
            List<Egg> eggs = eggRepository.getByBasketId(basket.getId());
            eggRepository.deleteAll(eggs.stream()
                    .filter(egg -> egg.getSize().equals(size)).collect(Collectors.toList()));
        }
    }

    @Transactional
    @PostMapping("/baskets/{name}/eggs")
    public Egg addEggToBasket(@PathVariable("name") String name, @RequestBody Egg egg) {
        Basket basket = basketRepository.getByName(name);
        if (basket == null) {
            throw new IllegalArgumentException("Basket not found");
        }
        egg.setBasket(basket);
        return eggRepository.save(egg);
    }

    @Transactional
    @PostMapping("/eggs")
    public Egg addEgg(@RequestBody Egg egg) {
        return eggRepository.save(egg);
    }

}
