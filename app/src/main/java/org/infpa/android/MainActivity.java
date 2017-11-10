package org.infpa.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    Drawer result = null;
    private AccountHeader headerResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        final IProfile profile = new ProfileDrawerItem().withName("Kartik Shandilya")
                .withEmail("kartikdroid17@gmail.com").withIcon(R.mipmap.ic_launcher)
                .withIdentifier(100);
        final IProfile profile2 = new ProfileDrawerItem()
                .withName("Demo User").withEmail("demo_user@gmail.com")
                .withIcon(R.mipmap.ic_launcher).withIdentifier(101);

        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .withSavedInstance(savedInstanceState)
                .withTranslucentStatusBar(true)
                .addProfiles(profile,profile2,
                        new ProfileSettingDrawerItem().withName("Add Account"),
                        new ProfileSettingDrawerItem().withName("Manage Accounts")
                )
                .build();

        createNavDrawer(toolbar);

    }


    private void createNavDrawer(Toolbar toolbar) {
        //Create the drawer
        result = new DrawerBuilder()
                .withAccountHeader(headerResult)
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


}
