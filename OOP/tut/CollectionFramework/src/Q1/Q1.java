package Q1;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {

        int[] a = {7};
        int[] b = {3,6};
        int[] c = {4,6,8};
        int[] d = {1,2,3,4};
        int[] e = {8,4,2,0,4};

        loadArray(a);
        loadArray(b);
        loadArray(c);
        loadArray(d);
        loadArray(e);


    }

    public static void loadArray(int[] list) {
        for (int i = 1; i < list.length; i++)
        {
            list[i] = list[i] + list[i - 1];
//            System.out.println(list[i]);
        }
        System.out.println(Arrays.toString(list));

    }
}
