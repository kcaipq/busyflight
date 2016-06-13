package flight.busyflight.service;

import flight.busyflight.model.BusyFlightRequest;
import flight.busyflight.model.BusyFlightResponse;
import flight.busyflight.model.BusyFlightResponseVisitor;
import flight.busyflight.provider.model.*;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by kcai on 13/06/2016.
 */
public class SearchWork implements Callable<List<BusyFlightResponse>> {

    private DateFormat df = new SimpleDateFormat("mm-DD-yyyy HH:MM:ss");
    private RestTemplate restTemplate = new RestTemplate();
    private final Provider provider;
    private final BusyFlightRequest request;
    private ResultVisitor visitor = new BusyFlightResponseVisitor();
    private ProviderRequestBuilder builder = new ProviderRequestBuilder();

    private final String url;
    public SearchWork(String url, BusyFlightRequest request, Provider provider) {
        this.url = url;
        this.request = request;
        this.provider = provider;
    }

    public String getUrl() {
        return this.url;
    }

    public List<BusyFlightResponse> call() throws Exception {
        //TODO refactor using switch
        //TODO use decorate pattern here to decorate ToughJetResponse with departureDate from the one in the request object
        if (provider == Provider.crazyair) {
            CrazyAirResponse[] resp = restTemplate.postForObject(getUrl(), builder.build(provider, request), CrazyAirResponse[].class);

            // TODO move it to a private method to reduce duplicated code
            List<BusyFlightResponse> res = new ArrayList<>();
            for (CrazyAirResponse t : resp) {
                res.add(t.accept(visitor));
            }
            return res;
        } else if (provider == Provider.toughjet) {
            ToughJetResponse[] resp = restTemplate.postForObject(getUrl(), builder.build(provider, request), ToughJetResponse[].class);
            List<BusyFlightResponse> res = new ArrayList<>();
            for (ToughJetResponse t : resp) {
                t.setDepartureDate(df.format(request.getDepartureDate()));
                t.setArrivalDate(df.format(request.getReturnDate()));
                res.add(t.accept(visitor));
            }
            return res;
        } else {
            // default empty result
            return new ArrayList();
        }
    }
}
