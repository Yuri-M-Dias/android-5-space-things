package dias.m.yuri.fivespace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import dias.m.yuri.fivespace.model.SpaceFact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String IMAGE_ID = "dias.m.yuri.fivespace.IMAGE_ID";

    public final static String TEXT_ID = "dias.m.yuri.fivespace.TEXT_ID";

    private List<SpaceFact> facts;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        initializeData();
        initilizeAdapter();

        Log.i("fivespace", "initializeData: ok!");
    }

    /**
     * Initilizes the adapter, effectively putting the elements on the screen.
     */
    private void initilizeAdapter() {
        RVAdapter rvAdapter = new RVAdapter(this.facts);
        recyclerView.setAdapter(rvAdapter);
    }

    /**
     * Initializes the data that is being used, the name of the properties
     * and the text and images names to render.
     */
    private void initializeData() {
        facts = new ArrayList<>();
        facts.add(new SpaceFact("Emma", R.string.iris_nebula, R.drawable.emma));
        facts.add(new SpaceFact("Lavery", R.string.iris_nebula, R.drawable
                .lavery));
        facts.add(new SpaceFact("Lillie", R.string.iris_nebula, R.drawable.lillie));
    }

    /**
     * Redirects to the other intent from the fact that was sent.
     * Uses intent attributes to inform the activity of the data to use.
     */
    private void createIntentWithImageAndText(SpaceFact fact) {
        Intent intent = new Intent(this, DisplaySpaceImageInfo.class);
        intent.putExtra(IMAGE_ID, String.valueOf(fact.getPhotoID()));
        intent.putExtra(TEXT_ID, String.valueOf(fact.getDescriptionID()));
        Log.i("createIntent", "ViewID: " + fact.getName() + " with imageid: "
                + fact.getPhotoID() + " and textId: " + fact.getDescriptionID());
        startActivity(intent);
    }

    /**
     * When the button is clicked, it changes the activity. Uses a little
     * hack to find what fact to use, and then inform it.
     *
     * @param view the button that was clicked
     */
    public void clickButtonChange(View view) {
        Button button = (Button) view;
        SpaceFact spaceFact = new SpaceFact(button.getText().toString());
        createIntentWithImageAndText(facts.get(facts.indexOf(spaceFact)));
    }


}
