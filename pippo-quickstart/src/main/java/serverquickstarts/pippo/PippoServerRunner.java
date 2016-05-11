package serverquickstarts.pippo;

import com.google.inject.Guice;
import ro.pippo.core.Pippo;

public final class PippoServerRunner {

    public static void main(final String... args) {
        final Pippo pippoServer = Guice.createInjector(new PippoServerModule()).getInstance(Pippo.class);
        pippoServer.start();
    }
}
