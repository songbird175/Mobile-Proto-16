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

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        //we want 5 to-do list items
        //each one of these establishes another
        final TextView text = (TextView) view.findViewById(R.id.originalText);
        final TextView text2 = (TextView) view.findViewById(R.id.originalText2);
        final TextView text3 = (TextView) view.findViewById(R.id.originalText3);
        final TextView text4 = (TextView) view.findViewById(R.id.originalText4);
        final TextView text5 = (TextView) view.findViewById(R.id.originalText5);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

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
                        text.setText(textInput); //updates the item text to be the string established in the line above
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
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(
                        getActivity());

                // set title
                alertDialog2.setTitle("Add item");

                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                alertDialog2.setView(input);

                alertDialog2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String textInput2 = input.getText().toString();
                        text2.setText(textInput2);
                    }
                });
                alertDialog2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // show it
                alertDialog2.show();
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialog3 = new AlertDialog.Builder(
                        getActivity());

                // set title
                alertDialog3.setTitle("Add item");

                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                alertDialog3.setView(input);

                alertDialog3.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String textInput3 = input.getText().toString();
                        text3.setText(textInput3);
                    }
                });
                alertDialog3.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // show it
                alertDialog3.show();
            }
        });

        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialog4 = new AlertDialog.Builder(
                        getActivity());

                // set title
                alertDialog4.setTitle("Add item");

                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                alertDialog4.setView(input);

                alertDialog4.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String textInput4 = input.getText().toString();
                        text4.setText(textInput4);
                    }
                });
                alertDialog4.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // show it
                alertDialog4.show();
            }
        });

        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialog5 = new AlertDialog.Builder(
                        getActivity());

                // set title
                alertDialog5.setTitle("Add item");

                final EditText input = new EditText(getActivity());
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                alertDialog5.setView(input);

                alertDialog5.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String textInput5 = input.getText().toString();
                        text5.setText(textInput5);
                    }
                });
                alertDialog5.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // create alert dialog
                AlertDialog alertDialog = alertDialog5.create();

                // show it
                alertDialog.show();
            }

        });

        return view;
    }
}
