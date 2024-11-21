package platform.codingnomads.co.springdata.lab.models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "travellers")
@Builder
@ToString
public class Traveller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "home_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_travellers_home_area_id")
    )
    private Area home;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "currentlocation_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_travellers_currentlocation_area_id")
    )
    private Area currentLocation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "route_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_travellers_route_route_id")
    )
    private Route route;
}
