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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.instantappsamples.base.DebugBaseHelp;


/** Simple activity that says goodbye. */
public class GoodbyeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_goodbye);
    /* base library drawable*/
    ImageView imageView_library = (ImageView) findViewById(R.id.goodbye_img_left);
    imageView_library.setBackgroundResource(R.drawable.rockect_create);

    /* base library function*/
    DebugBaseHelp baseHelp = new DebugBaseHelp();
    baseHelp.Debug("this is good bye");

    /* base module drawable*/
    ImageView imageView_base = (ImageView) findViewById(R.id.goodbye_img_right);
    imageView_base.setBackgroundResource(R.drawable.my_main_news);

    /* base module string value*/
    TextView textView = (TextView) findViewById(R.id.goodbye_text2);
    textView.setText(R.string.hello_base_module);
  }
}
