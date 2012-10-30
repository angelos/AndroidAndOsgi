package net.luminis.jfall2012.doubleclass;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DoubleClass extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_double_class, menu);
        return true;
    }
}
