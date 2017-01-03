package ch1.Exercise123;

import java.util.Arrays;

/**
 * Created by Diego on 5/22/15.
 */
public class Six {

    public static void main(String[] args) {

        int[] array = {1, 5, 7, 53, 63, 71, 73, 82, 91, 93};
        System.out.println(Arrays.binarySearch(array, 93));
    }
}
