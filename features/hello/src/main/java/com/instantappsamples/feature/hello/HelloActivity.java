/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.instantappsamples.feature.hello;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baselibrary.DebugHelp;

/**
 * This Activity displays a simple hello world text.
 */
public class HelloActivity extends AppCompatActivity {

    private Dialog mCommonDialog;
    private String dialogTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        DebugHelp debugHelp = new DebugHelp();
        debugHelp.Debug("hello activity onCreate");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://hello-feature.instantappsample.com/goodbye"));
                intent.setPackage(getPackageName());
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(intent);
            }
        });

        findViewById(R.id.image).setBackgroundResource(R.drawable.rockect_create);

        showBuild5gWifiDialog(this, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        },"hello world");

//        int id = getResources().getIdentifier("activity_goodbye","layout",getApplication().getPackageName());
//        Toast.makeText(this,String.valueOf(id),Toast.LENGTH_LONG).show();
//        Log.e("getResource","getResource result id : " + id);
    }


    public void showBuild5gWifiDialog(final Activity activity, View.OnClickListener onClickListener, String dialogTag) {
        if (mCommonDialog == null) {
            mCommonDialog = new Dialog(activity, R.style.custom_dialog_style);
        }
        this.dialogTag = dialogTag;
        mCommonDialog.setCanceledOnTouchOutside(true);
        mCommonDialog.setCancelable(true);
        mCommonDialog.show();
        mCommonDialog.setContentView(R.layout.build_5g_wifi_dialog_view);
        TextView titleView = (TextView) mCommonDialog.findViewById(R.id.wifi_5g_dialog_title);
        TextView create5gButton = (TextView) mCommonDialog.findViewById(R.id.wifi_5g_create_button);
        String title = activity.getString(R.string.build_5g_wifi_title);
        title = activity.getString(R.string.hello_base_module);
        SpannableString sp = new SpannableString(title);
        ForegroundColorSpan span = new ForegroundColorSpan(0Xffff8533);
        sp.setSpan(span, title.length()-2, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        titleView.setText(sp);
        titleView.setAllCaps(false);
        create5gButton.setOnClickListener(onClickListener);
        WindowManager.LayoutParams params = mCommonDialog.getWindow()
                .getAttributes();
        DisplayMetrics dm = activity.getResources().getDisplayMetrics();
        params.width = dm.widthPixels - 50 * 2;
        params.x = 0; // 新位置X坐标
        params.y = -100; // 新位置Y坐标
        mCommonDialog.getWindow().setAttributes(params);

    }
}
