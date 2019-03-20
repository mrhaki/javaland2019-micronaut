package javaland;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

import java.util.List;

@Client(id = "conference")
public interface ConferenceClient extends ConferenceOperations {
    
    @Get("/conferences")
    Single<List<Conference>> getConferences(); 
}
