package serverquickstarts.pippo;

import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import ro.pippo.core.Pippo;

public final class PippoServerModule extends PrivateModule {


    @Override
    protected void configure() {
        expose(Pippo.class);
    }

    @Provides
    Pippo providePippoServer(final PippoApplication application) {
        return new Pippo(application);
    }
}
