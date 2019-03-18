import java.util.*;

class Route {

    int total_stops_to_share_all_the_gossips = 0, minutes = 480;

    private List<BusDriver> m_drivers_in_the_route = new ArrayList<>();
    public Set<Integer> m_actual_stops = new HashSet<>();
    public List<BusDriver> m_drivers_on_the_same_stop = new ArrayList<>();
    public Set<Character> m_gossips_collected = new HashSet<>();

    Route(BusDriver... drivers)
    {
        m_drivers_in_the_route.addAll(Arrays.asList(drivers));

        // for(int i = 0; i < minutes; i++)
        // {
            GetActualRepeatedStops();

            GetDriversOnTheSameActualStop();

            CollectGossips();

            ExchangeGossips();



            /*
            if(AreAllTheGossipsShared())
            {
                break;
                // End of the program
            }
            */

            total_stops_to_share_all_the_gossips++;

            if(total_stops_to_share_all_the_gossips == minutes)
            {
                // end of the program
            }

            AllDriversGoToTheNextStop();
       // }
    }

    private void AllDriversGoToTheNextStop()
    {
        for(BusDriver driver : m_drivers_in_the_route)
        {
            driver.NextStop();
        }
    }

    private void GetDriversOnTheSameActualStop() {
        for (Integer stop : m_actual_stops)
        {
            for(BusDriver driver : m_drivers_in_the_route)
            {
                if(driver.ActualStop().equals(stop))
                {
                    m_drivers_on_the_same_stop.add(driver);
                }
            }
        }
    }

    private void ExchangeGossips() {
        for(BusDriver driver : m_drivers_on_the_same_stop)
        {
            driver.m_gossips.addAll(m_gossips_collected);
        }
    }

    private void CollectGossips()
    {
        if(m_drivers_on_the_same_stop.size() < 2)
        {
            return;
        }

        for(BusDriver driver : m_drivers_on_the_same_stop)
        {
            m_gossips_collected.addAll(driver.m_gossips);
        }
    }

    private void GetActualRepeatedStops()
    {
        Set<Integer> stops = new HashSet<>();

        for(BusDriver driver : m_drivers_in_the_route)
        {
            if(!stops.add(driver.ActualStop()))
            {
                m_actual_stops.add(driver.ActualStop());
            }
        }
    }
}