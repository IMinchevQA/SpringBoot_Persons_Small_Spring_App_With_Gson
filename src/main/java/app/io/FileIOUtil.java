package app.io;

import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by Ivan Minchev on 11/24/2017.
 */

@Component
public class FileIOUtil {
    public String read(String pathToFile) throws IOException {
        InputStream str = getClass().getResourceAsStream(pathToFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(str));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();
    }

    public void write(String content, String pathToFile) throws IOException {
        try (
            OutputStream outputStream = new FileOutputStream(pathToFile);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            writer.write(content);
        }
    }
}
