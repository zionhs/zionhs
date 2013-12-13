package com.licubeclub.zionhs;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class Tutorial extends ActionBarActivity {

    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(new PagerAdapterClass(getApplicationContext()));
    }

    @SuppressWarnings("unused")
    private void setCurrentInflateItem(int type){
        if(type==0){
            mPager.setCurrentItem(0);
        }else if(type==1){
            mPager.setCurrentItem(1);
        }
        else{
            mPager.setCurrentItem(2);
        }
    }
    /**
     * PagerAdapter
     */
    private class PagerAdapterClass extends PagerAdapter {

        private LayoutInflater mInflater;
        public PagerAdapterClass(Context c){
            super();
            mInflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return 5;
        }


        @Override
        public Object instantiateItem(View pager, int position) {
            View v = null;
            if(position == 0){
                v = mInflater.inflate(R.layout.tutorial_0, null);
            }
            else if(position == 1){
                v = mInflater.inflate(R.layout.tutorial_1, null);
            }
            else if(position == 2){
                v = mInflater.inflate(R.layout.tutorial_2, null);
            }
            else if(position == 3){
                v = mInflater.inflate(R.layout.tutorial_3, null);
            }
            else{
                v = mInflater.inflate(R.layout.tutorial_4, null);
            }
            ((ViewPager)pager).addView(v, 0);
            return v;
        }
        @Override
        public void destroyItem(View pager, int position, Object view){
            ((ViewPager)pager).removeView((View)view);
        }

        @Override
        public boolean isViewFromObject(View pager, Object obj){
            return pager == obj;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return getString(R.string.tutorial_0);
            }
            else if(position == 1){
                return getString(R.string.tutorial_1);
            }
            else if(position == 2){
                return getString(R.string.tutorial_2);
            }
            else if(position == 3){
                return getString(R.string.tutorial_3);
            }
            else{
                return getString(R.string.tutorial_4);
            }
        }
    }


}