package com.example.checkapartment.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.checkapartment.R;
import com.example.checkapartment.databinding.FragmentFirstBinding;
import com.example.checkapartment.model.Item;
import com.example.checkapartment.model.ItemAdapter;

import java.util.ArrayList;

public class FirstFragment extends Fragment implements  ItemAdapter.PasarElemento  {
    private FragmentFirstBinding mbinding;
    ArrayList<Item> itemlist;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        mbinding = FragmentFirstBinding.inflate(inflater,container,false);
       return mbinding.getRoot()
;    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemlist= returnItemList();
        ItemAdapter madapter = new ItemAdapter(itemlist,this);
        mbinding.rvItem.setAdapter(madapter);
        mbinding.rvItem.setLayoutManager(new LinearLayoutManager(getContext()));

    }

/*    private ArrayList<Item> returnItemList2() {
        ArrayList<Item> listItem = new ArrayList<>();
        Item item01 = new Item("Zhuo Cheng you","p","d","a","https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640");
        listItem.add(item01);
        Item item02 = new Item("billow926","p","d","a","https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640");
        listItem.add(item02);
        Item item03 = new Item("Philipp Deiß","p","d","a","https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640");
        listItem.add(item03);

        return listItem;
    }*/

    private ArrayList<Item> returnItemList() {
        ArrayList<Item> listItem = new ArrayList<>();
        Item apartment01 = new Item("Edificio Almendro","Torre 1", "depto 2002"," san jose 345 La florida  Santiago", "https://unsplash.com/photos/Ub9LkIWxyec/download?force=true&w=640");
        Item apartment02 = new Item("Edificio Almendro","Torre 1", "depto 2003", "san jose 345, La florida, Santiago", "https://unsplash.com/photos/Ub9LkIWxyec/download?force=true&w=640");
        Item apartment03 = new Item("Edificio Almendro","Torre 1", "depto 1601"," san jose 345, La florida, Santiago", "https://unsplash.com/photos/Ub9LkIWxyec/download?force=true&w=640");
        Item apartment04 = new Item("Edificio Alerces","Torre b", "depto 1602", "nueva providencia 1801, Providencia", "https://unsplash.com/photos/PhYq704ffdA/download?force=true&w=640");
        Item apartment05 = new Item("Edificio Alerces","Torre b", "depto 1801", "nueva providencia 1801, Providencia", "https://unsplash.com/photos/PhYq704ffdA/download?force=true&w=640");

        listItem.add(apartment01);
        listItem.add(apartment02);
        listItem.add(apartment03);
        listItem.add(apartment04);
        listItem.add(apartment05);

        return listItem;
    }
    @Override
    public void passElement(Item elemento) {
        Bundle bundle = new Bundle();
        String nombre = elemento.getItemnombre();
        String proyecto = elemento.getItemproy();
        String unidad = elemento.getItemunidad();
        String direcc = elemento.getItemdirecc();
        String urlimg = elemento.getItemurlimg();

        bundle.putString("nombre" ,nombre);
        bundle.putString("proyecto" ,proyecto);
        bundle.putString("unidad" ,unidad);
        bundle.putString("direcc" ,direcc);
        bundle.putString("urlimg" ,urlimg);

        Navigation.findNavController(mbinding.getRoot())
                .navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);
    }


}