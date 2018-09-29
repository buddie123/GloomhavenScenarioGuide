package robby35us.com.gloomhavenscenarioguide;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * A placeholder fragment containing a simple view.
 */
public class ExpressLookupFragment extends Fragment {

    public ExpressLookupFragment() {
    }

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

        final ToggleButton mainToggleButton = view.findViewById(R.id.mainToggleButton);

        final ToggleButton sideToggleButton = view.findViewById(R.id.sideToggleButton);

        final ToggleButton bothToggleButton = view.findViewById(R.id.bothToggleButton);

        return view;
    }
}
