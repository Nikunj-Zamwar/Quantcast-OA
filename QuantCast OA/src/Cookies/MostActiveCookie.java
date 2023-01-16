package Cookies;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class MostActiveCookie
{
    public static void main(String[] args)
    {
        if(args.length != 3) // error, number of arguments
        {
            System.out.println("Error! Wrong number of arguments in input, please try again.");
            return;
        }

        if(!args[1].equals("-d")) // another error
        {
            System.out.println("Error! Use \"-d\".");
            return;
        }

        try {
            mostActive(args);
        } catch (Exception e) {
            System.out.println("Error! Make sure inputs are correct, please try again.");
        }
    }

    public static void mostActive(String[] args) throws FileNotFoundException
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        HashMap<String, Integer> freq = new HashMap<String, Integer>();
        LocalDate dateSearching = LocalDate.parse(args[2], dtf);

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            br.readLine();

            String input;
            while((input = br.readLine()) != null)
            {
                String[] inputArr = input.split(",");
                if(inputArr.length != 2) // incorrect csv formatting
                {
                    throw new RuntimeException();
                }
                LocalDate inputDate = LocalDate.parse(inputArr[1].substring(0, 10), dtf);
                if(dateSearching.equals(inputDate))
                {
                    int currCookieFreq = 1;
                    if(freq.containsKey(inputArr[0]))
                    {
                        currCookieFreq = freq.get(inputArr[0]) + 1;
                    }
                    freq.put(inputArr[0], currCookieFreq);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! File name " + args[0] + " was not correct.");
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Error! csv format was wrong.");
            return;
        }


        ArrayList<String> cookies = new ArrayList<String>();

        int currMax = -1;

        for(String s : freq.keySet()) // adds the cookies to print
        {
            if(freq.get(s) > currMax)
            {
                currMax = freq.get(s);
                cookies.clear();
                cookies.add(s);
            }
            else if(freq.get(s) == currMax)
            {
                cookies.add(s);
            }
        }

        for(String s : cookies)
        {
            System.out.println(s);
        }
    }
}