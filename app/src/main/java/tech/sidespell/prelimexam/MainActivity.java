package tech.sidespell.prelimexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener{

    private int progress;
    private RadioGroup mRgProcess;
    private TextView mTvTime;
    private RadioButton mBtnInc;
    private RadioButton mBtnDec;
    private Button mBtnSwitch;
    private SeekBar mSbDelay;
    private TextView mTvSbDelay;
    private int time;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findValues();



    }

    public void findValues() {
        mRgProcess= (RadioGroup) findViewById(R.id.radioGroup);
        mTvTime = (TextView) findViewById(R.id.textView);
        mBtnInc = (RadioButton) findViewById(R.id.radioButton);
        mBtnDec = (RadioButton) findViewById(R.id.radioButton2);
        mBtnSwitch = (ToggleButton) findViewById(R.id.toggleButton);
        //mBtnSwitch.setOnCheckedChangeListener(this);
        mSbDelay = (SeekBar) findViewById(R.id.seekBar);
        mTvSbDelay = (TextView) findViewById(R.id.textView2);

        mSbDelay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                mTvSbDelay.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        mRgProcess.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {



            @Override
            public void onCheckedChanged(RadioGroup rg, int checkedId) {

                final Handler handler = new Handler();


                    runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (mBtnInc.isChecked()) {
                                time = Integer.parseInt(mTvTime.getText().toString());
                                time += 1;
                                mTvTime.setText(time + "");
                                handler.postDelayed(this, progress);
                            } else if (mBtnDec.isChecked()) {
                                time = Integer.parseInt(mTvTime.getText().toString());
                                time -= 1;
                                mTvTime.setText(time + "");
                                handler.postDelayed(this, progress);
                            }

                        }
                    };

                handler.postDelayed(runnable, 1000);
                }
            });

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
        if (isChecked) {

        } else {
        }
    }
}
