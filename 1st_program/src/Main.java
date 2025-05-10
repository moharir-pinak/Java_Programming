import  java.util.Arrays;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
;        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.print("Hello and welcome!");

        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//        for (int i = 1; i <= 5; i++)
//            System.out.println("i = " + i);

        //for creating arrays

        int[] marks = new int[3];                    //arrays are non premetive so we need to use the new keyword here
        //assigning values
        marks[0] = 99;
        marks[1] = 97;
        marks[2] = 98;

//        System.out.println(marks[1]);

        // to find length
        System.out.println(marks.length);

        // To sort array the function is sort and we need to import the java.util.Arrays package
        System.out.println(marks[0]);
        Arrays.sort(marks);
        System.out.println(marks[0]);
   }
}