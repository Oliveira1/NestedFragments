package fragments;
import java.util.LinkedList;
import java.util.List;

import proto.eggon.mobile.testpatterns.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class fragmentActivityChild extends Fragment implements SendData {


	private Fragment f;
	private List<String> itemsList=new LinkedList<String>();
	private ViewPager mPager;
	private PagerAdapter mAdapter;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mAdapter=new FragmentAdapter(getChildFragmentManager(),itemsList);
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragact, container,false);
		mPager=(ViewPager)v.findViewById(R.id.verticalvp);
		mPager.setAdapter(mAdapter);
		if (f==null){
			f=new ListFragment();
		}
		getFragmentManager().beginTransaction().replace(R.id.leftpane, f).commit();
		return v;
	}


	@Override
	public void sendData(List<String> itemsList) {
		this.itemsList = itemsList;


	}

}
