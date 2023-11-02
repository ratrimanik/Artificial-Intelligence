package Variabel;

public class GRE {
    public static double gre;
    // baut variabel titik-titik range pada model fuzzy nya, agar mudah untuk
    // mengganti nilaiketika ada perubahan
    private static double titik1 = 0;
    private static double titik2 = 800;
    private static double titik3 = 1200;
    private static double titik4 = 1800;

    // buat method untuk mengakses nilai pada variabel persediaan
    public static double getGRE() {
        return gre;
    } // buat method untuk memberikan nilai pada variabel persediaan

    public static void setgre(double gre) {
        GRE.gre = gre;
    } // method fungsi sedikit

    public static double low() {
        if (gre >= titik1 && gre <= titik2) {
            return 1;
        } else if (gre > titik2 && gre < titik3) {
            return (titik3 - gre) / (titik3 - titik2);
        } else {
            return 0;
        }
    }

    // method fungsi banyak
    public static double medium() {
        if (gre > titik2 && gre < titik3) {
            return (gre - titik2) / (titik3 - titik2);
        } else if (gre >= titik3 && gre <= titik4) {
            return (gre - titik3) / (titik4 - titik3);
        } else {
            return 0;
        }
    }

    public static double high() {
        if (gre > titik3 && gre < titik4) {
            return (gre - titik3) / (titik4 - titik3);
        } else if (gre >= titik4) {
            return 1;
        } else {
            return 0;
        }
    }
}
