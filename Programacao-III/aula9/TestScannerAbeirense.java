package aula9;

import java.io.*;

public class TestScannerAbeirense {
    public static void main(String[] args) throws IOException {
        // Test InputStream
        ScannerAbeirense sc = new ScannerAbeirense(System.in);

        System.out.println(sc.nextLine());
        System.out.println(sc.next());

        sc.close();

        // Test File
        File f = new File("./aula9/TestFileEx1.txt");
        ScannerAbeirense scf = new ScannerAbeirense(f);

        while(scf.hasNextLine()) {
            System.out.println(scf.nextLine());
        }

        scf.close();
    }
}
