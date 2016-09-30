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

    // @BindView(R.id.originalText) TextView first;
    @BindView(R.id.lvUsers) ListView listView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        ArrayList<User> arrayOfUsers = User.getUsers();
        // Create the adapter to convert the array to views
        CustomUsersAdapter adapter = new CustomUsersAdapter(getContext(), arrayOfUsers);
        // Attach the adapter to a ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivityFragment", "Hi, I'm a log");
            }
        });

        return view;
    }

    private void createDialog(final TextView t) {
        // create an AlertDialog that'll come up when text is clicked
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                getActivity());

        // set title
        alertDialog.setTitle("Edit item");

        final EditText input = new EditText(getActivity()); //uses the EditText from dialog_set
        input.setInputType(InputType.TYPE_CLASS_TEXT); //makes the dialog ask for plain text input
        alertDialog.setView(input);

        // set up buttons
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // what happens if you press the OK button
                String textInput = input.getText().toString(); //saves user text as a string
                t.setText(textInput); //updates the item text to be the string established in the line above
            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // show it
        alertDialog.show();
    }


}