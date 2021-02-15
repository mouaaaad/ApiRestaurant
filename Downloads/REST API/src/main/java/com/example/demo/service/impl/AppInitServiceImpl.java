package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.inter.IAppInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class AppInitServiceImpl implements IAppInitService
{
    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    RestaurantCategoryRepository restaurantCategoryRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MealCategoryRepository mealCategoryRepository;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public void initUsers()
    {
        List<User> users = new ArrayList<>();
        users.add(new Client(null, "mouad", "mouad@email.com", "123","","","","", null,"Client",new Date()));
        users.add(new Manager(null, "nisrine", "nisrine@email.com", "123" ,"","","","", null,"Manager", new Date()));
        users.add(new Client(null, "ayoub", "ayoub@email.com", "123","","","","", null,"Client", new Date()));
        users.add(new Manager(null, "hamza", "hamza@email.com", "123","","","","", null, "Manager",new Date()));
        for (User user : users)
        {
            userRepository.save(user);
        }
    }

//    // Second version
//    public void initUsers()
//    {
//        List<Client> clients = new ArrayList<>();
//        List<Manager> managers = new ArrayList<>();
//        clientRepository.save(new Client(null, "username1", "email1@email.com", new BCryptPasswordEncoder().encode("123"), null, new Date()));
//        managerRepository.save(new Manager(null, "username2", "email2@email.com", new BCryptPasswordEncoder().encode("123"), null, new Date()));
//        clientRepository.save(new Client(null, "username3", "email3@email.com", new BCryptPasswordEncoder().encode("123"), null, new Date()));
//        managerRepository.save(new Manager(null, "username4", "email4@email.com", new BCryptPasswordEncoder().encode("123"), null, new Date()));
//    }

    @Override
    public void initCities()
    {
        Stream.of("Casablanca", "Rabat", "Kénitra").forEach(cityName ->
        {
            City city = new City(null, cityName, null);
            cityRepository.save(city);
        });
    }

    @Override
    public void initRestaurantCategories()
    {
        List<RestaurantCategory> categories = new ArrayList<>();
        categories.add(new RestaurantCategory(null, "Fast Food", null));
        categories.add(new RestaurantCategory(null, "Pizza", null));
        categories.add(new RestaurantCategory(null, "Tacos", null));
        for (RestaurantCategory category : categories)
        {
            restaurantCategoryRepository.save(category);
        }
    }

    @Override
    public void initRestaurants()
    {
        // Une première façon
        restaurantCategoryRepository.findById(1L).ifPresent(restaurantCategory ->
        {
            managerRepository.findById(2L).ifPresent(manager ->
            {
                cityRepository.findById(1L).ifPresent(city ->
                {
                    Calendar instance = Calendar.getInstance();
                    instance.set(0, 0, 0, 8, 0, 0);
                    Date openingTime = instance.getTime();
                    instance.set(0, 0, 0, 23, 0, 0);
                    Date closingTime = instance.getTime();

                    restaurantRepository.save(new Restaurant(null, "La Sqala", "https://firebasestorage.googleapis.com/v0/b/database-b2038.appspot.com/o/images%2F150dac23-b0fc-4937-b7b3-da82056b5da7?alt=media&token=ba85a89a-7c4e-445a-a74c-6171b1a63cad", "0522260960", 33.602907494472916, -7.619123341144301,new Date(), city, openingTime, closingTime, restaurantCategory, manager, null, null));
                });
            });
        });

        // Une deuxième façon
        {
            Calendar instance = Calendar.getInstance();
            instance.set(0, 0, 0, 11, 0, 0);
            Date openingTime = instance.getTime();
            instance.set(0, 0, 0, 0, 0, 0);
            Date closingTime = instance.getTime();

            restaurantRepository.save(new Restaurant(null, "Le Dhow", "https://firebasestorage.googleapis.com/v0/b/database-b2038.appspot.com/o/images%2F8c52143b-26db-4ec2-9917-d457bdebbcc8?alt=media&token=52f4514b-09d4-4ed2-9c9a-c8811bae7980", "0537702302", 34.028942633048786, -6.832355812393539,new Date(), cityRepository.findById(2L).get(), openingTime, closingTime, restaurantCategoryRepository.findById(2L).get(), managerRepository.findById(4L).get(), null, null));
        }

        {
            Calendar instance = Calendar.getInstance();
            instance.set(0, 0, 0, 11, 0, 0);
            Date openingTime = instance.getTime();
            instance.set(0, 0, 0, 0, 0, 0);
            Date closingTime = instance.getTime();

            restaurantRepository.save(new Restaurant(null, "Little Japan", "https://firebasestorage.googleapis.com/v0/b/database-b2038.appspot.com/o/images%2Fa5b8b5c4-5098-4f19-b512-f78e99df27a2?alt=media&token=edff9384-d5e0-47da-ae00-168378c040f3", "0537363534", 34.260982980170155, -6.589085301636395,new Date(),cityRepository.findById(3L).get(), openingTime, closingTime, restaurantCategoryRepository.findById(2L).get(), managerRepository.findById(4L).get(), null, null));
        }

    }

    @Override
    public void initMealCategories()
    {
        Stream.of("breakfast", "lunch", "dinner").forEach(category ->
        {
            mealCategoryRepository.save(new MealCategory(null, category, null));
        });
    }

    @Override
    public void initMeals()
    {
        mealRepository.save(new Meal(null, "Hamburger", 30.00, "detail1",restaurantRepository.findById(1L).get(), mealCategoryRepository.findById(1L).get()));
        mealRepository.save(new Meal(null, "Double Cheese", 45.00, "detail1",restaurantRepository.findById(2L).get(), mealCategoryRepository.findById(2L).get()));
        mealRepository.save(new Meal(null, "Rosti", 60.00, "detail1",restaurantRepository.findById(2L).get(), mealCategoryRepository.findById(3L).get()));
    }

    @Override
    public void initReviews()
    {
        reviewRepository.save(new Review(null, 2,"cool", new Date() , clientRepository.findById(1L).get(), restaurantRepository.findById(1L).get()));
        reviewRepository.save(new Review(null, 3,"J'adore ce restaurant", new Date() ,  clientRepository.findById(1L).get(), restaurantRepository.findById(2L).get()));
        reviewRepository.save(new Review(null, 4,"Je déconseille", new Date(),clientRepository.findById(3L).get(), restaurantRepository.findById(1L).get()));
        reviewRepository.save(new Review(null, 5,"J'aime",new Date(), clientRepository.findById(3L).get(), restaurantRepository.findById(2L).get()));
    }

    @Override
    public void initComment()
    {
        commentRepository.save(new Comment(null, "Coool", new Date(), clientRepository.findById(1L).get(), restaurantRepository.findById(1L).get()));
        commentRepository.save(new Comment(null, "J'adore ce restaurant", new Date(), clientRepository.findById(1L).get(), restaurantRepository.findById(1L).get()));
        commentRepository.save(new Comment(null, "J'aime", new Date(), clientRepository.findById(3L).get(), restaurantRepository.findById(1L).get()));
        commentRepository.save(new Comment(null, "Nul", new Date(), clientRepository.findById(3L).get(), restaurantRepository.findById(2L).get()));
        commentRepository.save(new Comment(null, "1 étoile", new Date(), clientRepository.findById(3L).get(), restaurantRepository.findById(2L).get()));
        commentRepository.save(new Comment(null, "Je déconseille", new Date(), clientRepository.findById(1L).get(), restaurantRepository.findById(2L).get()));
    }

    @Override
    public void initFavoriteRestaurant()
    {
        favoriteRestaurantRepository.save(new FavoriteRestaurant(null, clientRepository.findById(1L).get(), restaurantRepository.findById(1L).get()));
        favoriteRestaurantRepository.save(new FavoriteRestaurant(null, clientRepository.findById(3L).get(), restaurantRepository.findById(1L).get()));
        favoriteRestaurantRepository.save(new FavoriteRestaurant(null, clientRepository.findById(3L).get(), restaurantRepository.findById(2L).get()));
    }

    @Override
    public void insertAllData()
    {
        System.out.println("INSERT");

        initUsers(); // 1
        initCities(); // 2
        initRestaurantCategories(); // 3
        initRestaurants(); // 4
        initMealCategories(); // 5
        initMeals(); // 6
        initReviews(); // 7
        initComment(); // 8
        initFavoriteRestaurant(); // 9
    }

    @Override
    public void deleteAllData()
    {
        System.out.println("DELETE");

        favoriteRestaurantRepository.truncate(); // 9
        commentRepository.truncate(); // 8
        reviewRepository.truncate(); // 7
        mealRepository.truncate(); // 6
        mealCategoryRepository.truncate(); // 5
        restaurantRepository.truncate(); // 4
        restaurantCategoryRepository.truncate(); // 3
        cityRepository.truncate(); // 2
        userRepository.truncate(); // 1
    }
}