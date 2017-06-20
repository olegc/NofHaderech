package nofhaderech.nof.com.nofhaderech;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private View ContentMain;
    private View ContentRider;
    private View ContentDriver;

    private GiveRidePage GiveRidePage;
    private GetRidePage GetRidePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        new DbMockifier().InitializeDB();

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        ContentMain = findViewById(R.id.content_main);
        ContentRider = findViewById(R.id.content_rider);
        ContentDriver = findViewById(R.id.content_driver);

        GiveRidePage = new GiveRidePage(ContentDriver);
        GetRidePage = new GetRidePage(ContentRider);

        MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_home);
        onNavigationItemSelected(menuItem);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (ContentMain.getVisibility() == View.VISIBLE) {
                //super.onBackPressed();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            } else {
                NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_home);
                onNavigationItemSelected(menuItem);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            ContentMain.setVisibility(View.VISIBLE);
            ContentRider.setVisibility(View.INVISIBLE);
            ContentDriver.setVisibility(View.INVISIBLE);
        }
        if (id == R.id.nav_rider) {
            ContentMain.setVisibility(View.INVISIBLE);
            ContentRider.setVisibility(View.VISIBLE);
            ContentDriver.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_driver) {
            ContentMain.setVisibility(View.INVISIBLE);
            ContentRider.setVisibility(View.INVISIBLE);
            ContentDriver.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onRiderClick(View view) {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_rider);
        menuItem.setChecked(true);
        onNavigationItemSelected(menuItem);
    }

    public void onDriverClick(View view) {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_driver);
        menuItem.setChecked(true);
        onNavigationItemSelected(menuItem);
    }

}
