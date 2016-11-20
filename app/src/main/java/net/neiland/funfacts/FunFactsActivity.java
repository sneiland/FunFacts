package net.neiland.funfacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private TextView mFactTextView;
    private Button mShowFactButton;
    private FactBook mFactbook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign views from layout file to variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = mColorWheel.getColor();
                // Update the screen with our dynamic fact
                mFactTextView.setText(  mFactbook.getFact() );
                mRelativeLayout.setBackgroundColor( color );
                mShowFactButton.setTextColor( color );
            }
        };
        mShowFactButton.setOnClickListener(listener);

        //Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"We are logging from the onCreate method!");
    }
}
