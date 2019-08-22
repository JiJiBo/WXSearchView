package com.jxkj.bbccode.wxsearchview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by hp on 2017/11/11.
 */

public class SearchActivity extends AppCompatActivity {
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        //toolbar.setTitle("搜索");
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_searchview, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchView=(SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setIconified(true);
        searchView.setIconifiedByDefault(false);
        //设置最右侧的提交按钮
        searchView.setSubmitButtonEnabled(true);
        searchView.setInputType(1);// .setImeOptions(SearchView.);
        //展开SearchView
        searchItem.expandActionView();
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(SearchActivity.this, "案秀云Expand!", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                finish();
                overridePendingTransition(R.anim.slide_bottom_in, R.anim.slide_bottom_out);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
