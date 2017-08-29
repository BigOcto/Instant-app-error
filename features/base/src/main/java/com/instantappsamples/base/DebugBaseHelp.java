package com.instantappsamples.base;

import android.util.Log;

/**
 * Created by zhangyu on 2017/8/23.
 */

public class DebugBaseHelp {
    public DebugBaseHelp() {
    }

    public void Debug(String str){
        Log.v("InstantDebug", "InstantDebug: "+str);
    }
}
