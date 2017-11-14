package org.infpa.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;

public class MainActivity extends AppCompatActivity {

    Drawer result = null;
    private static final int RC_SIGN_IN = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        createNavDrawer(toolbar);

    }

    private void createNavDrawer(Toolbar toolbar) {
        //Create the drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withSelectedItem(-1)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Categories")
                                .withIdentifier(0),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Products")
                                .withIdentifier(1)
                )
                .build();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
