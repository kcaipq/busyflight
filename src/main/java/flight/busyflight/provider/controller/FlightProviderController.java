package flight.busyflight.provider.controller;

import flight.busyflight.provider.model.Provider;
import flight.busyflight.provider.model.ToughJetRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kcai on 13/06/2016.
 */
@RestController
@RequestMapping("/provider")
public class FlightProviderController {

    //TODO inject it
    private ProviderFactory repo = new ProviderFactory();

    //TODO use AspectJ to log
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightProviderController.class);

    @RequestMapping(value = "/{provider}",
            method = RequestMethod.POST,
            produces = {"application/json"})
    @ResponseBody
    public ResponseEntity post(@PathVariable("provider") Provider provider, @RequestBody ToughJetRequest req) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<>(repo.build(provider), responseHeaders, HttpStatus.OK);
    }
}
