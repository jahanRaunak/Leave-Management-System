package cwp.nnk.leavemanagementproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class add_PrincipalActivity extends AppCompatActivity {
    TextView tv;
    EditText et,et2,et3,et4,et5,et6,et7;
    Spinner spin2;
    Bitmap bit2;
    ImageView iv;
    public static final int PHOTO_HF_REQ_CODE=12356;
    String gend[]={"male","female"};

    Button b8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__principal);
        tv = (TextView)findViewById(R.id.tv2);
        et = (EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText20);
        et4=(EditText)findViewById(R.id.editText22);
        et5=(EditText)findViewById(R.id.editText21);
        et6=(EditText)findViewById(R.id.editText23);
        et7=(EditText)findViewById(R.id.editText24);
        b8=(Button)findViewById(R.id.register);
        iv=(ImageView)findViewById(R.id.iv);
        spin2=(Spinner)findViewById(R.id.spin2);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,gend);
        spin2.setAdapter(aa);

    }
    public void registerPrinci(View v)
    {
      String name= et.getText().toString().trim();
        String age= et2.getText().toString().trim();
        String cno= et3.getText().toString().trim();
        String qual= et4.getText().toString().trim();
        String exp= et5.getText().toString().trim();
        String email= et6.getText().toString().trim();
        String password= et7.getText().toString().trim();
        String gender=spin2.getSelectedItem().toString();

        if(name.isEmpty())
        {
            et.setError("empty");
            et.requestFocus();
        }
        else if(age.isEmpty())
        {
            et2.setError("empty");
            et2.requestFocus();
        }
        else if(cno.isEmpty())
        {

            et3.setError("empty");
            et3.requestFocus();
        }
        else if(qual.isEmpty())
        {

            et4.setError("empty");
            et4.requestFocus();
        }
        else if(exp.isEmpty())
        {
            et5.setError("empty");
            et5.requestFocus();
        }
        else if(email.isEmpty())
        {
            et6.setError("empty");
            et6.requestFocus();
        }
        else if(password.isEmpty())
        {

            et7.setError("empty");
            et7.requestFocus();
        }
        else if(bit2!=null)
        {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            boolean result = bit2.compress(Bitmap.CompressFormat.JPEG, 100, bout);
            if (result)
            {

                byte image[] = bout.toByteArray();

                princiDatabase mb = new princiDatabase(this);
                SQLiteDatabase db = mb.getWritableDatabase();

                ContentValues cv = new ContentValues();
                cv.put(princiDatabase.col1, name);
                cv.put(princiDatabase.col2, age);
                cv.put(princiDatabase.col3, cno);
                cv.put(princiDatabase.col4, gender);
                cv.put(princiDatabase.col5, qual);
                cv.put(princiDatabase.col6, exp);
                cv.put(princiDatabase.col7, email);
                cv.put(princiDatabase.col8, password);
                cv.put(princiDatabase.col9, "");
                cv.put(princiDatabase.col10,image);
                long res = db.insert(princiDatabase.TABLENAME1, null, cv);
                if (res != -1)
                {
                    Toast.makeText(this, "Registration Done", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
            else
            {
                Toast.makeText(this, "Error in image", Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            ImageView iv=new ImageView(this);
            Toast t=new Toast(this);
            t.setView(iv);
            t.setDuration(Toast.LENGTH_LONG);
            t.show();
        }
    }
    public void  takephoto(View view)
    {
        Intent i=new Intent();
        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,PHOTO_HF_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         Bundle b = data.getExtras();
        Object o = b.get("data");
        Bitmap bit = (Bitmap)o;
        iv.setImageBitmap(bit);
    }
}





