package fragments;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {

	List<String> items;
	public FragmentAdapter(FragmentManager fm,List<String> items ) {
		super(fm);
		this.items=items;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return ViewPagerItem.newInstance(items.get(arg0));
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

}
