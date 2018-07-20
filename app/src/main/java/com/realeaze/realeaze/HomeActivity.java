package com.realeaze.realeaze;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.realeaze.realeaze.fragments.ClientFragment;
import com.realeaze.realeaze.fragments.DetailFragment;
import com.realeaze.realeaze.fragments.HomeFragment;
import com.realeaze.realeaze.fragments.MapFragment;
import com.realeaze.realeaze.fragments.ProgressFragment;
import com.realeaze.realeaze.fragments.SearchResultFragment;
import com.realeaze.realeaze.utils.TagSpan;

public class HomeActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
ArrayList<String> arr= new ArrayList<>();
    BottomNavigationMenuView menuView;
    TextView app_n;
    @SuppressLint("RestrictedApi")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
       // app_n = (TextView) findViewById(R.id.app_n);
      //  Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf");
        //app_n.setTypeface(typeface);
        final ProgressFragment progressFragment = new ProgressFragment();
        final DetailFragment detailFragment = new DetailFragment();
        final MapFragment homeFragment = new MapFragment();
        final ClientFragment clientFragment = new ClientFragment();
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new SearchResultFragment()).commit();
        menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);
           arr.add("Search");
           arr.add("Progress");
           arr.add("Home");
           arr.add("Projects");
           arr.add("Clients");
        for (int i = 0; i < menuView.getChildCount(); i++) {
            BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(i);
            itemView.setShiftingMode(false);
            itemView.setChecked(false);
        }
// navigation listner
        bottomNavigationView
        .setOnNavigationItemSelectedListener(new
     BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
         public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                  switch (item.getItemId()){
                    case R.id.nav_search :
                        startActivity(new Intent(getApplicationContext(), Main2Activity.class));

                     // getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new  SearchResultFragment()).commit();
                        SpannableString content = new SpannableString("Search");
                        content.setSpan(new UnderlineSpan(), 0, 6, 0);
                        item.setTitle(content);
                        invalidateChoice(0);
                        //String styledText = "<u><font color='red'>Underline Text</font></u>.";
                       //  item.setTitle((Html.fromHtml(styledText), TextView.BufferType.SPANNABLE));
                         return true;
                      case R.id.nav_progress :
                          getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, progressFragment).commit();

                          SpannableString content1 = new SpannableString("Progress");
                          //SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
                          content1.setSpan(new UnderlineSpan(), 0, 8, 0);
                         // stringBuilder.append(content1);
                         // stringBuilder.setSpan(new TagSpan(getResources().getColor(R.color.colorPrimary), getResources().getColor(R.color.colorPrimary)), stringBuilder.length() , stringBuilder.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                          invalidateChoice(1);
                          item.setTitle(content1);

                          return true;
                      case R.id.nav_home :

                          SpannableString content2 = new SpannableString("Home");
                          content2.setSpan(new UnderlineSpan(), 0, 4, 0);
                          item.setTitle(content2);
                          invalidateChoice(2);
                          getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, detailFragment).commit();

                          return true;
                      case R.id.nav_Projects:

                         getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,homeFragment).commit();
                       //   getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
                         // expe


                          SpannableString content3 = new SpannableString("Projects");
                          content3.setSpan(new UnderlineSpan(), 0, 8, 0);
                          item.setTitle(content3);
                          invalidateChoice(3);

                          return true;
                      case R.id.nav_Clients:
                          //bottomNavigationView.invalidate();

                          SpannableString content4 = new SpannableString("Clients");
                          content4.setSpan(new UnderlineSpan(), 0, 7, 0);
                          item.setTitle(content4);
                          invalidateChoice(4);
                         getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, clientFragment).commit();

                          return true;
                      }
                     return false;
                     }
                     });

    }

    private void invalidateChoice(int i) {
       Menu menu = bottomNavigationView.getMenu();

        for(int o=0;o<menu.size();o++)
        {
            if(o!=i){
                SpannableString content = new SpannableString(arr.get(o));
                content.setSpan(new UnderlineSpan(), 0, 0, 0);
                menu.getItem(o).setTitle(content);
            }
        }
    }


    public static class BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    public static  void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}
}