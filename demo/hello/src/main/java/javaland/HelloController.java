package javaland;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Single;

@Controller("/hello")
public class HelloController {
    
    private final HelloService helloService;

    public HelloController(final HelloService helloService) {this.helloService = helloService;}

    @Get(value = "/", produces = MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello JavaLand! " + Thread.currentThread().getName();
    }

    @Get(value = "/reactive", produces = MediaType.TEXT_PLAIN)
    public Single<String> helloReactive() {
        return Single.just("Hello Javaland " + Thread.currentThread().getName());
    }
    
    @Get("/message")
    public Single<Message> helloMessage() {
        return Single.just(new Message("Hello Javaland 2019!"));
    }
    
    @Get("/{name}")
    public Single<Message> sayHello(final String name) {
        return helloService.sayHello(name).map(message -> new Message(message));
    }
}
