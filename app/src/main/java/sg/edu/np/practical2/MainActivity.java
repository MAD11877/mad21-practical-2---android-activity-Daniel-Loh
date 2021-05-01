package sg.edu.np.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create!");

        User user = new User();
        //user.getDescription();
        //user.getName();

        // Storing the values into variables
        String name = user.getName();               // Store User's Name
        String desc = user.getDescription();        // Store User's Name

        // Identifying Widgets
        Button button = findViewById(R.id.button);  // Identify button (Follow)
        Button button2 = findViewById(R.id.button2);  // Identify button2 (Message)

        TextView textView = findViewById(R.id.textView); // Identify TextView (Name)
        TextView textView2 = findViewById(R.id.textView2); // Identify TextView (Description)

        // Update Text if name is not empty
        if (name != null){
            textView.setText(name);
        }
        else {
            textView.setText("Hello World!");
        }

        // Update text if description is not empty
        if (desc != null){
            textView2.setText(desc);
        }
        else {
            textView2.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        }

        //  initialize Button Text based on Followed Bool
        if (user.isFollowed() == true){
            button.setText("Unfollow");
        }
        else if (user.isFollowed() == false){
            button.setText("Follow");
        }
        else {
            button.setText("Follow");
        }

        // Change the button text after clicking and update the bool
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isFollowed() == true) {
                    button.setText("Follow");
                    user.setFollowed(false);
                }
                else if (user.isFollowed() == false){
                    button.setText("Unfollow");
                    user.setFollowed(true);
                }
                else {
                    button.setText("Follow");
                    user.setFollowed(false);
                }
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "On Start!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG, "On Resume!");
    }

    @Override
    protected void  onPause(){
        super.onPause();
        Log.v(TAG, "On Pause!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy");
    }
}