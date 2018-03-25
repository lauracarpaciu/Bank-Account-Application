package com.lauracarpaciu.service;

import com.lauracarpaciu.dao.CartEventRepository;
import com.lauracarpaciu.dao.CategoryRepository;
import com.lauracarpaciu.dao.UserRepository;
import com.lauracarpaciu.entities.cart.CartEvent;
import com.lauracarpaciu.entities.cart.ShoppingCart;
import com.lauracarpaciu.entities.catalog.Category;
import com.lauracarpaciu.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartEventRepository cartEventRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public User getAuthenticatedUser(String userName) {
        User user = userRepository.findOne(userName);
        return user;
    }

    @Override
    public Boolean addCartEvent(CartEvent cartEvent ,String userName) {
        User user = getAuthenticatedUser(userName);
        if (user != null) {
            cartEvent.setUserId(user.getId());
            cartEventRepository.save(cartEvent);
        } else {
            return null;
        }
        return true;
    }

    @Override
    public Boolean addCartEvent(CartEvent cartEvent, User user) {
        if (user != null) {
            cartEvent.setUserId(user.getId());
            cartEventRepository.save(cartEvent);
        } else {
            return null;
        }
        return true;
    }

//    @Override
//    public ShoppingCart getShoppingCart(String userName, Long categoryId) {
//        User user = userRepository.findOne(userName);
//        ShoppingCart shoppingCart = null;
//        if (user != null) {
//            Category category = categoryRepository.findOne(categoryId);
//            shoppingCart = aggregateCartEvents(user,category);
//        }
//        return shoppingCart;
//    }


}
