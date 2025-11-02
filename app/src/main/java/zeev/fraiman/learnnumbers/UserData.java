package zeev.fraiman.learnnumbers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class UserData extends AppCompatActivity {

    Context context;
    EditText etName, etPassword;
    Button bGo;
    String stName="",stPassword="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);


        initComponents();

        bGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stName=etName.getText().toString();
                if (stName.equals(""))  {
                    Toast.makeText(UserData.this, "Your name is empty!", Toast.LENGTH_LONG).show();
                    etName.setBackgroundColor(Color.RED);
                    return;
                }else{
                    etName.setBackgroundColor(Color.WHITE);

                }
                stPassword=etPassword.getText().toString();
                if (stPassword.equals(""))  {
                    Toast.makeText(UserData.this, "Your pasword is empty!", Toast.LENGTH_LONG).show();
                    return;
                }
                AlertDialog.Builder adb=new AlertDialog.Builder(context);
                adb.setTitle("it's your data?");
                adb.setMessage("name="+stName+"\npassword="+stPassword);
                adb.setPositiveButton("Yep, it's Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            FileOutputStream fos=openFileOutput("mypassword.txt", MODE_PRIVATE);
                            OutputStreamWriter osw=new OutputStreamWriter(fos);
                            BufferedWriter bw=new BufferedWriter(osw);
                            bw.write(stPassword);
                            bw.close();
                        } catch (FileNotFoundException e) {
                            Toast.makeText(context, "Error="+e.toString(), Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                        Intent go=new Intent(context, Exercise.class);
                        go.putExtra("name",stName);
                        startActivity(go);
                    }
                });
                adb.setNeutralButton("No!!!!!!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        etName.setText("");
                        etPassword.setText("");
                    }
                });
                adb.setNegativeButton("one moment", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                adb.create().show();
            }
        });
    }

    private void initComponents() {
        context=this;
        etName=findViewById(R.id.etName);
        etPassword=findViewById(R.id.etPassword);
        bGo=findViewById(R.id.bGo);
    }
}