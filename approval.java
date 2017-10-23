package cwp.nnk.leavemanagementproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class approval extends AppCompatActivity {
    TextView Approvedhod,pendinghod,cancelhod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval) ;
        Approvedhod=(TextView)findViewById(R.id.textView4);
        pendinghod=(TextView)findViewById(R.id.textView5);
        cancelhod=(TextView)findViewById(R.id.textView6);
    }
    public void Display6(View v)
    {
        Intent i=new Intent(this,status.class);
        startActivity(i);
    }
}
