package serverquickstarts.jaxrs2;

import com.google.common.collect.Sets;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/")
public class Jaxrs2Application extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Sets.newHashSet(HelloResource.class);
    }
}
