package celina.lesson4hw;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    ArrayList<User> user;
//    protected CustomUsersAdapter adapter = new CustomUsersAdapter(MainActivity.this, user);

    @Override
    protected void onCreate(Bundle savedInstanceState) { //initialize the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //establish where the layout will come from
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //creates a toolbar
        setSupportActionBar(toolbar);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            //creates the first fragment dynamically, so it can be replaced
            Fragment firstFragment = new MainActivityFragment();
            firstFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }

        //This creates the Floating Action Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
            }
        });
    }

    private void createDialog() {
        ArrayList<User> user = new ArrayList<User>();
        final CustomUsersAdapter adapter = new CustomUsersAdapter(MainActivity.this, user);

        // create an AlertDialog that'll come up when text is clicked
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        // set title
        alertDialog.setTitle("Edit item");

        final EditText input = new EditText(MainActivity.this); //uses the EditText from dialog_set
        input.setInputType(InputType.TYPE_CLASS_TEXT); //makes the dialog ask for plain text input
        alertDialog.setView(input);

        // set up buttons

        alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String textInput = input.getText().toString(); //saves user text as a string
                adapter.add(textInput);
                adapter.notifyDataSetChanged();
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //generate an options menu
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // Create new fragment and transaction
            Fragment newFragment = new SettingsFragment();
            android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment, and add the transaction to the back stack
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
