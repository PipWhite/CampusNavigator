package com.example.campusnavigator40;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.sceneform.Camera;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.collision.Ray;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Creating an instance of external classes
    public Accelerometer accelerometer;
    private Gyroscope gyroscope;

    private ArFragment arFragment;
    private ModelRenderable modelRenderable;

    //Initialise variables for live sensor readings
    TextView accelXvalue, accelYvalue, accelZvalue, gyroXvalue, gyroYvalue, gyroZvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the textviews as these values
        accelXvalue = findViewById(R.id.accelXvalue);
        accelZvalue = findViewById(R.id.accelZvalue);

        accelerometer = new Accelerometer(this);
        gyroscope = new Gyroscope(this);

            startJourney();

    }

    private void startJourney() {

        // Setting up graph vertices and edges
        Graph rBlock = new Graph(true, false);

        Vertex e1 = rBlock.addVertex("e1", 0.0, 0.0);
        Vertex e1f1 = rBlock.addVertex("e1f1", 5.8, 0.0);
        Vertex c1 = rBlock.addVertex("c1", 7.13, 0.0);
        Vertex R102 = rBlock.addVertex("R1.02", 7.13, 0.73);
        Vertex RLT2 = rBlock.addVertex("RLT2", 7.13, -1.75);
        Vertex c2 = rBlock.addVertex("c2", 13.54, 0.0);
        Vertex R103 = rBlock.addVertex("R1.03", 13.54, 0.73);
        Vertex c3 = rBlock.addVertex("c3", 14.64, 0.0);
        Vertex R104 = rBlock.addVertex("R1.04", 14.64, 0.73);
        Vertex c4 = rBlock.addVertex("c4", 18.44, 0.0);
        Vertex R132 = rBlock.addVertex("R1.32", 18.44, -0.77);
        Vertex e2f1 = rBlock.addVertex("e2f1", 22.79, 0.0);
        Vertex e2 = rBlock.addVertex("e2", 22.79, 0.73);
        Vertex e2f2 = rBlock.addVertex("e2f2", 23.54, 0.0);
        Vertex c5 = rBlock.addVertex("c5", 27.34, 0.0);
        Vertex R148 = rBlock.addVertex("R1.48", 27.34, -0.77);
        Vertex c6 = rBlock.addVertex("c6", 28.39, 0.0);
        Vertex R105 = rBlock.addVertex("R1.05", 28.39, 0.73);
        Vertex c7 = rBlock.addVertex("c7", 29.59, 0.0);
        Vertex R106 = rBlock.addVertex("R1.06", 29.59, 0.73);
        Vertex c8 = rBlock.addVertex("c8", 31.99, 0.0);
        Vertex R107 = rBlock.addVertex("R1.07", 31.99, 0.73);
        Vertex c9 = rBlock.addVertex("c9", 34.86, 0.0);
        Vertex R108 = rBlock.addVertex("R1.08", 34.86, 0.73);
        Vertex c10 = rBlock.addVertex("c10", 36.25, 0.0);
        Vertex R149 = rBlock.addVertex("R1.49", 36.25, -0.77);
        Vertex e3f1 = rBlock.addVertex("e3f1", 43.23, 0.0);
        Vertex e3 = rBlock.addVertex("e3", 43.23, 0.73);
        Vertex e3f2 = rBlock.addVertex("e3f2", 43.93, 0.0);
        Vertex c11 = rBlock.addVertex("c11", 47.78, 0.0);
        Vertex R123 = rBlock.addVertex("R1.23", 47.78, -0.77);
        Vertex c12 = rBlock.addVertex("c12", 49.0, 0.0);
        Vertex R109 = rBlock.addVertex("R1.09", 49.0, 0.73);
        Vertex c13 = rBlock.addVertex("c13", 50.03, 0.0);
        Vertex R110 = rBlock.addVertex("R1.10", 50.03, 0.73);
        Vertex c14 = rBlock.addVertex("c14", 52.62, 0.0);
        Vertex R111 = rBlock.addVertex("R1.11", 52.62, 0.73);
        Vertex c15 = rBlock.addVertex("c15", 55.23, 0.0);
        Vertex R112 = rBlock.addVertex("R1.12", 55.23, 0.73);
        Vertex e4f1 = rBlock.addVertex("e4f1", 63.6, 0.0);
        Vertex e4 = rBlock.addVertex("e4", 63.6, 0.73);
        Vertex e4f2 = rBlock.addVertex("e4f2", 64.3, 0.0);
        Vertex c16 = rBlock.addVertex("c16", 67.92, 0.0);
        Vertex R113 = rBlock.addVertex("R1.13", 67.92, 0.73);
        Vertex c17 = rBlock.addVertex("c17", 71.84, 0.0);
        Vertex R118 = rBlock.addVertex("R1.18", 71.84, -0.77);
        Vertex c18 = rBlock.addVertex("c18", 73.14, 0.0);
        Vertex c19 = rBlock.addVertex("c19", 74.37, 0.0);
        Vertex R114 = rBlock.addVertex("R1.14", 74.37, 0.73);
        Vertex R115 = rBlock.addVertex("R1.15", 75.15, 0.0);
        Vertex c20 = rBlock.addVertex("c20", 74.37, -1.26);
        Vertex R116 = rBlock.addVertex("R1.16", 75.13, -1.26);
        Vertex R117 = rBlock.addVertex("R1.17", 74.37, -6.72);

        rBlock.addEdge(e1, e1f1, 5.8);
        rBlock.addEdge(e1f1, c1, 1.33);
        rBlock.addEdge(c1, R102, 0.73);
        rBlock.addEdge(c1, RLT2, 1.75);
        rBlock.addEdge(c1, c2, 6.41);
        rBlock.addEdge(c2, R103, 0.73);
        rBlock.addEdge(c2, c3, 1.1);
        rBlock.addEdge(c3, R104, 0.73);
        rBlock.addEdge(c3, c4, 3.8);
        rBlock.addEdge(c4, R132, 0.77);
        rBlock.addEdge(c4, e2f1, 4.35);
        rBlock.addEdge(e2f1, e2, 0.73);
        rBlock.addEdge(e2f1, e2f2, 0.75);
        rBlock.addEdge(e2f2, c5, 3.8);
        rBlock.addEdge(c5, R148, 0.77);
        rBlock.addEdge(c5, c6, 1.05);
        rBlock.addEdge(c6, R105, 0.73);
        rBlock.addEdge(c6, c7, 1.2);
        rBlock.addEdge(c7, R106, 0.73);
        rBlock.addEdge(c7, c8, 2.4);
        rBlock.addEdge(c8, R107, 0.73);
        rBlock.addEdge(c8, c9, 2.87);
        rBlock.addEdge(c9, R108, 0.73);
        rBlock.addEdge(c9, c10, 1.39);
        rBlock.addEdge(c10, R149, 0.77);
        rBlock.addEdge(c10, e3f1, 6.98);
        rBlock.addEdge(e3f1, e3, 0.73);
        rBlock.addEdge(e3f1, e3f2, 0.7);
        rBlock.addEdge(e3f2, c11, 3.85);
        rBlock.addEdge(c11, R123, 0.77);
        rBlock.addEdge(c11, c12, 1.22);
        rBlock.addEdge(c12, R109, 0.73);
        rBlock.addEdge(c12, c13, 1.03);
        rBlock.addEdge(c13, R110, 0.73);
        rBlock.addEdge(c13, c14, 2.59);
        rBlock.addEdge(c14, R111, 0.73);
        rBlock.addEdge(c14, c15, 2.59);
        rBlock.addEdge(c15, R112, 0.73);
        rBlock.addEdge(c15, e4f1, 8.37);
        rBlock.addEdge(e4f1, e4, 0.73);
        rBlock.addEdge(e4f1, e4f2, 0.7);
        rBlock.addEdge(e4f2, c16, 3.62);
        rBlock.addEdge(c16, R113, 0.73);
        rBlock.addEdge(c16, c17, 3.92);
        rBlock.addEdge(c17, R118, 0.77);
        rBlock.addEdge(c17, c18, 1.3);
        rBlock.addEdge(c18, c19, 1.23);
        rBlock.addEdge(c18, c20, 1.26);
        rBlock.addEdge(c19, R114, 0.73);
        rBlock.addEdge(c19, R115, 0.78);
        rBlock.addEdge(c20, R116, 0.76);
        rBlock.addEdge(c20, R117, 5.46);

        //Getting the inputted data from the journey select activity
        Intent intent = getIntent();
        Vertex selectedStartV = null;
        Vertex selectedEndV = null;
         for(Vertex v: rBlock.getVertices()){
                if(v.getData().equals(intent.getStringExtra(JourneySelect.EXTRA_TEXT))){
                    selectedStartV = v;
                }
        }
        for(Vertex v: rBlock.getVertices()){
            if(v.getData().equals(intent.getStringExtra(JourneySelect.EXTRA_TEXT2))){
                selectedEndV = v;
            }
        }


        ArrayList<Vertex> path;
        path = Dijkstra.pathArray(rBlock, selectedStartV, selectedEndV);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        //sets up the arrow model
        setUpModel();
        Node node = new Node();
        Quaternion direction;

        for (int i = 0; i < path.size() - 1; i++){
            //Gets the start vertex and the x and y coordinated
            Vertex startV = path.get(i);
            Double startX = startV.getX();
            Double startY = startV.getY();
            //Gets the end vertex and the x and y coordinated
            Vertex endV = path.get(i+1);
            Double endX = endV.getX();
            Double endY = endV.getY();

            //Iterates through all the edges connected to the start Vertex
            for (Edge e: startV.getEdges()) {
                //Find the edge that has the end vertex of the next node
                Double edgeWeight;
                if (e.getEnd() == endV) {
                    //The weight of the current edge
                    edgeWeight = e.getWeight();
                    accelXvalue.setText("Edge weight: " + edgeWeight);
                    //setting direction of the arrow
                    if (endY > startY) direction = new Quaternion(0, 1, 0, 1); //forward
                    else if (endY < startY) direction = new Quaternion(0, 1, 0, -1); //backwards
                    else if (endX > startX) direction = new Quaternion(0, 0, 0, 0);//right
                    else direction = new Quaternion(0, 1, 0, 0);// left

                    //creates the arrow in the AR scene and points it in the right direction
                    Quaternion finalDirection = direction;
                    arFragment.getArSceneView().getScene().addOnUpdateListener(frameTime -> {
                        Camera camera = arFragment.getArSceneView().getScene().getCamera();
                        Ray ray = camera.screenPointToRay(1080 / 2f, 3 * (2340 / 4f));
                        Vector3 newPosition = ray.getPoint(1f);
                        node.setParent(arFragment.getArSceneView().getScene());
                        node.setRenderable(modelRenderable);
                        node.setLocalPosition(newPosition);
                        //this sets the rotation of the arrow when it is placed
                        //(0,1,0,0) points left
                        //(0,0,0,0) points right
                        //(0,1,0,1) points forward
                        //(0,1,0,-1) points backwards
                        node.setWorldRotation(finalDirection);

                    });


                    double NS2S = 1.0 / 1000000000.0;
                    double distanceTravelled = 0.0;
                    long previousTimestamp = System.nanoTime();
                    double velocity = 0;
                    double deltaTime;

                    //get acceleration here
                    double[] acceleration = accelerometer.getTranslation();
                    accelerometer.setListener(new Accelerometer.Listener() {
                        @Override
                        public void onTranslation(double tx, double ty, double tz) {
                            acceleration[0] = tx;
                            acceleration[1] = ty;
                            acceleration[2] = tz;
                            double tAcceleration = Math.sqrt((tx*tx)+(ty*ty)+(tz*tz));
                            accelZvalue.setText( "" + tAcceleration);
                        }
                    });

/*
                    while (edgeWeight > distanceTravelled) {
                        long currentTimestamp = System.nanoTime();
                        deltaTime = (currentTimestamp - previousTimestamp) * NS2S;
                        velocity += acceleration[0] * deltaTime;
                        distanceTravelled += velocity * deltaTime;
                        previousTimestamp = currentTimestamp;

                    }

 */
                }
            }
        }
        Toast.makeText(MainActivity.this, "You have reached your destination", Toast.LENGTH_SHORT).show();

    }

    //Preparing the arrow model
    private void setUpModel(){
        ModelRenderable.builder()
                .setSource(this, R.raw.smallerarrow)
                .build()
                .thenAccept(renderable -> modelRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Model can't be loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });

    }


    @Override
    protected void onResume() {
        super.onResume();

        accelerometer.register();
        gyroscope.register();
    }

    @Override
    protected void onPause() {
        super.onPause();

        accelerometer.unregister();
        gyroscope.unregister();
    }



}
