package serverquickstarts.pippo;


import ro.pippo.core.Application;

import javax.inject.Inject;

final class PippoApplication extends Application {

    @Inject
    public PippoApplication() {
    }

    @Override
    protected void onInit() {
        super.onInit();

        GET("/hello", (ctx) -> ctx.send("Hello World!"));
    }


}
