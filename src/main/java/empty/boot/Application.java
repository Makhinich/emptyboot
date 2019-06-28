package empty.boot;

import empty.boot.entity.Basket;
import empty.boot.entity.Egg;
import empty.boot.repository.BasketRepository;
import empty.boot.repository.EggRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Method to populate the database and testing the application.
     *
     * @param
     * @param
     * @return arguments of the application.
     */
    @Bean
    public CommandLineRunner commandLineRunner(BasketRepository basketRepository, EggRepository eggRepository) {
        return args -> {
            Basket basket = new Basket().setName("bas1");
            basketRepository.save(basket);
            Basket basket2 = new Basket().setName("bas2");
            basketRepository.save(basket2);
            Basket basket3 = new Basket().setName("bas3");
            basketRepository.save(basket3);

            Egg egg = new Egg().setColor("blue").setSize(6).setBasket(basket);
            eggRepository.save(egg);
            Egg egg1 = new Egg().setColor("yellow").setSize(7).setBasket(basket);
            eggRepository.save(egg1);
            Egg egg0 = new Egg().setColor("ggggg").setSize(7).setBasket(basket);
            eggRepository.save(egg0);

            Egg egg2 = new Egg().setColor("egg2").setSize(5).setBasket(basket2);
            eggRepository.save(egg2);
            Egg egg3 = new Egg().setColor("egg3").setSize(4).setBasket(basket2);
            eggRepository.save(egg3);

            System.out.println("Success !!!!!!!!!!!!!!!!!!!!!!!!");

//            Collection<User> users = userRepository.findAll();
//            users.forEach(System.out::println);
        };
    }
}