package Exercise123;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Diego on 5/22/15.
 */
public class One {



    public static void main(String[] args)
    {
        Scanner io = new Scanner(new InputStreamReader(System.in));

        Double d = io.nextDouble();
        System.out.printf("%7.3f %n", d);


    }
}
