package com.example.campusnavigator40;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class JourneySelect extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.application.campusnavigator40.EXTRA_TEXT";
    public static final String EXTRA_TEXT2 = "com.example.application.campusnavigator40.EXTRA_TEXT2";
    //Initialize variables
    TextView textViewJourneyStart;
    TextView textViewJourneyEnd;
    ArrayList<String> journeyStartArrayList;
    ArrayList<String> journeyEndArrayList;
    Dialog startDialog;
    Dialog endDialog;
    Button journeyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.journey_select);

        journeyButton = findViewById(R.id.button_start_journey);

        journeyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMainActivity();
            }
        });



        textViewJourneyStart = findViewById(R.id.text_view_journey_start);
        textViewJourneyEnd = findViewById(R.id.text_view_journey_end);

        //Initialise array lists
        journeyStartArrayList = new ArrayList<>();
        journeyEndArrayList = new ArrayList<>();
        //Add values to array lists
        journeyStartArrayList.add("e1");
        journeyStartArrayList.add("R1.02");
        journeyStartArrayList.add("RLT2");
        journeyStartArrayList.add("R1.03");
        journeyStartArrayList.add("R1.04");
        journeyStartArrayList.add("R1.32");
        journeyStartArrayList.add("e2");
        journeyStartArrayList.add("R1.48");
        journeyStartArrayList.add("R1.05");
        journeyStartArrayList.add("R1.06");
        journeyStartArrayList.add("R1.07");
        journeyStartArrayList.add("R1.08");
        journeyStartArrayList.add("R1.49");
        journeyStartArrayList.add("e3");
        journeyStartArrayList.add("R1.23");
        journeyStartArrayList.add("R1.09");
        journeyStartArrayList.add("R1.10");
        journeyStartArrayList.add("R1.11");
        journeyStartArrayList.add("R1.12");
        journeyStartArrayList.add("e4");
        journeyStartArrayList.add("R1.13");
        journeyStartArrayList.add("R1.18");
        journeyStartArrayList.add("R1.14");
        journeyStartArrayList.add("R1.15");
        journeyStartArrayList.add("R1.16");
        journeyStartArrayList.add("R1.17");

        journeyEndArrayList.add("e1");
        journeyEndArrayList.add("R1.02");
        journeyEndArrayList.add("RLT2");
        journeyEndArrayList.add("R1.03");
        journeyEndArrayList.add("R1.04");
        journeyEndArrayList.add("R1.32");
        journeyEndArrayList.add("e2");
        journeyEndArrayList.add("R1.48");
        journeyEndArrayList.add("R1.05");
        journeyEndArrayList.add("R1.06");
        journeyEndArrayList.add("R1.07");
        journeyEndArrayList.add("R1.08");
        journeyEndArrayList.add("R1.49");
        journeyEndArrayList.add("e3");
        journeyEndArrayList.add("R1.23");
        journeyEndArrayList.add("R1.09");
        journeyEndArrayList.add("R1.10");
        journeyEndArrayList.add("R1.11");
        journeyEndArrayList.add("R1.12");
        journeyEndArrayList.add("e4");
        journeyEndArrayList.add("R1.13");
        journeyEndArrayList.add("R1.18");
        journeyEndArrayList.add("R1.14");
        journeyEndArrayList.add("R1.15");
        journeyEndArrayList.add("R1.16");
        journeyEndArrayList.add("R1.17");

        textViewJourneyStart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //Initialise dialog
                startDialog = new Dialog(JourneySelect.this);
                //Set dialog
                startDialog.setContentView(R.layout.dialog_start_searchable_spinner);
                //Set height and width
                startDialog.getWindow().setLayout(650, 800);
                //Set transparency
                startDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //show dialog
                startDialog.show();

                //Initialise and assign variables
                EditText editTextJourneyStart = startDialog.findViewById(R.id.edit_text_journey_start);
                ListView listViewJourneyStart = startDialog.findViewById(R.id.list_view_journey_start);

                //Initialise array adapter
                ArrayAdapter<String> journeyStartAdapter = new ArrayAdapter<>(JourneySelect.this, android.R.layout.simple_list_item_1,journeyStartArrayList);
                //Set adapter
                listViewJourneyStart.setAdapter(journeyStartAdapter);

                editTextJourneyStart.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        //Filter array list
                        journeyStartAdapter.getFilter().filter(s);


                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                listViewJourneyStart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // When item is selected from list
                        //Set item on text view
                        textViewJourneyStart.setText(journeyStartAdapter.getItem(position));
                        //dismiss dialog
                        startDialog.dismiss();
                    }
                });

            }
        });



        textViewJourneyEnd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                //Initialise dialog
                endDialog = new Dialog(JourneySelect.this);
                //Set dialog
                endDialog.setContentView(R.layout.dialog_end_searchable_spinner);
                //Set height and width
                endDialog.getWindow().setLayout(650, 800);
                //Set transparency
                endDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //show dialog
                endDialog.show();

                //Initialise and assign variables
                EditText editTextJourneyEnd = endDialog.findViewById(R.id.edit_text_journey_end);
                ListView listViewJourneyEnd = endDialog.findViewById(R.id.list_view_journey_end);

                //Initialise array adapter
                ArrayAdapter<String> journeyEndAdapter = new ArrayAdapter<>(JourneySelect.this, android.R.layout.simple_list_item_1,journeyEndArrayList);
                //Set adapter
                listViewJourneyEnd.setAdapter(journeyEndAdapter);

                editTextJourneyEnd.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        //Filter array list
                        journeyEndAdapter.getFilter().filter(s);


                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                listViewJourneyEnd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // When item is selected from list
                        //Set item on text view
                        textViewJourneyEnd.setText(journeyEndAdapter.getItem(position));
                        //dismiss dialog
                        endDialog.dismiss();
                    }
                });

            }
        });

    }

    private void openMainActivity() {
        //Add message if either of the selection boxes are empty or if they are the same

        TextView journeyStart = findViewById(R.id.text_view_journey_start);
        String journeyStartText = journeyStart.getText().toString();
        TextView journeyEnd = findViewById(R.id.text_view_journey_end);
        String journeyEndText = journeyEnd.getText().toString();

        if (journeyStartText == ""){
            Toast.makeText(JourneySelect.this, "Select a starting destination", Toast.LENGTH_SHORT).show();
        }
        else if (journeyEndText == ""){
            Toast.makeText(JourneySelect.this, "Select a target destination", Toast.LENGTH_SHORT).show();
        }
        else if (journeyEndText == journeyStartText){
            Toast.makeText(JourneySelect.this, "Starting destination cannot be the same as target destination", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(EXTRA_TEXT, journeyStartText);
            intent.putExtra(EXTRA_TEXT2, journeyEndText);
            startActivity(intent);
        }


    }

}
