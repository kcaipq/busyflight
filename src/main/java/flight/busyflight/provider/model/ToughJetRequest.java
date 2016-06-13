package flight.busyflight.provider.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by kcai on 13/06/2016.
 */
public class ToughJetRequest extends AbstractProviderRequest {


    @JsonProperty("from")
    @Override
    public void setOrigin(String origin) {
        super.setOrigin(origin);
    }

    @JsonProperty("to")
    @Override
    public void setDestination(String destination) {
        super.setDestination(destination);
    }
}
