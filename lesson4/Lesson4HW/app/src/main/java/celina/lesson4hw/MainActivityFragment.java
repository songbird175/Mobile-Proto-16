package celina.lesson4hw;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.lvUsers) ListView listView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        ArrayList<User> arrayOfUsers = new ArrayList<User>();
        arrayOfUsers.add(new User("Person 1", "Hometown 1"));
        arrayOfUsers.add(new User("Person 2", "Hometown 2"));
        arrayOfUsers.add(new User("Person 3", "Hometown 3"));
        arrayOfUsers.add(new User("Person 4", "Hometown 4"));
        arrayOfUsers.add(new User("Person 5", "Hometown 5"));
        // Create the adapter to convert the array to views
        CustomUsersAdapter adapter = new CustomUsersAdapter(getContext(), arrayOfUsers);
        // Attach the adapter to a ListView
        listView.setAdapter(adapter);

        return view;
    }
}
