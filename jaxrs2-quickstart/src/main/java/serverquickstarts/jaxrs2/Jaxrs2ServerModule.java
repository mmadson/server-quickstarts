package serverquickstarts.jaxrs2;

import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import io.undertow.Undertow;
import org.aeonbits.owner.ConfigFactory;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import javax.inject.Singleton;

public final class Jaxrs2ServerModule extends PrivateModule {

    @Override
    protected void configure() {
        expose(UndertowJaxrsServer.class);
    }

    @Provides
    @Singleton
    ServerConfiguration provideServerConfiguration() {
        return ConfigFactory.create(ServerConfiguration.class, System.getProperties(), System.getenv());
    }

    @Provides
    @Singleton
    UndertowJaxrsServer provideJaxrsServer(final ServerConfiguration configuration) {
        final UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.deploy(Jaxrs2Application.class);
        server.start(Undertow.builder().addHttpListener(configuration.port(), "localhost"));
        return server;
    }
}
