package cwp.nnk.leavemanagementproject;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    EditText et1, et2;
    Spinner spin;
    int position = 0;
    Button b1, b2;
    String items[] = {"TYPE", "ADMIN", "HOD", "FACULTY", "LEAVEREPORT"};

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items);
        spin.setAdapter(aa);
    }

    public void show1(View v) {
        String username = et1.getText().toString().trim();
        String password = et2.getText().toString().trim();
        String item = spin.getSelectedItem().toString();

        if (username.isEmpty()) {
            et1.setError("empty");
            et1.requestFocus();
        } else {
            if (password.isEmpty()) {
                et2.setError("error");
                et2.requestFocus();
            } else {
                if (item.equals("ADMIN")) {
                    if ((username.equals("neeta")) && (password.equals("123456"))) {

                        Intent i = new Intent(this, AdminHomePage.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(this, "wrong password", Toast.LENGTH_SHORT).show();
                    }
                } else if (item.equals("PRINCIPAL")) {
                    String s1=et1.getText().toString().trim();
                    princiDatabase mb=new princiDatabase(this);
                    SQLiteDatabase db=mb.getWritableDatabase();
                    String qry="select "+princiDatabase.col8+" from "+princiDatabase.TABLENAME1+" where "+princiDatabase.col7+"='"+s1+"'";
                    Cursor c=db.rawQuery(qry,null);
                    if (c.moveToFirst()) {
                        String pass=c.getString(0);
                        if (password.equals(pass)) {
                            Intent i = new Intent(this, ViewHodFacLeave.class);
                            startActivity(i);

                        } else {
                            Toast.makeText(this, "wrong password", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
                    }
                } else if (item.equals("HOD")) {
                    if ((username.equals("swati")) && (password.equals("1234"))) {
                        Intent i = new Intent(this, ViewHodList.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(this, "wrongpassword", Toast.LENGTH_SHORT).show();
                    }
                } else if (item.equals("FACULTY")) {
                    if ((username.equals("amit")) && (password.equals("123467"))) {
                        Intent i = new Intent(this, departmentlist.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(this, "wrongpassword", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }
    }


    public void newUser(View view)
    {

        String user[] = {"Head Of Department", "Faculty"};
        final android.support.v7.app.AlertDialog.Builder adb = new android.support.v7.app.AlertDialog.Builder(this);
        adb.setSingleChoiceItems(user, position, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                position = which;
                dialog.cancel();
                if (which == 0) {
                    Intent i = new Intent(MainActivity.this,hodregistrationpage.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Register Faculty", Toast.LENGTH_SHORT).show();
                    /*Intent i = new Intent(MainActivity.this, RegisterFaculty.class);
                    startActivity(i);*/
                }
            }
        });
        adb.setCancelable(false);
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();

            }
        });
        adb.create().show();
            }
        }











