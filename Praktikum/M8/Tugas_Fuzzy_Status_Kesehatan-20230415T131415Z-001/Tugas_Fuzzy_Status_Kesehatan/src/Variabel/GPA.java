package Variabel;

public class GPA {
    public static double gpa;
    // baut variabel titik-titik range pada model fuzzy nya, agar mudah untuk
    // mengganti nilai ketika ada perubahan
    private static double titik1 = 0;
    private static double titik2 = 2.2;
    private static double titik3 = 3.0;
    private static double titik4 = 3.8;

    // buat method untuk mengakses nilai pada variabel persediaan
    public static double getGPA() {
        return gpa;
    }

    // buat method untuk memberikan nilai pada variabel persediaan
    public static void setGPA(double gpa) {
        GPA.gpa = gpa;
    }

    public static double low() {
        if (gpa >= titik1 && gpa <= titik2) {
            return 1;
        } else if (gpa > titik2 && gpa < titik3) {
            return (titik3 - gpa) / (titik3 - titik2);
        } else {
            return 0;
        }
    }

    // method fungsi banyak
    public static double medium() {
        if (gpa > titik2 && gpa < titik3) {
            return (gpa - titik2) / (titik3 - titik2);
        } else if (gpa >= titik3 && gpa <= titik4) {
            return (gpa - titik3) / (titik3 - titik3);
        } else {
            return 0;
        }
    }

    public static double high() {
        if (gpa > titik3 && gpa < titik4) {
            return (gpa - titik3) / (titik4 - titik3);
        } else if (gpa >= titik4) {
            return 1;
        } else {
            return 0;
        }
    }
}
