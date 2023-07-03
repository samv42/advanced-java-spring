package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.models.Traveller;

import java.util.List;

public interface TravellerRepository extends JpaRepository<Traveller,Long> {
    Traveller findByHome(Area home);
    Traveller findByCurrentLocation(Area currentLocation);
    Traveller findByRoute(Route route);
}
