package cwp.nnk.leavemanagementproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ViewHodFacLeave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_hod_fac_leave);
    }
    public void Dispaly5(View v)
    {
        Intent i=new Intent(this,status.class);
        startActivity(i);
    }
}
