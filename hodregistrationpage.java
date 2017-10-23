package cwp.nnk.leavemanagementproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import cwp.nnk.leavemanagementproject.princiDatabase;

/**
 * Created by hp on 8/27/2017.
 */

public class hodregistrationpage extends Activity {
    EditText name,cno,age,quali,email,password,exp;
    Spinner spinner;
    Bitmap bit1;
    Button b;
    ImageView iv1;
    String gend[]={"male","female"};
    public static final int PHOTO_HF_REQ_CODE=1234;
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.hodregistrationpage);
        name = (EditText)findViewById(R.id.editText20);
        age = (EditText)findViewById(R.id.editText21);
        cno = (EditText)findViewById(R.id.editText22);
        quali = (EditText)findViewById(R.id.editText23);
        email = (EditText)findViewById(R.id.editText24);
        password = (EditText)findViewById(R.id.editText25);
        exp = (EditText)findViewById(R.id.editText26);
        spinner = (Spinner)findViewById(R.id.spinner5);
        iv1 = (ImageView)findViewById(R.id.imageView3);
        b = (Button)findViewById(R.id.button3);

        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line, gend);
        spinner.setAdapter(aa1);
    }

    public void registerHodFac(View view) {
        String s1=name.getText().toString().trim();
        String s2=cno.getText().toString().trim();
        String s3=age.getText().toString().trim();
        String s4=quali.getText().toString().trim();
        String s5=email.getText().toString().trim();
        String s6=password.getText().toString().trim();
        String s7=exp.getText().toString().trim();
        String s8= spinner.getSelectedItem().toString();
        if(s1.isEmpty())
        {
            name.setError("error");
            name.requestFocus();
        }
        else if(s3.isEmpty())
        {
            age.setError("error");
            age.requestFocus();
        }
        else if(s2.isEmpty())
        {
            cno.setError("error");
            cno.requestFocus();
        }

        else if(s4.isEmpty())
        {
            quali.setError("error");
            quali.requestFocus();
        }
        else if(s5.isEmpty())
        {
            email.setError("error");
            email.requestFocus();
        }
        else if(s6.isEmpty())
        {
            password.setError("error");
            password.requestFocus();
        }
        else if(s7.isEmpty())
        {
            exp.setError("error");
            exp.requestFocus();
        }
        else if (bit1!=null)
        {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            boolean result = bit1.compress(Bitmap.CompressFormat.JPEG, 100, bout);

            if (result) {
                byte image[] = bout.toByteArray();

                princiDatabase pd=new princiDatabase(this);
                SQLiteDatabase db=pd.getWritableDatabase();

                ContentValues cv = new ContentValues();
                cv.put(princiDatabase.col1, s1);
                cv.put(princiDatabase.col2, s3);
                cv.put(princiDatabase.col3, s2);
                cv.put(princiDatabase.col4, s4);
                cv.put(princiDatabase.col5, s7);
                cv.put(princiDatabase.col6, s5);
                cv.put(princiDatabase.col7, s6);
                cv.put(princiDatabase.col8, s8);
                cv.put(princiDatabase.col9, "");

                cv.put(princiDatabase.col10,image);

                long res = db.insert(princiDatabase.TABLENAME2, null, cv);
                if (res != -1) {
                    Toast.makeText(hodregistrationpage.this, "Registration done", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                {
                    Toast.makeText(hodregistrationpage.this, "Already Exists", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(hodregistrationpage.this, "Error in Image", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            ImageView iv1=new ImageView(hodregistrationpage.this);
            iv1.setImageResource(R.drawable.photo);
            Toast t=new Toast(hodregistrationpage.this);
            t.setView(iv1);
            t.setDuration(Toast.LENGTH_SHORT);
            t.show();
        }
    }

    public void takePhoto(View view) {
        Intent i=new Intent();
        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,PHOTO_HF_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==PHOTO_HF_REQ_CODE)
        {
            Bundle b=data.getExtras();
            bit1=(Bitmap)b.get("data");
            iv1.setImageBitmap(bit1);

        }
    }
}

