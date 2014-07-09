package info.adamjsmith.myview;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {
	
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;
	private List<Fragment> getFragments() {
		List<Fragment> fList = new ArrayList<Fragment>();
		
		fList.add(new ViewpointFragment());
		fList.add(new CameraFragment());
		
		return fList;
	}
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayout);
		
		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager(), getFragments());
		mPager.setAdapter(mPagerAdapter);
	}
	
	@Override
	public void onBackPressed() {
		if (mPager.getCurrentItem() == 0) {
			super.onBackPressed();
		} else {
			mPager.setCurrentItem(mPager.getCurrentItem() - 1);
		}
	}
	
	private class FragmentPagerAdapter extends FragmentStatePagerAdapter {
		private List<Fragment> fragments;
		public FragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}
		
		@Override
		public Fragment getItem(int position) {
			return this.fragments.get(position);
		}
		
		@Override
		public int getCount() {
			return this.fragments.size();
		}
	}
}