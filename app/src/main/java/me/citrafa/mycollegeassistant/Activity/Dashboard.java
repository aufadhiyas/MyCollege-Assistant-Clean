package me.citrafa.mycollegeassistant.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.yalantis.guillotine.animation.GuillotineAnimation;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.citrafa.mycollegeassistant.Activity.Fragment.menuCatatan;
import me.citrafa.mycollegeassistant.Activity.Fragment.menuJadwalLain;
import me.citrafa.mycollegeassistant.Activity.Fragment.menuJadwalUjian;
import me.citrafa.mycollegeassistant.AppController.SessionManager;
import me.citrafa.mycollegeassistant.CustomWidget.tvMuseo;
import me.citrafa.mycollegeassistant.R;

public class Dashboard extends AppCompatActivity {
    private static final long RIPPLE_DURATION = 250;
    @BindView(R.id.toolbars) Toolbar toolbar;
    @BindView(R.id.rootdashboard) FrameLayout root;
    @BindView(R.id.toolbarbtn) View btn;
    GuillotineAnimation gv;
    View guillotineMenu;
    ImageButton icProfile,icJK,icJU,icJL,icC,icLogout;
    tvMuseo tvEmail,tvNama;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        session = new SessionManager(getApplicationContext());

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        guillotineMenu = LayoutInflater.from(this).inflate(R.layout.menudashboard, null);
        root.addView(guillotineMenu);

        gv = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.btntoolbarkembali), btn)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
        menuAction();


    }
    public void menuAction(){
        icJK = (ImageButton)guillotineMenu.findViewById(R.id.navMenuJadwalKuliah);
        icProfile = (ImageButton)guillotineMenu.findViewById(R.id.navMenuIcon);
        icJU = (ImageButton)guillotineMenu.findViewById(R.id.navMenuJadwalUjian);
        icJL = (ImageButton)guillotineMenu.findViewById(R.id.navMenuJadwalLain);
        icC = (ImageButton)guillotineMenu.findViewById(R.id.navMenuCatatan);
        icLogout = (ImageButton)guillotineMenu.findViewById(R.id.navLogOut);
        tvEmail = (tvMuseo)guillotineMenu.findViewById(R.id.navMenuEmail);
        tvNama = (tvMuseo)guillotineMenu.findViewById(R.id.navMenuNama);
        tvEmail.setText(session.getEmaiUser());
        tvNama.setText(session.getNamaUser());

        icJK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,menuJadwalKuliahTab.class));
                gv.close();
            }
        });
        icJU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_dashboard,new menuJadwalUjian()).addToBackStack(null).commit();
                gv.close();
            }
        });
        icJL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_dashboard,new menuJadwalLain()).addToBackStack(null).commit();
                gv.close();
            }
        });
        icC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_dashboard,new menuCatatan()).addToBackStack(null).commit();
                gv.close();
            }
        });
        icLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setLogin(false);
                startActivity(new Intent(Dashboard.this,frmLogin.class));
                finish();
            }
        });

    }
}
