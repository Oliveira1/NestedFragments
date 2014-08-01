package fragments;

import java.util.LinkedList;
import java.util.List;

import proto.eggon.mobile.testpatterns.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;



public class Mother extends FragmentActivity {


	private FragmentManager mFm;
	private Fragment fragAct;
	private Fragment frag;
	private boolean flag=true;
	private List<String> itemsList=new LinkedList<String>();
	@Override
	protected void onCreate(Bundle arg0) {
		itemsList.add("this");
		itemsList.add("is");
		itemsList.add("a");
		itemsList.add("test");
		itemsList.add("to");
		itemsList.add("try");
		itemsList.add("and");
		itemsList.add("save");
		itemsList.add("state");
		super.onCreate(arg0);
		setContentView(R.layout.mother);
		mFm=getSupportFragmentManager();
		fragAct = new fragmentActivityChild();
		frag=new FragmentChild();	
		FragmentTransaction fragmentTransaction = mFm.beginTransaction();
		fragmentTransaction.replace(R.id.container,fragAct);
		//fragmentTransaction.addToBackStack("main");
		fragmentTransaction.commit();
		((fragmentActivityChild) fragAct).sendData(itemsList);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		Log.d("MAP","on create called...");
		inflater.inflate(R.menu.quickactions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_map:
			if(flag){
			FragmentTransaction fragmentTransaction = mFm.beginTransaction();
			fragmentTransaction.add(R.id.container,frag);
			fragmentTransaction.addToBackStack("map");
			fragmentTransaction.commit();
			flag=false;
			}
			else{

//				FragmentTransaction fragmentTransaction = mFm.beginTransaction();
//				fragmentTransaction.add(R.id.container,fragAct);
//				//fragmentTransaction.addToBackStack("map");
//				fragmentTransaction.commit();
				mFm.popBackStack("map",mFm.POP_BACK_STACK_INCLUSIVE);
//				FragmentTransaction fragmentTransaction = mFm.beginTransaction();
//				fragmentTransaction.add(R.id.container,frag);
//				fragmentTransaction.addToBackStack("map");
//				fragmentTransaction.commit();
				flag=true;

				
			}

			return true;
		}
		return false;
	}

}
