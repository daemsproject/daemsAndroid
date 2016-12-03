package net.fai.daems.fragment;

import java.util.ArrayList;
import java.util.List;

import net.fai.daems.R;
import net.fai.daems.adapter.MeAdapter;
import net.fai.daems.adapter.item.MeItem;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MeFragment extends Fragment{
	private Context context;
    private ListView lvMe;
    

    public MeFragment(Context context){
       this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment,container,false);
        lvMe = (ListView)view.findViewById(R.id.lvMe);
        lvMe.setAdapter(new MeAdapter(context, getMeItems()));
        return view;
    }
    
    private List<MeItem> getMeItems() {
		List<MeItem> items = new ArrayList<MeItem>();
		items.add(new MeItem(R.drawable.ic_launcher, "账户", 80));
		items.add(new MeItem(R.drawable.ic_launcher, "钱包", 80));
		items.add(new MeItem(R.drawable.ic_launcher, "网络", 80));
		return items;
	}
}
