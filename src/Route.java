import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Route {

    int total_stops_to_share_all_the_gossips = 0;


    Set<BusDriver> m_drivers_in_the_route = new HashSet<>();
    Route(BusDriver... drivers) {

        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

    }



}
