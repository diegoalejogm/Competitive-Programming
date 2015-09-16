package ch1.Exercise123;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Diego on 5/22/15.
 */
public class Two {

    public static void main(String[] args) {

        Scanner io = new Scanner(new InputStreamReader(System.in));
        short s = io.nextShort();

        System.out.printf("%."+s+"f", Math.PI);
    }
}
