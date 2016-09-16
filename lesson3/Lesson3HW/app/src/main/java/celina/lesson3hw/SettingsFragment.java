package celina.lesson3hw;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by celina on 9/15/16.
 */
public class SettingsFragment extends Fragment{

    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.settings, container, false);

        //three color buttons
        Button button1 = (Button) view.findViewById(R.id.pinkButton);
        Button button2 = (Button) view.findViewById(R.id.mintButton);
        Button button3 = (Button) view.findViewById(R.id.lavButton);


        //when button is clicked, sets the background color to its corresponding color
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(getResources().getColor(R.color.pink));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(getResources().getColor(R.color.mint));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setBackgroundColor(getResources().getColor(R.color.lavender));
            }
        });

        return view;
    }
}
