package ru.samsung.itschool.book;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {
    public static final String ZERO = "0";
    public static final String NEG_ONE_ = "-1.0";
    public static final String ZERO_ = "0.0";
    public static final String ONE_ = "1.0";
    public static final String TWO_ = "2.0";
    public static final String ANY = "any";
    public static final String NONE = "none";
    private MainActivity activity;
    static StringBuffer sb;
    static int salt;

    @BeforeClass
    public static void report(){
        salt=new Random(System.currentTimeMillis()).nextInt(999);
        sb=new StringBuffer();
        sb.append(String.format("%03d",salt));
    }

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create().get();
    }

    @Test
    public void testButton1() throws Exception {
        try {
            MainActivity activity = Robolectric.buildActivity(MainActivity.class)
                    .create().get();
            Button view = (Button) activity.findViewById(R.id.run);
            Assert.assertNotNull(view);
            EditText et_a = (EditText) activity.findViewById(R.id.a);
            Assert.assertNotNull(et_a);
            EditText et_b = (EditText) activity.findViewById(R.id.b);
            Assert.assertNotNull(et_b);
            EditText et_c = (EditText) activity.findViewById(R.id.c);
            Assert.assertNotNull(et_c);
            TextView tv = (TextView) activity.findViewById(R.id.res);
            Assert.assertNotNull(tv);
            et_a.setText(ZERO);
            et_b.setText(ZERO);
            et_c.setText(ZERO);
            view.performClick();
            org.junit.Assert.assertEquals(tv.getText().toString(), ANY);
            sb.append(",OK");
        } catch (Throwable t){}
    }

    @Test
    public void testButton2() throws Exception {
        try {
            MainActivity activity = Robolectric.buildActivity(MainActivity.class)
                    .create().get();
            Button view = (Button) activity.findViewById(R.id.run);
            Assert.assertNotNull(view);
            EditText et_a = (EditText) activity.findViewById(R.id.a);
            Assert.assertNotNull(et_a);
            EditText et_b = (EditText) activity.findViewById(R.id.b);
            Assert.assertNotNull(et_b);
            EditText et_c = (EditText) activity.findViewById(R.id.c);
            Assert.assertNotNull(et_c);
            TextView tv = (TextView) activity.findViewById(R.id.res);
            Assert.assertNotNull(tv);
            et_a.setText(NEG_ONE_);
            et_b.setText(TWO_);
            et_c.setText(ZERO);
            view.performClick();
            String s[]=tv.getText().toString().trim().replaceAll(" +", " ").split(" ");
            double r1=Double.valueOf(s[0]);
            double r2=Double.valueOf(s[1]);
            if(r1>r2) {
                org.junit.Assert.assertEquals(2, r1, 0.001);
                org.junit.Assert.assertEquals(0, r2, 0.001);
            } else {
                org.junit.Assert.assertEquals(0, r1, 0.001);
                org.junit.Assert.assertEquals(2, r2, 0.001);
            }
            sb.append(",OK");
        } catch (Throwable t){}
    }

    @Test
    public void testButton3() throws Exception {
        try {
            MainActivity activity = Robolectric.buildActivity(MainActivity.class)
                    .create().get();
            Button view = (Button) activity.findViewById(R.id.run);
            Assert.assertNotNull(view);
            EditText et_a = (EditText) activity.findViewById(R.id.a);
            Assert.assertNotNull(et_a);
            EditText et_b = (EditText) activity.findViewById(R.id.b);
            Assert.assertNotNull(et_b);
            EditText et_c = (EditText) activity.findViewById(R.id.c);
            Assert.assertNotNull(et_c);
            TextView tv = (TextView) activity.findViewById(R.id.res);
            Assert.assertNotNull(tv);
            et_a.setText(ONE_);
            et_b.setText(TWO_);
            et_c.setText(TWO_);
            view.performClick();
            org.junit.Assert.assertEquals(tv.getText().toString(), NONE);
            sb.append(",OK");
        }catch(Throwable t){}
    }

    @AfterClass
    public static void printResult(){
        System.err.println("\n\n=============================\nВАШ РЕЗУЛЬТАТ: "+sb.toString().hashCode()+""+salt+"\n=============================\n");

    }

}
