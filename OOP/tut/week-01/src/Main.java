import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] marks = new int[6];
        int sum = 0;
        int below_40 = 0;
        int between_40_49 = 0;
        int between_50_59 = 0;
        int between_60_69 = 0;
        int above_70 = 0;

        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter mark " + (i+1) + ":");
            marks[i] = scanner.nextInt();
        }

        System.out.println("========== Student Marks ==========");

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Student "+(i+1)+": "+marks[i]);
            sum += marks[i];

            if (marks[i] < 40){
                below_40++;
            }else if (marks[i] < 49 && marks[i] > 40){
                between_40_49++;
            }else if (marks[i] < 59 && marks[i] > 50 && marks[i] < 59){
                between_50_59++;
            } else if (marks[i] < 69 && marks[i] > 60) {
                between_60_69++;
            }else if (marks[i] >= 70){
                above_70++;
            }

        }

        System.out.println("The sum of all marks is -> "+sum);
        System.out.println("marks are below 40: "+below_40);
        System.out.println("marks are between 40 to 49: "+between_40_49);
        System.out.println("marks are between 50 to 59: "+between_50_59);
        System.out.println("marks are between 60 to 69: "+between_60_69);
        System.out.println("marks are above 70: "+above_70);

        System.out.println("=========== Marks Avg ============");
        calcAvg(sum);

        System.out.println("=========== Max Marks ============");
        findMax(marks);

        System.out.println("=========== Min Marks ============");
        finMin(marks);

        System.out.println("=========== Sorted Array ============");
        sortMarks(marks);
    }

    public static void calcAvg(double sum){
        double avg = sum / 6;
        System.out.println("The average of all marks is -> "+avg);
    }

    public static void findMax(int[] marks){
        int max = marks[0];

        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > max){
                max = marks[i];
            }
        }
        System.out.println("The maximum marks is -> "+max);
    }

    public static void finMin(int[] marks){
        int min = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < min){
                min = marks[i];
            }
        }
        System.out.println("The minimum marks is -> "+min);
    }

    public static void sortMarks(int[] marks){
        Arrays.sort(marks);
        for (int num : marks) {
            System.out.print(num+" ");
        }
    }
}