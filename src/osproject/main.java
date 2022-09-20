package osproject;

import java.util.Scanner;

public class main {

    Scanner sc = new Scanner(System.in);
    int selectedOption;

    public void showMenu() {
        FCFS f = new FCFS();
        SJFNP s = new SJFNP();
        SJFP ss = new SJFP();
        RR r = new RR();
        
        System.out.println("Please Select an option below:");
        System.out.println("Press 1 for FCFS ");
        System.out.println("Press 2 for SJFNP ");
        System.out.println("Press 3 for SJFP ");
        System.out.println("Press 4 for RR ");
        System.out.println("Press any key to Exit");
        System.out.println(" ");
        System.out.println("Press any key: ");
        selectedOption = sc.nextInt();
        switch (selectedOption) {
            case 1:
                // first come first serve
                f.FCFS();
                showMenu();
                break;
            case 2:
                // short job first - non preemptive 
                s.SJFNP();
                showMenu();
                break;
            case 3:
                // short job first - preemptive
                ss.SJFP();
                showMenu();
                break;
            case 4:
                // round robin 
                r.RR();
                showMenu();
                break;
            default:
                System.out.println("Program Ended");
                System.exit(0);
                break;
        }
    }

    public static void main(String[] args) {

        main m = new main();
        m.showMenu();

    }
}
