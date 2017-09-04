package kein.app.test.sampleapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kein.app.test.sampleapplication.R;
import kein.app.test.sampleapplication.activity.SelectListActivity;

/**
 * Created by murakamikei on 2017/09/03.
 */
public class StartFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final View view1 = view.findViewById(R.id.button);
        if (view1 instanceof Button) {
            final Button button = (Button) view1;
            final Context context = getActivity().getApplicationContext();
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent = new Intent(context, SelectListActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
