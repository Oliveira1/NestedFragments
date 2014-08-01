package fragments;


import proto.eggon.mobile.testpatterns.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewPagerItem extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		String text=(String) getArguments().get("value");
		View v=inflater.inflate(R.layout.view_pager_item, container,false);
		TextView tv=(TextView)v.findViewById(R.id.viewpagertext);
		tv.setText(text);
		
		return v;
	}
	public static Fragment newInstance(String item){
		Fragment j=new ViewPagerItem();
		Bundle b=new Bundle();

		b.putString("value", item);
		j.setArguments(b);
		return j;
	}
}
