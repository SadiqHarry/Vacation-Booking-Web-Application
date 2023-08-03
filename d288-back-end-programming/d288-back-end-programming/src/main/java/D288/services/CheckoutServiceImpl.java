package D288.services;

import D288.dao.CartRepository;
import D288.dao.CustomerRepository;
import D288.entities.Cart;
import D288.entities.CartItem;
import D288.entities.Customer;
import D288.entities.StatusType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository){
        this.customerRepository=customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        Cart cart = purchase.getCart();
        String orderTrackingNumber=generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems=purchase.getCartItems();
        cartItems.forEach(item->cart.addItems(item));

        cart.setStatus(StatusType.ORDERED);
        System.out.println(cart);






        cartRepository.save(cart);
        return new PurchaseResponse(orderTrackingNumber);


    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();

    }
}

