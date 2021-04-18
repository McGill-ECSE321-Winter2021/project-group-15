package ca.mcgill.ecse321.autorepair_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import android.view.View;
import android.net.Uri;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.content.Intent;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bookAppointment;
    Button viewAppointment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(navView, navController);

        bookAppointment = (Button)findViewById(R.id.button3);
        bookAppointment.setOnClickListener(this);
        viewAppointment = (Button)findViewById(R.id.button4);
        viewAppointment.setOnClickListener(this);
        //login = (Button)findViewById(R.id.button6);
        //login.setOnClickListener(this);
       // back = (Button)findViewById(R.id.button2);
        //back.setOnClickListener(this);


          //  setContentView(R.layout.activity_login);

        setContentView(R.layout.activity_register);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_bookappointment);
        //setContentView(R.layout.activity_selectservice);
        //setContentView(R.layout.activity_selecttimeslot);
        //setContentView(R.layout.activity_payment);
        //login.setOnClickListener(this);
       // setContentView(R.layout.activity_viewappointment);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button3:
                //Toast.makeText(this, "Button 1 clicked", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_selectservice);
                break;
            case R.id.button4:
                //Toast.makeText(this, "Button 2 clicked", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_login);
                break;

        }


    }



}