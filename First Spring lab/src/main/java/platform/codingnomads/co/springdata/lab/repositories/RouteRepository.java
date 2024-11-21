package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {
    List<Route> getRoutesByOrigin(Area origin);
    List<Route> getRoutesByDestination(Area destination);
    Route findByCode (String code);
}
