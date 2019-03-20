package javaland;

import io.micronaut.retry.annotation.Fallback;
import io.reactivex.Single;

import java.util.List;

@Fallback
public class ConferenceFallback implements ConferenceOperations {

    public Single<List<Conference>> getConferences() {
        return Single.just(List.of(new Conference("JAVALAND 2019")));
    }
}
