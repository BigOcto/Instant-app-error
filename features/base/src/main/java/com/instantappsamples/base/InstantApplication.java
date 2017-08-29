package com.instantappsamples.base;

import android.app.Application;
import android.util.Log;

//import com.example.baselibrary.DebugHelp;


/**
 * Created by zhangyu on 2017/8/22.
 */

public class InstantApplication extends Application {
    public InstantApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("Instant", "InstantApplication onCreate");

//        DebugHelp debugHelp = new DebugHelp();
//        debugHelp.Debug("This is base module");
    }

}
