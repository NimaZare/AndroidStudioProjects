/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigationsample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;


public class Leaderboard extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        MyAdapter viewAdapter = new MyAdapter(new String[]{"Flo", "Ly", "Jo"});

        RecyclerView recyclerView = view.findViewById(R.id.leaderboard_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(viewAdapter);

        return view;
    }
}
class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private final String[] myDataset;

    MyAdapter(String[] myDataset) {
        this.myDataset = myDataset;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    static class ViewHolder extends RecyclerView.ViewHolder {
        final View item;

        ViewHolder(View itemView) {
            super(itemView);
            item = itemView;
        }
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_item, parent, false);

        return new ViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ((TextView) holder.item.findViewById(R.id.user_name_text)).setText(myDataset[position]);

        ((ImageView) holder.item.findViewById(R.id.user_avatar_image))
                .setBackgroundResource(listOfAvatars.get(position));

        holder.item.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(LeaderboardDirections
                    .actionLeaderboardToUserProfile()
                    .setUserName(myDataset[holder.getAdapterPosition()]));
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return myDataset.length;
    }

    private static final List<Integer> listOfAvatars =
            Arrays.asList(R.drawable.avatar_1_raster,
                    R.drawable.avatar_2_raster, R.drawable.avatar_3_raster);
}

