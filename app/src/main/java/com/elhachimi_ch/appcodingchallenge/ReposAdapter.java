package com.elhachimi_ch.appcodingchallenge;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ReposAdapter extends BaseAdapter {

    Context context;
    @SerializedName("items")
    private ArrayList<RepoModel> data;
    private ReposAdapter self= this;


    public ArrayList<RepoModel> getData() {
        return data;
    }

    public void setData(ArrayList<RepoModel> data) {
        this.data = data;
    }

    public ReposAdapter(Context c) {
        //Initialise JSON Data
        this.context= c;

    }


    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.repos_model, null);// reference to repo_model

        //reference groupComponent
        TextView repoName= row.findViewById(R.id.repoName);
        TextView repoDescription= row.findViewById(R.id.repDescription);
        TextView repoOwnerName= row.findViewById(R.id.repoOwnerName);
        TextView repoStars= row.findViewById(R.id.starsNumber);
        ImageView avatarOwner= row.findViewById(R.id.ownerImage);

        repoName.setText(data.get(i).getRepoName());
        repoDescription.setText(data.get(i).getRepoDescription());
        repoOwnerName.setText(data.get(i).getOwner().getOwnerName());
        repoStars.setText(String.valueOf(data.get(i).getStarsNumber()));
        Picasso.get().load(data.get(i).getOwner().getOwnerImageUrl()).resize(50,50).into(avatarOwner);

        return row;
    }
}
