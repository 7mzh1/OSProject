package osproject;

import java.util.Scanner;

public class RR {

    public void RR() {
        int n
                , i         //Process
                , qt        //quantum time
                , count = 0
                , temp
                , sq = 0
                , bt[]      //Burst Time
                , wt[]      //Waiting Time
                , tat[]     //Turnaround Time
                , rem_bt[];
            float awt = 0   //Average waiting Time
                , atat = 0; //Average turnaround time
        bt = new int[10];
        wt = new int[10];
        tat = new int[10];
        rem_bt = new int[10];
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter the number of process (maximum 10) = ");
            a=sc.nextInt();
        }while(a<0);
        n = a;
        System.out.print("Enter the burst time of the process\n");
        for (i = 0; i < n; i++) {
            do {
                System.out.print("P" + i + " = ");
                b = sc.nextInt();
            }while(b<0);
            bt[i] = b;
            rem_bt[i] = bt[i];
        }
        do {
            System.out.print("Enter the quantum time: ");
             c = sc.nextInt();
             if (c<0){
                 System.out.println("negative numbers not accepted");
             }
        }while(c<0);
        qt = c;
        while (true) {
            for (i = 0, count = 0; i < n; i++) {
                temp = qt;
                if (rem_bt[i] == 0) {
                    count++;
                    continue;
                }
                if (rem_bt[i] > qt) {
                    rem_bt[i] = rem_bt[i] - qt;
                } else if (rem_bt[i] >= 0) {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq + temp;
                tat[i] = sq;
            }
            if (n == count) {
                break;
            }
        }
        System.out.print("-----------------------------------------------------------------------------");
        System.out.print("\nProcess\t Burst Time\t Turnaround Time\t Waiting Time\n");
        System.out.print("-----------------------------------------------------------------------------");
        for (i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            awt = awt + wt[i];
            atat = atat + tat[i];
            System.out.print("\n" + (i + 1) + "     \t " + bt[i] + "\t\t " + tat[i] + "\t\t\t " + wt[i] + "\n");
        }
        awt = awt / n;
        atat = atat / n;
        System.out.println("\nAverage waiting Time = " + awt + "\n");
        System.out.println("Average turnaround time = " + atat);
        System.out.println("");
        System.out.println("");
    }

}
