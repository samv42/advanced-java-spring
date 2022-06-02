package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cost")
    int cost;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)

    @JoinColumns({
            @JoinColumn(name = "Customer_id", referencedColumnName = "id"),
            @JoinColumn(name = "Customer_name", referencedColumnName = "name")
    })
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "User_id", referencedColumnName = "id"),
            @JoinColumn(name = "User_name", referencedColumnName = "name")
    })
    private User user;

}
