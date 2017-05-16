package me.citrafa.mycollegeassistant.Activity.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import butterknife.BindView;
import me.citrafa.mycollegeassistant.CustomWidget.btnMuseo;
import me.citrafa.mycollegeassistant.CustomWidget.etMuseo;
import me.citrafa.mycollegeassistant.CustomWidget.tvMuseo;
import me.citrafa.mycollegeassistant.R;

/**
 * Created by SENSODYNE on 14/05/2017.
 */

public class frmTugas extends Fragment {
    @BindView(R.id.lblMakulTugas) tvMuseo lblMakul;
    @BindView(R.id.lblWaktuMakulTugas) tvMuseo lblWaktu;
    @BindView(R.id.txtDeskripsiTugas) etMuseo txtDeskripsi;
    @BindView(R.id.btnBrowseFileTugas) btnMuseo btnBrowser;
    @BindView(R.id.lblFileTugas) tvMuseo lblFile;
    @BindView(R.id.switchWaktuKumpulTugas) Switch swWaktu;
    @BindView(R.id.lblSwitchTugas) tvMuseo lblSwitch;
    @BindView(R.id.txtWaktuKumpulTugas) etMuseo txtWaktu;
    @BindView(R.id.btnSimpanTugas) btnMuseo btnSimpan;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}