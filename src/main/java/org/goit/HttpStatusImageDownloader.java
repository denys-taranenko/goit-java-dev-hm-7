package org.goit;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws IOException {

        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String image = httpStatusChecker.getStatusImage(code);
        String file = code + ".jpg";

        URL url = new URL(image);
        URLConnection urlConnection = url.openConnection();

        try (BufferedInputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
             FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            byte[] bytes = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(bytes, 0, bytes.length)) != - 1) {
                fileOutputStream.write(bytes, 0, bytesRead);
            }
        }
    }
}
