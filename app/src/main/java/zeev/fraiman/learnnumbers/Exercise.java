package zeev.fraiman.learnnumbers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class Exercise extends AppCompatActivity {

    Context context;
    Intent takeit;
    String stName;
    TextView tvExer;
    int num1,num2, a=0,b=9;
    Button bNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        initComponentes();

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildExer();
            }
        });

    }

    private void initComponentes() {
        context=this;
        takeit=getIntent();
        stName=takeit.getStringExtra("name");
        Toast.makeText(this, "Hello my friend, "+stName, Toast.LENGTH_SHORT).show();
        tvExer=findViewById(R.id.tvExer);
        bNext=findViewById(R.id.bNext);
        buildExer();
    }

    private void buildExer() {
        num1=a+(int)((b-a+1)*Math.random());
        num2=a+(int)((b-a+1)*Math.random());
        tvExer.setText(""+num1+" ? "+num2);
    }
}