package flight.busyflight.provider.controller;

import flight.busyflight.provider.model.AbstractProviderResponse;
import flight.busyflight.provider.model.Provider;

import java.util.List;

/**
 * Created by kcai on 13/06/2016.
 */
public class ProviderFactory {

    private InMemoryProviderFactory f = new InMemoryProviderFactory();

    public List<AbstractProviderResponse> build(Provider provider) {
        switch (provider) {
            case crazyair: return f.results.get(Provider.crazyair);
            case toughjet: return f.results.get(Provider.toughjet);
            default: throw new IllegalArgumentException("Illegal airline");
        }

    }
}
