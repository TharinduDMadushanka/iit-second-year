package Q2;

import java.util.ArrayList;

public class Q2 {
    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();

//        int[] list1 = {5,10,15};
//        a.add(list1);

        a.add(5);
        a.add(10);
        a.add(15);

        listDemo(a);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(8);
        b.add(2);
        b.add(8);
        b.add(7);
        b.add(4);

        listDemo(b);

        ArrayList<Integer> c = new ArrayList<>();
        c.add(-1);
        c.add(3);
        c.add(28);
        c.add(17);
        c.add(9);
        c.add(30);

        listDemo(c);

    }

    public static void listDemo(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++)
        {
            int element = list.get(i);
            list.remove(i);
            list.add(0, element + 1);
        }
        System.out.println(list);
    }

}
