package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Persistent;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.models.Traveller;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;
import platform.codingnomads.co.springdata.lab.repositories.TravellerRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;
    private final TravellerRepository travellerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if(areaRepository.findAll().isEmpty()) {
            final List<Area> areas = areaRepository.saveAll(
                    Arrays.asList(
                            Area.builder().code("G").build(),
                            Area.builder().code("H").build(),
                            Area.builder().code("Y").build(),
                            Area.builder().code("Z").build(),
                            //new areas
                            Area.builder().code("A").build(),
                            Area.builder().code("B").build(),
                            Area.builder().code("C").build(),
                            Area.builder().code("D").build()
                    )
            );
        }
        if(routeRepository.findAll().isEmpty()) {
            Route route1 = new Route(areaRepository.getByCodeIs("A"), areaRepository.getByCodeIs("B"));
            Route route2 = new Route(areaRepository.getByCodeIs("Y"), areaRepository.getByCodeIs("Z"));
            Route route3 = new Route(areaRepository.getByCodeIs("C"), areaRepository.getByCodeIs("D"));
            List<Route> routes = routeRepository.saveAll(
                    Arrays.asList(
                            route1,
                            route2,
                            route3
                    )
            );
        }
        if(travellerRepository.findAll().isEmpty()){
            final List<Traveller> travellers = travellerRepository.saveAll(
                    Arrays.asList(
                            Traveller.builder()
                                    .name("John Smith")
                                    .home(areaRepository.getByCodeIs("B"))
                                    .currentLocation(areaRepository.getByCodeIs("A"))
                                    .route(routeRepository.findByCode("A-B"))
                                    .build(),
                    Traveller.builder()
                            .name("Sarah Field")
                            .home(areaRepository.getByCodeIs("Z"))
                            .currentLocation(areaRepository.getByCodeIs("Y"))
                            .route(routeRepository.findByCode("Y-Z"))
                            .build(),
                    Traveller.builder()
                            .name("Jack Colby")
                            .home(areaRepository.getByCodeIs("G"))
                            .currentLocation(areaRepository.getByCodeIs("C"))
                            .route(routeRepository.findByCode("C-D"))
                            .build())
            );
        }
        List<Route> routesWithA = routeRepository.getRoutesByOrigin(areaRepository.getByCodeIs("A"));
        List<Route> routesWithB = routeRepository.getRoutesByDestination(areaRepository.getByCodeIs("B"));
        for(Route route : routesWithA){
            System.out.println(route.toString());
        }
        for(Route route : routesWithB){
            System.out.println(route.toString());
        }
        Route CD = routeRepository.findByCode("C-D");
        System.out.println(CD.toString());

        Traveller traveller1 = travellerRepository.findByHome(areaRepository.getByCodeIs("B"));
        Traveller traveller2 = travellerRepository.findByCurrentLocation(areaRepository.getByCodeIs("Y"));
        Traveller traveller3 = travellerRepository.findByRoute(routeRepository.findByCode("C-D"));

        System.out.println(traveller1.toString());
        System.out.println(traveller2.toString());
        System.out.println(traveller3.toString());



    }
}
