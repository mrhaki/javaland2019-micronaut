package javaland;

import io.reactivex.Single;

import javax.inject.Singleton;

@Singleton
public class HelloService {
    public Single<String> sayHello(final String name) {
        return Single.just(String.format("Hello %s!", name));
    }
}
