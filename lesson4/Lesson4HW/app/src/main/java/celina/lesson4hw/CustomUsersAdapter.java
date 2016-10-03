package celina.lesson4hw;

import java.util.ArrayList;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by celina on 9/28/16.
 */
public class CustomUsersAdapter extends ArrayAdapter<User> {
    private ArrayList<User> users;

    public CustomUsersAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
        this.users = users;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHometown);
        // Populate the data into the template view using the data object
        tvName.setText(user.name);
        tvHome.setText(user.hometown);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog(position);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }

    private void createDialog(final int position) {
        // create an AlertDialog that'll come up when text is clicked
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                getContext());

        // set title
        alertDialog.setTitle("Edit item");

        final EditText input = new EditText(getContext()); //uses the EditText from dialog_set
        input.setInputType(InputType.TYPE_CLASS_TEXT); //makes the dialog ask for plain text input
        alertDialog.setView(input);

        // set up buttons

        alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String textInput = input.getText().toString(); //saves user text as a string
                users.get(position).name = textInput;
                notifyDataSetChanged();
            }
        });

        alertDialog.setNeutralButton("Complete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                users.get(position).hometown = "Complete";
                notifyDataSetChanged();
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
