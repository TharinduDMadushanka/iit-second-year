public class Main {
    public static void main(String[] args) {

        /**
         *  checks for object reference equality
         */

        Integer x = 1;
        Integer y = 1;
        System.out.println(x == y); //true

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b); // false

        /**
         * operator compares their values directly, not object references.
         */
        int c = 1;
        int d = 1;
        System.out.println(c == d); //true

        int e = 128;
        int f = 128;
        System.out.println(e == f); //true

    }
}
