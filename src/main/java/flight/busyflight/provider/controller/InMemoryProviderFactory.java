package flight.busyflight.provider.controller;

import flight.busyflight.provider.model.CrazyAirResponse;
import flight.busyflight.provider.model.Provider;
import flight.busyflight.provider.model.ToughJetResponse;

import java.util.*;

/**
 * Created by kcai on 13/06/2016.
 */
public final class InMemoryProviderFactory {

    public final Map<Provider, List> results = new HashMap<>();

    {
        List<CrazyAirResponse> cr = new ArrayList<>();
        cr.add(new CrazyAirResponse("KLM", 100.00, "E", "LHR", "BJR", new Date(), new Date()));
        cr.add(new CrazyAirResponse("KLM", 101.00, "E", "LHR", "EEE", new Date(), new Date()));
        cr.add(new CrazyAirResponse("KLM", 102.00, "E", "LHR", "RRR", new Date(), new Date()));
        cr.add(new CrazyAirResponse("KLM", 103.00, "E", "LHR", "TTT", new Date(), new Date()));

        List<ToughJetResponse> tr = new ArrayList<>();
        tr.add(new ToughJetResponse("KLM", 99.00, 20.00, 0.00, "LHR", "BJR"));
        tr.add(new ToughJetResponse("KLM", 98.00, 20.00, 0.00, "LHR", "EEE"));
        tr.add(new ToughJetResponse("KLM", 97.00, 20.00, 0.00, "LHR", "RRR"));
        tr.add(new ToughJetResponse("KLM", 96.00, 20.00, 0.00, "LHR", "TTT"));

        results.put(Provider.crazyair, cr);
        results.put(Provider.toughjet, tr);
    }
}
