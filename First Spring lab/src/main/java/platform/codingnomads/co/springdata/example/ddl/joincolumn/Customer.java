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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)

    @JoinColumns({
            @JoinColumn(name = "User_id", referencedColumnName = "id",nullable = false),
            @JoinColumn(name = "User_name", referencedColumnName = "name", nullable = false)
    })
    private User user;

}
