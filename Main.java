import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String nameFile = "src/Trapezoid.csv";
        List<Trapezoid> trapezoids = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Trapezoid trapezoid = new Trapezoid();
                trapezoid.sisiA = Double.parseDouble(row[0]);
                trapezoid.sisiB = Double.parseDouble(row[1]);
                trapezoid.tinggi = Double.parseDouble(row[2]);
                trapezoids.add(trapezoid);
            }

            for (Trapezoid t : trapezoids) {
                System.out.println("Luas Trapesium : " + t.hitungLuas());
                System.out.println("Keliling Trapesium: " + t.hitungKeliling());
            }

            trapezoids.sort(Comparator.comparingDouble(Trapezoid::hitungKeliling));

            System.out.println("Trapesiums sorted by perimeter:");
            for (Trapezoid t : trapezoids) {
                System.out.println(t.hitungKeliling());
            }

            String f = "src/Tampilkan.txt";
            try (FileWriter tulis = new FileWriter(f)){
                for (Trapezoid t : trapezoids) {
                    tulis.write(t.sisiA + "," + t.sisiB + "," + t.tinggi);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
