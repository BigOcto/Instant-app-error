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

package com.instantappsamples.feature.bye;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.instantappsamples.base.DebugBaseHelp;


/** Simple activity that says goodbye. */
public class GoodbyeActivity extends AppCompatActivity {
  public static final String PERMISSION_READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
  public static final int PERMISSION_ID_READ_PHONE_STATE = 0;

  public static final String PERMISSION_WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
  public static final int PERMISSION_ID_WRITE_EXTERNAL_STORAGE = 2;

  public static final String PERMISSION_ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
  public static final int PERMISSION_ID_ACCESS_FINE_LOCATION = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    int id = getResources().getIdentifier("activity_goodbye","layout",getApplication().getPackageName());
    Toast.makeText(this,String.valueOf(id),Toast.LENGTH_LONG).show();
    Log.e("getResource","layout getResource result id : " + id);
//    setContentView(R.layout.activity_goodbye);
//    setContentView(id);
    LayoutInflater inflate = LayoutInflater.from(this);
    View view = inflate.inflate(id,null);
    setContentView(view);

    /*Using 'findViewById' get View */
    int goodbye_text2_id = getResources().getIdentifier("goodbye_text2","id",this.getPackageName());
    Log.e("getResource","textView getResource result id : " + goodbye_text2_id);
    TextView goodbye_text2 = (TextView) view.findViewById(goodbye_text2_id);
    goodbye_text2.setText("textView getResource with getIdentifier");

    /* base library drawable*/
    ImageView imageView_library = (ImageView) findViewById(R.id.goodbye_img_left);
    imageView_library.setBackgroundResource(com.google.android.instantapps.samples.feature.base.R.drawable.rockect_create);

    /* base library function*/
    DebugBaseHelp baseHelp = new DebugBaseHelp();
    baseHelp.Debug("this is good bye");

    /* base module drawable*/
    ImageView imageView_base = (ImageView) findViewById(R.id.goodbye_img_right);
    imageView_base.setBackgroundResource(com.google.android.instantapps.samples.feature.base.R.drawable.my_main_news);

    /* base module string value*/
    TextView textView = (TextView) findViewById(R.id.goodbye_text2);
    textView.setText(com.google.android.instantapps.samples.feature.base.R.string.hello_base_module);


    /*Request permission*/
//    checkPermission(PERMISSION_READ_PHONE_STATE,PERMISSION_ID_READ_PHONE_STATE);
    checkPermission(PERMISSION_WRITE_EXTERNAL_STORAGE,PERMISSION_ID_WRITE_EXTERNAL_STORAGE);
  }



  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    if (grantResults.length > 0){
      boolean isGranted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
      Log.d("Permission", "onRequestPermissionsResult : " + isGranted);
    }
  }


  public void checkPermission(String permission, int requestCode) {
    if (!hasSelfPermission(this, permission)) {
      Log.d("Permission", "hasSelfPermission : " + false);
      String[] permisions = {permission};
      ActivityCompat.requestPermissions(this, permisions, requestCode);
    }
  }

  public static boolean hasSelfPermission(Context context, String permission) {
    int hasPermission = context.checkPermission(permission,
            android.os.Process.myPid(), Process.myUid()) ;
    int secondPermission = ContextCompat.checkSelfPermission(context, permission);
    int thirdPermission = PermissionChecker.checkCallingOrSelfPermission(context, permission);
    int fourthPermission = PermissionChecker.checkSelfPermission(context, permission);
    Log.d("Permission", "hasSelfPermission " + permission + ", hasPermission ="
            + hasPermission + ", second=" + secondPermission + ",third=" + thirdPermission + ",fouth=" + fourthPermission);
    return (fourthPermission == PackageManager.PERMISSION_GRANTED);
  }

}
