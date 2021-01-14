package com.example.checkapartment.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.checkapartment.R;
import com.example.checkapartment.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding mbinding;
    private static final String ARG_PARAM1 = "nombre";
    private static final String ARG_PARAM2 = "proyecto";
    private static final String ARG_PARAM3 = "unidad";
    private static final String ARG_PARAM4 = "direcc";
    private static final String ARG_PARAM5 = "urlimg";
    private String mnombre;
    private String mproy;
    private String munidad;
    private String mdirecc;
    private String murlimg;
    private int puntaje;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mnombre = getArguments().getString(ARG_PARAM1);
            mproy   = getArguments().getString(ARG_PARAM2);
            munidad = getArguments().getString(ARG_PARAM3);
            mdirecc =  getArguments().getString(ARG_PARAM4);
            murlimg = getArguments().getString(ARG_PARAM5);
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        mbinding = FragmentSecondBinding.inflate(inflater,container,false);
        return mbinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       mbinding.tvNombre2.setText(mnombre + "," + mproy + "," + munidad) ;
        Glide.with(getContext()).load(murlimg)
               .into(mbinding.imgGv);
    //    mbinding.checkBox1.setText( (int) (0.7/0.7));

        mbinding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        RadioGroup radioGroup1 = mbinding.radioGroup1;
        RadioGroup radioGroup2 = mbinding.radioGroup2;

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                 showPuntaje( getpuntaje());
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                  showPuntaje( getpuntaje());
            }
        });
    }

    public int getpuntaje(){
        int mpuntaje = 0;
        if (mbinding.checkBox1.isChecked()){ mpuntaje += 10;
            Log.d("pp","checkbox1");}
        if (mbinding.checkBox2.isChecked()){ mpuntaje += 40;}
        if (mbinding.checkBox3.isChecked()){ mpuntaje += 30;}
        if (mbinding.checkBox4.isChecked()){ mpuntaje += 20;}

        if(mbinding.radioButton1.isChecked()) { mpuntaje = mpuntaje*3; }
        if(mbinding.radioButton2.isChecked()) { mpuntaje = mpuntaje*2; }

        this.puntaje = mpuntaje;
        return mpuntaje;
    }

    public void showPuntaje(int mpuntaje) {
    mbinding.tvResultado.setText(String.valueOf( mpuntaje ));
    }
}
