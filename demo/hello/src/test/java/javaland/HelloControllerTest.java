package javaland;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloControllerTest {

    private static EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);
    private static RxHttpClient client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL());

    @BeforeClass
    public static void startServer() {
        server.start();
    }

    @AfterClass
    public static void stopServer() {
        if (server != null) { server.stop(); }
        if (client != null) { client.stop(); }
    }

    @Test
    public void testHello() throws Exception {
        // when:
        String response = client.toBlocking().retrieve("/hello", String.class);
        
        // then:
        assertTrue(response.startsWith("Hello JavaLand"));
    }
}
