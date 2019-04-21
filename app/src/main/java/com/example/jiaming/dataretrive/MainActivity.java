package com.example.jiaming.dataretrive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapter mAdapter;
    private List<Reponse> list = new ArrayList<>();
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new CustomAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<Albums>> call = apiInterface.doGetList();
        call.enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response) {
                for(int i = 0;i<response.body().size();i++){
//                    Reponse reponse = new Reponse(response.body().)
                    list.add(new Reponse(response.body().get(i).getId(),response.body().get(i).getTitle(),response.body().get(i).getThumbnailUrl()));


                }
                mAdapter.notifyDataSetChanged();
                Log.e("reponse:",response.body().size()+" oo");
            }

            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t) {
                Log.e("reponse:",t.getMessage());
            }
        });

    }

}
