package zeev.fraiman.learnnumbers;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ImageView ivZF;
    Button bStart;
    CountDownTimer cdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivZF=findViewById(R.id.ivZF);
        ivZF.animate().rotation(360f).setDuration(4000).start();

        bStart=findViewById(R.id.bStart);
        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go=new Intent(MainActivity.this, UserData.class);
                startActivity(go);
            }
        });

        cdt=new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent go=new Intent(MainActivity.this, UserData.class);
                startActivity(go);
            }
        }.start();
    }
}