package D288.services;

import D288.entities.Cart;
import D288.entities.CartItem;
import D288.entities.Customer;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;

}