package com.projectone.p1.service;

import com.projectone.p1.dao.CartDAO;
import com.projectone.p1.dao.ItemDAO;
import com.projectone.p1.dao.UserDAO;
import com.projectone.p1.model.Cart;
import com.projectone.p1.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class CartServiceImpl implements CartService{
    private static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);
    @Autowired
    CartDAO cartDAO;
    @Autowired
    ItemDAO itemDAO;
    @Override
    public boolean addCart(Cart cart) {
        cartDAO.save(cart);
        return true;
    }

    @Override
    public boolean deletCart(int cartId) {
        cartDAO.deleteById(cartId);
        return true;
    }

    @Override
    public boolean updateCart(Cart cart) {
        cartDAO.save(cart);
        return true;
    }

    @Override
    public Cart getCart(int cartId) {
       Cart cart = cartDAO.getById(cartId);
        return cart;
    }

    @Override
    public boolean doesCartExists(int cartId) {
        return cartDAO.existsById(cartId);
    }

    @Override
    public List<Cart> getCartbyUser(User user) {

        return cartDAO.findByUser(user);
    }

    @Override
    public boolean doesUserIdExists(int userId) {
        return cartDAO.existsById(userId);
    }

    @Override
    public boolean addItemToCart(int itemId) {
        Cart cart = new Cart();
        cart.getCartItems().add(itemDAO.getById(itemId));
        return true;
    }
}
