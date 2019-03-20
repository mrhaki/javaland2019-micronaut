package javaland;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GatewayController {
    
    private final ConferenceClient conferenceClient;

    public GatewayController(final ConferenceClient conferenceClient) {
        this.conferenceClient = conferenceClient;
    }

    @Get("/gateway")
    public Single<List<String>> names() {
        return conferenceClient.getConferences().map(this::convertConferences);
    }

    private List<String> convertConferences(List<Conference> conferences) {
        return conferences.stream()
                          .map(conf -> conf.getName().toUpperCase())
                          .collect(Collectors.toList());
    }
}
