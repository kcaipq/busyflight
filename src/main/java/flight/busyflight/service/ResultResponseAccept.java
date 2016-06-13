package flight.busyflight.service;

import flight.busyflight.model.BusyFlightResponse;

/**
 * Created by kcai on 13/06/2016.
 */
public interface ResultResponseAccept {

    BusyFlightResponse accept(ResultVisitor visitor);
}
