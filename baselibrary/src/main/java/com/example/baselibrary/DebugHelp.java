package com.example.baselibrary;

import android.util.Log;

/**
 * Created by zhangyu on 2017/8/23.
 */

public class DebugHelp {
    public DebugHelp() {
    }

    public void Debug(String str){
        Log.v("InstantDebug", "InstantDebug: "+str);
    }
}
