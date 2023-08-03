package D288.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="carts")
@Getter
@Setter
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Cart_ID")
    private Long id;

    @Column(name="Order_Tracking_Number")
    private String orderTrackingNumber;

    @Column(name="Package_Price")
    private BigDecimal package_price;

    @Column(name="Party_Size")
    private int party_size;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @ManyToOne
    @JoinColumn(name="customer_ID" ,nullable = false)
    private Customer customer;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems = new HashSet<>();

    @Column(name="Create_Date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="Last_Update")
    @UpdateTimestamp
    private Date last_update;

    public void addItems(CartItem cartItem) {
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }

}
