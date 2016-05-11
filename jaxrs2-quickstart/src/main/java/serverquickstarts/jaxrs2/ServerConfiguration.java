package serverquickstarts.jaxrs2;

import org.aeonbits.owner.Config;


public interface ServerConfiguration extends Config {

    @Key("server.http.port")
    @DefaultValue(value = "8080")
    int port();
}
