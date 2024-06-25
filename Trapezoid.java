public class Trapezoid {
    double sisiA;
    double sisiB;
    double tinggi;

    public double hitungLuas() {
        return 0.5 * (sisiA + sisiB) * tinggi;
    }


    public double hitungKeliling() {
        double sisiTegak = Math.sqrt(Math.pow((sisiB - sisiA) / 2, 2) + Math.pow(tinggi, 2));
        double keliling = sisiA + sisiB + 2 * sisiTegak;
        return keliling;
    }
}
