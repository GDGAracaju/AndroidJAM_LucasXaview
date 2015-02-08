package gdg.aracaju.androidjam;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

/**
 * Created by RobertoBrandini on -07/02/2015.
 */
public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

    private TextView textView;

    private EditText editText;

    private Button button, button2;

    public MainActivityTest(){
        super(MainActivity.class);
    }

    public MainActivityTest(Class<MainActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        Intent it = new Intent(getInstrumentation().getContext(), MainActivity.class);

        startActivity(it, null, null);

        textView = (TextView) getActivity().findViewById(R.id.helloworld);

        editText = (EditText) getActivity().findViewById(R.id.editText);

        button = (Button) getActivity().findViewById(R.id.button);

        button2 = (Button) getActivity().findViewById(R.id.button2);

    }

    public void testHelloWorld() {
        String output = textView.getText().toString();

        assertEquals(getActivity().getString(R.string.hello_world), output);
    }

    public void testButton() {
        editText.setText("Lucas");

        button.performClick();

        String textoExibido = textView.getText().toString();

        assertEquals("Lucas", textoExibido);
    }

    public void testButton2() {
        int buttonVisibility = button.getVisibility();

        assertEquals(View.VISIBLE, buttonVisibility);

        button2.performClick();

        buttonVisibility = button.getVisibility();

        assertEquals(View.GONE, buttonVisibility);

        button2.performClick();

        buttonVisibility = button.getVisibility();

        assertEquals(View.VISIBLE, buttonVisibility);
    }

}
