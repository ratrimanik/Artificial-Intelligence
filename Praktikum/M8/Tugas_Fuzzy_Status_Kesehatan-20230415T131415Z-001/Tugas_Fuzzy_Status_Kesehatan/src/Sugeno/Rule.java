package Sugeno;

import Variabel.*;
import java.util.Scanner;

public class Rule {
    private static double[] u_Status = new double[25];
    private static String[] z_Status = {
            "Excellent", "Very Good", "Fair",
            "Good", "Good", "Poor",
            "Fair", "Poor", "Poor",
    };
    private static String status;

    // rule
    public static void hitung_u() {
        u_Status[0] = Math.min(GPA.high(), GRE.high());
        u_Status[1] = Math.min(GPA.high(), GRE.medium());
        u_Status[2] = Math.min(GPA.high(), GRE.low());
        u_Status[3] = Math.min(GPA.medium(), GRE.high());
        u_Status[4] = Math.min(GPA.medium(), GRE.medium());
        u_Status[5] = Math.min(GPA.medium(), GRE.low());
        u_Status[6] = Math.min(GPA.low(), GRE.high());
        u_Status[7] = Math.min(GPA.low(), GRE.medium());
        u_Status[8] = Math.min(GPA.low(), GRE.low());
    }

    public static double hitung_z() {
        int i;
        double max = 0;
        for (i = 0; i < u_Status.length; i++)
            if (max < u_Status[i]) {
                max = u_Status[i];
                status = z_Status[i];
            }
        return max;
    }

    // cari nilai bobot (tsukamoto)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukan GPA: ");
        GPA.gpa = sc.nextDouble();
        System.out.print("Masukan GRE: ");
        GRE.gre = sc.nextDouble();
        hitung_u();
        for (int i = 0; i < 24; i++) {
            System.out.println("u_ke-" + i + " : " + u_Status[i]);
        }
        System.out.println("Bobot : " + hitung_z() + " dengan status :" + status);
    }
}
