package D288.dao;

import D288.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
