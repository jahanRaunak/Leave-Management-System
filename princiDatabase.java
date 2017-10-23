package cwp.nnk.leavemanagementproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.AutoCompleteTextView;

/**
 * Created by PHA on 8/24/2017.
 */

public class princiDatabase extends SQLiteOpenHelper
{

    public static final String DBNAME="sathya";
    public static final int VERSION=1;
    public static final String TABLENAME1="prindetails";
    public static final String TABLENAME2="hodregistration";
    public static final String TABLENAME3="facultyDatabase";
    public static final String col1="NAME";
    public static final String col2="AGE";
    public static final String col3="CNO";
    public static final String col4="GENDER";
    public static final String col5="QUALIFICATION";
    public static final String col6="EXPERIENCE";
    public static final String col7="EMAIL";
    public static final String col8="PASSWORD";
    public static final String col9="STATUS";
    public static final String col10="IMAGE";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry1="create table "+TABLENAME1+" ("+col1+" text,"+col2+" number,"+col3+ " number,"+col4+" text,"+col5+" text,"+col6+" text,"+col7+" text primary key,"+col8+" text,"+col9+" text,"+col10+"blob)";
        db.execSQL(qry1);
        String qry2="create table "+TABLENAME2+" ("+col1+" text,"+col2+" number,"+col3+ " number,"+col4+" text,"+col5+" text,"+col6+" text,"+col7+" text primary key,"+col8+" text,"+col9+" text,"+col10+"blob)";
        db.execSQL(qry2);
        String qry3="create table "+TABLENAME3+" ("+col1+" text,"+col2+" number,"+col3+ " number,"+col4+" text,"+col5+" text,"+col6+" text,"+col7+" text primary key,"+col8+" text,"+col9+" text,"+col10+"blob)";
        db.execSQL(qry3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public princiDatabase(Context context)
    {
        super(context,DBNAME,null,VERSION);
    }
}
