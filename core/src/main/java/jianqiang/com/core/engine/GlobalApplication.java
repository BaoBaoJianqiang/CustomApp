package jianqiang.com.core.engine;

import android.app.Application;
import android.content.Context;

public class GlobalApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        ProductConfigManager.fetchConfigDataFromXml();
    }

    public static Context getContextObject(){
        return context;
    }
}

