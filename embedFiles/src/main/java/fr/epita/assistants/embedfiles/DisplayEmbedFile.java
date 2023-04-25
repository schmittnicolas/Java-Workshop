package fr.epita.assistants.embedfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

public class DisplayEmbedFile {
    private final String filename;

    public DisplayEmbedFile(String filename) {
        this.filename = filename;
    }

    public Optional<String> display() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        if (inputStream == null){
            return Optional.empty();
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){

            String line;
            String res = "";
            while ((line = reader.readLine()) != null){
                res += line + "\n";
            }

            return Optional.of(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
