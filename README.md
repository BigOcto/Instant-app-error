## Error 1:

- Code:

```xml
   <style name="phone_download_bottom_ad_popup">
        <item name="@android:windowEnterAnimation">@anim/ad_slide_in_bottom</item>
        <item name="@android:windowExitAnimation">@anim/ad_slide_out_bottom</item>
    </style>
```


- Error info:  

Error:(18, 5) style attribute '@android:attr/windowEnterAnimation' not found
Error:(18, 5) style attribute '@android:attr/windowExitAnimation' not found

## Error 2:

- Code:  

```java
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

```

- Error info:  
    Not found R
    Error:(36, 46) 错误: 找不到符号
    符号:   变量 drawable
    位置: 类 R
