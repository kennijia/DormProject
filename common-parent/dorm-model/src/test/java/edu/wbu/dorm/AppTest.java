package edu.wbu.dorm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        System.out.println(format);
    }
}
