package D288.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Division_ID")
    private Long id;

    @Column(name="Division")
    private String division_name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;



    @Column(name="Create_Date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="Last_Update")
    @UpdateTimestamp
    private Date last_update;

}



