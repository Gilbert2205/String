package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    String s = "This is a demo of the getChars method. ";
        int start = 10;
        int end = 14;
        char buf[] = new char [end -start];
        s.getChars(start, end, buf,0);
        System.out.println(buf);

        String s1 = "Java";
        String s2 = new String("Java");
        System.out.println(s1==s2);
        s2=s2.intern();
        System.out.println(s1==s2);

        System.out.println();

        String S = "Now is the time for all good men" + "to come to the aid of the country.";
        System.out.println(S);
        System.out.println("index of(t)= " + S.indexOf('t'));
        System.out.println("last index of(t)= " + S.lastIndexOf('t'));
        System.out.println("index of(t,10)= " + S.indexOf('t', 10));
        System.out.println("last index of(t,60)= " + S.lastIndexOf('t', 60));

        System.out.println();

        "Hello".replace('l', 'w');

        System.out.println();

        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("buffer = " +sb);
        System.out.println("length = " + sb.length());
        System.out.println("capacity = " + sb.capacity());

        System.out.println();

        System.out.println("buffer before = " + sb);
        System.out.println("charAt(1) before = " + sb.charAt(1));
        sb.setCharAt(1, 'i');
        sb.setLength(2);
        System.out.println("buffer after = " + sb);
        System.out.println("charAt(1) after = " + sb.charAt(1));

        System.out.println();

        StringBuffer db = new StringBuffer("I Java!");
        db.insert(2, "like ");
        System.out.println(db);

        System.out.println();

        StringBuffer tb = new StringBuffer("This is a test");

        tb.delete(4, 7);
        System.out.println("After delete" + tb);
        tb.deleteCharAt(0);
        System.out.println("After deleteCharAt" + tb);

        //Создает объект Стринг, остальные работаю с готовым!!!ы

        String s3 = String.join(":", "foobar","foo", "bar");
        System.out.println(s3);


        System.out.println(Pattern.compile(":").splitAsStream("foobar:foo:bar").filter(s4->s4.contains("bar")).sorted().collect(Collectors.joining(":")));
        System.out.println();

        Locale current = Locale.getDefault();
        System.out.println(current);
        Locale.setDefault(Locale.CANADA);
        System.out.println(current);
        System.out.println(current.getCountry());
        System.out.println(current.getDisplayCountry());
        System.out.println(current.getLanguage());
        System.out.println(current.getDisplayLanguage());

        System.out.println();

        NumberFormat nfGe = NumberFormat.getInstance(Locale.GERMAN);
        NumberFormat nfUs = NumberFormat.getInstance(Locale.FRANCE);
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRANCE);
        double iGe = 0;
        double iUs = 0;
        double iFr=0;
        String str = "1.234,5";
        try{
            iGe = nfGe.parse(str).doubleValue();
            iUs = nfUs.parse(str).doubleValue();
            iFr = nfFr.parse(str).doubleValue();
        }catch (ParseException e){
            System.err.print("Error position: " + e.getErrorOffset());
        }
        System.out.printf("iGe = %f\niUs = %f\niFr=%f", iGe, iUs, iFr);
        String sUs = nfUs.format(iGe);
        String sFr= nfFr.format(iGe);
        System.out.println("\nUs" + sUs + "\nFr" + sFr);

        System.out.println();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.US);
        Date d = null;
        String str1 = "April 9, 2012";
        try {
            d = df.parse(str1);
            System.out.println(d);
        }catch (ParseException e ){
            System.err.print("Error position" + e.getErrorOffset());
        }
        df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru", "RU"));
        System.out.println(df.format(d));
        df = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMAN);
        System.out.println(df.format(d));


    }
}
