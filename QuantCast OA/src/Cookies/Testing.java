package Cookies;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Testing
{
    private static ByteArrayOutputStream outContent;


    @Before
    public void setUp() throws Exception
    {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

    @Test
    public void test1()
    {
        String expected = "AtY0laUfhglK3lC7";
        MostActiveCookie.main(new String[] {"cookie_log_testing.csv", "-d", "2018-12-09"});
        String output = outContent.toString().trim();
        assertEquals(expected, output);
    }

    @Test
    public void test2() // too little arguments
    {
        String expected = "Error! Wrong number of arguments in input, please try again.";
        MostActiveCookie.main(new String[] {"-d", "2018-12-09"});
        String output = outContent.toString().trim();
        assertEquals(expected, output);
    }

    @Test
    public void test3() // too many arguments
    {
        String expected = "Error! Wrong number of arguments in input, please try again.";
        MostActiveCookie.main(new String[] {"cookie_log_testing.csv", "-d", "2018-12-09", "cookies"});
        String output = outContent.toString().trim();
        assertEquals(expected, output);
    }

    @Test
    public void test4() // no -d
    {
        String expected = "Error! Use \"-d\".";
        MostActiveCookie.main(new String[] {"cookie_log_testing.csv", "2018-12-09", "cookies"});
        String output = outContent.toString().trim();
        assertEquals(expected, output);
    }

    @Test
    public void test5()
    {
        String expected = "fbcn5UAVanZf6UtG\nSAZuXPGUrfbcn5UA\n4sMM2LxV07bPJzwf";
        MostActiveCookie.main(new String[] {"cookie_log_testing.csv", "-d", "2018-12-08"});
        String output = outContent.toString().trim();
        assertEquals(expected, output);
    }

    @Test
    public void test6()
    {
        String expected = "4sMM2LxV07bPJzwf";
        MostActiveCookie.main(new String[] {"cookie_log_testing.csv", "-d", "2018-12-07"});
        String output = outContent.toString().trim();
        assertEquals(expected, output);
    }
}
