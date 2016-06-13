package flight.busyflight.controller;

import flight.busyflight.model.BusyFlightRequest;
import flight.busyflight.model.BusyFlightResponse;
import flight.busyflight.provider.model.Provider;
import flight.busyflight.service.SearchTask;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by kcai on 13/06/2016.
 */
@RestController
@RequestMapping("/search")
public class BusyFlightController {

    //TODO inject this instance
    private Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<List<BusyFlightResponse>> post(@RequestBody BusyFlightRequest req) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        List<SearchTask> tasks = new ArrayList<>();
        List<BusyFlightResponse> resps = new ArrayList<>();

        //TODO move constants into configuration file
        tasks.add(new SearchTask("http://localhost:8080/provider/crazyair", req, Provider.crazyair, this.executor));
        tasks.add(new SearchTask("http://localhost:8080/provider/toughjet", req, Provider.toughjet, this.executor));


        //TODO move this vode in to a service to reduce coupling
        while(!tasks.isEmpty()) {
            for(Iterator<SearchTask> it = tasks.iterator(); it.hasNext();) {
                SearchTask task = it.next();
                if(task.isDone()) {
                    List<BusyFlightResponse> response = task.getResponse();
                    resps.addAll(response);
                    it.remove();
                }
            }
        }
        Collections.sort(resps);
        return new ResponseEntity<>(resps, responseHeaders, HttpStatus.OK);
    }
}
