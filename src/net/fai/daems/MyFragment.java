package net.fai.daems;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment{
    private String context;
    private TextView mTextView;

    public MyFragment(String context){
       this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment,container,false);
        mTextView = (TextView)view.findViewById(R.id.textView);
        mTextView.setText(context);
        return view;
    }
}
