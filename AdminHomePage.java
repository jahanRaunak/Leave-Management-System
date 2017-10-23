package cwp.nnk.leavemanagementproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminHomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);

    }
        public void show2(View v)
        {
        Intent i=new Intent(this,add_PrincipalActivity.class);
        startActivity(i);
    }
    public void Display4(View v)
    {
        Intent i=new Intent(this,ViewHodList.class);
        startActivity(i);
    }
}
