package com.example.hamza.allotechnicien.clientActivities;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hamza.allotechnicien.R;
import com.example.hamza.allotechnicien.models.Technicien;

import java.util.List;

public class TechniciensListAdapter extends ArrayAdapter<Technicien> { // the arrayAdapter for challenges
    // list needed for the third activity

    List<Technicien> technicienList;
    Context context;

    public TechniciensListAdapter(@NonNull Context context, List<Technicien> technicienList){
        super(context, 0, technicienList);
        this.technicienList = technicienList;
        this.context = context;
    }

    static class ViewHolder {
        TextView technicienNom;
        TextView technicienNote;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ViewHolder vHolder;
        if(v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.techniciens_dispos_list_item, parent, false);
            vHolder = new ViewHolder();
            vHolder.technicienNom = (TextView) v.findViewById(R.id.technicienNom);
            vHolder.technicienNote = (TextView) v.findViewById(R.id.technicienNote);
            v.setTag(vHolder);
        } else {
            vHolder = (ViewHolder) v.getTag();
        }
        Technicien technicienCourant = technicienList.get(position);
        TextView name = vHolder.technicienNom;
        name.setText(technicienCourant.getUtilisateur().getNom() + " " + technicienCourant.getUtilisateur().getPrenom());
        TextView note = vHolder.technicienNote;
        note.setText(technicienCourant.getNote() + "");
        return v;
    }
}
