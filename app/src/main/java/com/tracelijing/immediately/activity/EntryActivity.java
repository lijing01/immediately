package com.tracelijing.immediately.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.tracelijing.immediately.R;
import com.tracelijing.immediately.fragment.ExploreFragment;
import com.tracelijing.immediately.fragment.MeFragment;
import com.tracelijing.immediately.fragment.MessagesFragment;
import com.tracelijing.immediately.utils.BaseFragment;
import com.tracelijing.tlibrary.ViewUtil;

import java.util.ArrayList;
import java.util.List;

public class EntryActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

	private ViewPager viewPager;
	private BottomBar mBottomBar;
	private Toolbar toolbar;


	private ArrayList<BaseFragment> fragments = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		mBottomBar = BottomBar.attach(this, savedInstanceState);
		mBottomBar.setItems(R.menu.bottombar_menu_three_items);
		mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
		mBottomBar.setActiveTabColor(R.color.dark_gray);

		viewPager = ViewUtil.$(this, R.id.viewPager);
		init();
		TabPageAdapter tabPageAdapter = new TabPageAdapter(
				getSupportFragmentManager(), fragments);
		viewPager.setAdapter(tabPageAdapter);
		viewPager.addOnPageChangeListener(this);
		mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
			@Override
			public void onMenuTabSelected(@IdRes int menuItemId) {
				switch (menuItemId) {
					case R.id.bb_menu_explore:
						selectView(0);
						break;
					case R.id.bb_menu_message:
						selectView(1);
						break;
					case R.id.bb_menu_me:
						selectView(2);
						break;
				}
			}

			@Override
			public void onMenuTabReSelected(@IdRes int menuItemId) {

			}
		});
		selectView(1);
	}

	private void selectView(int position) {
		// 切换页面
		viewPager.setCurrentItem(position, false);
		mBottomBar.selectTabAtPosition(position, true);
		switch (position) {
			case 0:
				toolbar.setTitle("发现");
				break;
			case 1:
				toolbar.setTitle("消息");
				break;
			case 2:
				toolbar.setTitle("我的");
				break;
		}
	}

	protected void init() {
		BaseFragment findArticleFragment = new ExploreFragment();
		BaseFragment myMessageFragment = new MessagesFragment();
		BaseFragment hotMessageFragment = new MeFragment();
		fragments.add(findArticleFragment);
		fragments.add(myMessageFragment);
		fragments.add(hotMessageFragment);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_entry, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		// Necessary to restore the BottomBar's state, otherwise we would
		// lose the current tab on orientation change.
		mBottomBar.onSaveInstanceState(outState);
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		selectView(position);
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}


	public class TabPageAdapter extends FragmentPagerAdapter {

		private List<BaseFragment> fragments;

		public TabPageAdapter(FragmentManager fm, List<BaseFragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}

		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

		/**
		 * 重写，不让Fragment销毁
		 */
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

		}
	}
}
