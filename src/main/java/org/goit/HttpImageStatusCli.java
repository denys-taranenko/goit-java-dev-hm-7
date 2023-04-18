package org.goit;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {

        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");

        boolean ok = false;
        String code = "";

        while (!ok) {
            code = scanner.nextLine();
            if (code.matches("\\d{3}")) {
                ok = true;
            } else {
                System.out.println("Please enter valid number");
            }
        }
        scanner.close();

        try {
            httpStatusImageDownloader.downloadStatusImage(Integer.parseInt(code));
        } catch (IOException e) {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
