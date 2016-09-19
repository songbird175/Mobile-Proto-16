package celina.lesson3hw;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private TextView text, text2, text3, text4, text5;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        //we want 5 to-do list items
        //each one of these establishes another

        // IMO, these could be better named i.e. first_todo
        text = (TextView) view.findViewById(R.id.originalText);
        text2 = (TextView) view.findViewById(R.id.originalText2);
        text3 = (TextView) view.findViewById(R.id.originalText3);
        text4 = (TextView) view.findViewById(R.id.originalText4);
        text5 = (TextView) view.findViewById(R.id.originalText5);

        // By putting refactoring your create dialog code, into a private function,
        // these on click listeners become much cleaner.
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                createDialog(text);
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                createDialog(text2);
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                createDialog(text3);
            }
        });

        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                createDialog(text4);
            }
        });

        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                createDialog(text5);
            }

        });

        return view;
    }

    /**
     * This is a refactored function
     * @param t the TextView to make changes on
     */
    private void createDialog(final TextView t) {
        //create an AlertDialog that'll come up when text is clicked
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                getActivity());

        // set title
        alertDialog.setTitle("Add item");

        final EditText input = new EditText(getActivity()); //uses the EditText from dialog_set
        input.setInputType(InputType.TYPE_CLASS_TEXT); //makes the dialog ask for plain text input
        alertDialog.setView(input);

        //set up buttons
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //what happens if you press the OK button
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
