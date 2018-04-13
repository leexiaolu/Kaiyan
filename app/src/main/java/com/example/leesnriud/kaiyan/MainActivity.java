package com.example.leesnriud.kaiyan;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

/**
 * CollapsingToolbarLayout 属性说明
 * collapsedTitleTextAppearance：指定toolbar收缩时，标题字体的样式，类似的还有expandedTitleTextAppearance。
 * contentScrim：当Toolbar收缩到一定程度时的所展现的主体颜色。即Toolbar的颜色。
 * expandedTitleMarginEnd 展开状态改变标题文字的位置，通过margin设置
 * expandedTitleMarginStart
 * expandedTitleTextAppearance 指定展开状态标题文字的样子
 * layout_scrollFlags 子布局通过该属性设置可否滑动
 * layout_collapseParallaxMultiplier 设置视差系数 0.0~1.0
 * layout_collapseMode 子布局设置折叠样式 有两种“pin”：固定模式，在折叠的时候最后固定在顶端；“parallax”：视差模式，在折叠的时候会有个视差折叠的效果。
 *
 */
public class MainActivity extends AppCompatActivity {

    private LinearLayout head_layout;
    private TabLayout toolbar_tab;
    private ViewPager main_vp_container;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private CoordinatorLayout coordinator_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppBarLayout app_bar_layout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        //左上角箭头
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //左上角箭头退出
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        head_layout = (LinearLayout) findViewById(R.id.head_layout);
        coordinator_layout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id
                .collapsing_toolbar_layout);

        //判断滑动到了什么位置
        app_bar_layout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -head_layout.getHeight() / 2) {
                    mCollapsingToolbarLayout.setTitle("开眼音乐精选");
                } else {
                    mCollapsingToolbarLayout.setTitle(" ");
                }
            }
        });

        toolbar_tab = (TabLayout) findViewById(R.id.toolbar_tab);
        main_vp_container = (ViewPager) findViewById(R.id.main_vp_container);

        //实例化适配器 如果加载fragment较多使用fragmentstatepageradapter
        //fragmentpageradapter适用于加载页面少 特点是不回收
        //fragmentstatepageradapter适用于加载页面多 可以真正释放
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        main_vp_container.setAdapter(vpAdapter);

        //设置改变监听
        main_vp_container.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
                (toolbar_tab));

        //设置选择监听
        toolbar_tab.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener
                (main_vp_container));
    }

}
