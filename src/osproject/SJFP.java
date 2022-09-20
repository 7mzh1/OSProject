package osproject;

import java.util.*;

public class SJFP {

    public void SJFP() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of process:");
        int n = sc.nextInt();
        int pid[] = new int[n];// it takes pid of process
        int at[] = new int[n]; // at means arrival time
        int bt[] = new int[n]; // bt means burst time
        int ct[] = new int[n]; // ct means complete time
        int ta[] = new int[n]; // ta means turn around time
        int wt[] = new int[n]; // wt means waiting time
        int f[] = new int[n];  // f means it is flag it checks process is completed or not
        int k[] = new int[n];  // it is also stores brust time
        int i, st = 0
                , tot = 0; // total no of process
        float avgwt = 0, avgta = 0;
        int a,b;
        for (i = 0; i < n; i++) {
            do {
                pid[i] = i + 1;
                System.out.println("enter process " + (i + 1) + " arrival time:");
                a = sc.nextInt();
                if (a<0){
                    System.out.println("negative number not excepted");
                }
            }while(a<0);
            at[i]=a;
            do {
                System.out.println("enter process " + (i + 1) + " burst time:");
                b = sc.nextInt();
                if(b<0){
                    System.out.println("negative numbers not excepted ");
                }
            }while(b<0);
            bt[i] = b;
            k[i] = bt[i];
            f[i] = 0;
        }
        while (true) {
            int min = 99, c = n;
            if (tot == n) {
                break;
            }

            for (i = 0; i < n; i++) {
                if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }

            if (c == n) {
                st++;
            } else {
                bt[c]--;
                st++;
                if (bt[c] == 0) {
                    ct[c] = st;
                    f[c] = 1;
                    tot++;
                }
            }
        }
        for (i = 0; i < n; i++) {
            ta[i] = ct[i] - at[i];
            wt[i] = ta[i] - k[i];
            avgwt += wt[i];
            avgta += ta[i];
        }
        System.out.println("pid  arrival  burst  complete turn waiting");
        for (i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + at[i] + "\t" + k[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }
        System.out.println("\naverage tat is " + (float) (avgta / n));
        System.out.println("average wt is " + (float) (avgwt / n));
        System.out.println("");
        System.out.println("");
    }
}
