package serverquickstarts.jaxrs2;

import com.google.inject.Guice;
import com.google.inject.Provider;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

public final class Jaxrs2ServerRunner {

    public static void main(final String... args) throws Exception {
        final Provider<UndertowJaxrsServer> server = Guice.createInjector(new Jaxrs2ServerModule()).getProvider(UndertowJaxrsServer.class);
        server.get();
    }
}
