package ch1.Exercise123;

import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Diego on 5/22/15.
 */
public class Four {

    public static void main(String[] args) {

        Scanner io = new Scanner(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        while(io.hasNextInt())
        {
            int next = io.nextInt();
            list.add(next);
        }
        Collections.sort(list);
        System.out.println(list);

    }

}
