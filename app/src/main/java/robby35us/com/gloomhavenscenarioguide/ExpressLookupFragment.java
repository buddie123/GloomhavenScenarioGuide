package robby35us.com.gloomhavenscenarioguide;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import robby35us.com.gloomhavenscenarioguide.models.Scenario;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExpressLookupFragment extends Fragment implements View.OnClickListener {
    private ToggleButton mainToggleButton;
    private ToggleButton sideToggleButton;
    private ToggleButton bothToggleButton;

    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter mainOnlyAdapter;
    private MyRecyclerViewAdapter sideOnlyAdapter;
    private MyRecyclerViewAdapter bothAdapter;

    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_express_lookup, container, false);
        TextView selectionTitle = view.findViewById(R.id.selectionTitle);
        selectionTitle.setText(R.string.label_express_lookup);

        ImageButton navLeftButton = view.findViewById(R.id.navLeftButton);
        navLeftButton.setVisibility(View.INVISIBLE);

        ImageButton navRightButton = view.findViewById(R.id.navRightButton);
        navRightButton.setVisibility(View.INVISIBLE);

        mainOnlyAdapter = new MyRecyclerViewAdapter(Scenario.mainScenarioNames);
        sideOnlyAdapter = new MyRecyclerViewAdapter(Scenario.sideScenarioNames);
        bothAdapter = new MyRecyclerViewAdapter(Scenario.bothScenarioNames);

        recyclerView = view.findViewById(R.id.selectionsRV);
        recyclerView.setAdapter(bothAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        mainToggleButton = view.findViewById(R.id.mainToggleButton);
        mainToggleButton.setOnClickListener(this);

        sideToggleButton = view.findViewById(R.id.sideToggleButton);
        sideToggleButton.setOnClickListener(this);

        bothToggleButton = view.findViewById(R.id.bothToggleButton);
        bothToggleButton.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainToggleButton:
                mainToggleButton.setBackgroundResource(R.drawable.toggle_button_on);
                sideToggleButton.setBackgroundResource(R.drawable.toggle_button_off);
                bothToggleButton.setBackgroundResource(R.drawable.toggle_button_off);
                recyclerView.setAdapter(mainOnlyAdapter);
                recyclerView.invalidate();
                break;
            case R.id.sideToggleButton:
                mainToggleButton.setBackgroundResource(R.drawable.toggle_button_off);
                sideToggleButton.setBackgroundResource(R.drawable.toggle_button_on);
                bothToggleButton.setBackgroundResource(R.drawable.toggle_button_off);
                recyclerView.setAdapter(sideOnlyAdapter);
                recyclerView.invalidate();
                break;
            case R.id.bothToggleButton:
                mainToggleButton.setBackgroundResource(R.drawable.toggle_button_off);
                sideToggleButton.setBackgroundResource(R.drawable.toggle_button_off);
                bothToggleButton.setBackgroundResource(R.drawable.toggle_button_on);
                recyclerView.setAdapter(bothAdapter);
                recyclerView.invalidate();
                break;
        }
    }

    class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {
        private List<String> locNames;


        public MyRecyclerViewAdapter(List<String> locNames) {
            this.locNames = new ArrayList<>(locNames.size());
            this.locNames.addAll(locNames);
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.content_list_item, viewGroup, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
            try{
                InputStream inputStream = getActivity().getAssets().open("sticker1_150.png");
                Drawable image = Drawable.createFromStream(inputStream, null);
                myViewHolder.locSticker.setImageDrawable(image);
            }
            catch (Exception e){
                Log.e("onCreateViewHolder", "problem opening asset");
            }
            myViewHolder.locName.setText(locNames.get(position));
        }

        @Override
        public int getItemCount() {
            return locNames.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            final ImageView locSticker;
            final TextView locName;

            public MyViewHolder(View view) {
                super(view);
                locSticker = view.findViewById(R.id.locSticker);
                locName = view.findViewById(R.id.locName);
            }
        }
    }
}
