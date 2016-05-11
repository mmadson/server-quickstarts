import com.google.inject.Guice;
import jodd.http.HttpRequest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ro.pippo.core.Pippo;
import serverquickstarts.pippo.PippoServerModule;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class PippoServerTest {

    private static Future<?> serverTask;

    @BeforeClass
    public static void setUp() throws Exception {
        serverTask = Executors.newSingleThreadExecutor().submit(() -> {
            Guice.createInjector(new PippoServerModule()).getInstance(Pippo.class).start();
        });
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        serverTask.cancel(true);
    }

    @Test
    public void whenHttpGetHelloResource_thenReturnPlaintextMessage() throws Exception {
        Assert.assertEquals("Hello World!", HttpRequest.get("http://localhost:8338/hello").send().body());
    }
}
