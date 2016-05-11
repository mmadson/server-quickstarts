import com.google.inject.Guice;
import jodd.http.HttpRequest;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import serverquickstarts.jaxrs2.Jaxrs2ServerModule;

public class Jaxrs2ServerTest {

    private static UndertowJaxrsServer server;

    @BeforeClass
    public static void setUp() {
        server = Guice.createInjector(new Jaxrs2ServerModule()).getProvider(UndertowJaxrsServer.class).get();

    }

    @AfterClass
    public static void tearDown() {
        server.stop();
    }

    @Test
    public void whenHttpGetHelloResource_thenReturnPlaintextMessage() throws Exception {
        Assert.assertEquals("Hello World!!!", HttpRequest.get("http://localhost:8080/hello").send().body());
    }
}
