package flight.busyflight.service;

import flight.busyflight.model.BusyFlightRequest;
import flight.busyflight.model.BusyFlightResponse;
import flight.busyflight.provider.model.Provider;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/**
 * Created by kcai on 13/06/2016.
 */
public class SearchTask {

    final private SearchWork work;
    final private FutureTask<List<BusyFlightResponse>> task;
    public SearchTask(String url, BusyFlightRequest request, Provider provider, Executor executor) {
        this.work = new SearchWork(url, request, provider);
        this.task = new FutureTask<List<BusyFlightResponse>>(work);
        executor.execute(this.task);
    }

    public boolean isDone() {
        return this.task.isDone();
    }

    public List<BusyFlightResponse> getResponse() {
        try {
            return this.task.get();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
