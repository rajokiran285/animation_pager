package com.example.animation_pager;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tab=findViewById(R.id.tab);
        pager=findViewById(R.id.pager);

        tab.addTab(tab.newTab().setText("one"));
        tab.addTab(tab.newTab().setText("two"));
        tab.addTab(tab.newTab().setText("three"));
        tab.addTab(tab.newTab().setText("four"));

        Adap adp=new Adap(this,getSupportFragmentManager(),tab.getTabCount());
        pager.setAdapter(adp);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }


    class Adap extends FragmentPagerAdapter
    {
        Context myContext;
        int totaltabs;

        public Adap(Context context, FragmentManager fm, int totaltabs) {
            super(fm);
            myContext=context;
            this.totaltabs=totaltabs;

        }

        @Override
        public Fragment getItem(int position)
        {
            switch ( position)
            {
                case 0: {
                    one One = new one();
                    return One;
                }
                case 1:
                {
                    two Two=new two();
                    return Two;
                }
                case 2:
                {
                    three Three=new three();
                    return Three;
                }
                case 3:
                {
                    four Four=new four();
                    return Four;
                }
                default:
                    return null;
            }


        }

        @Override
        public int getCount() {
            return totaltabs;
        }
    }


}
