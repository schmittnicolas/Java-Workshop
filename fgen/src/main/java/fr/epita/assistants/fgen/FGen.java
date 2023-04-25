package fr.epita.assistants.fgen;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FGen {
    private Path path;

    public FGen(final String inputPath) {
        path = Paths.get(System.getProperty("user.dir"));
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(inputPath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] subLine = line.split(" ");
                String opcode = subLine[0];
                String relativePath = subLine[1];
                switch (opcode) {
                    case "+":
                        Path newPath = path.resolve(relativePath);
                        if (!Files.exists(newPath.getParent())) {
                            Files.createDirectories(newPath.getParent());
                        }
                        if (relativePath.endsWith("/")) {
                            Files.createDirectory(newPath);
                        } else {
                            Files.createFile(newPath);
                        }
                        break;
                    case ">":
                        Path target = path.resolve(relativePath);
                        if (!Files.exists(target) && !Files.isDirectory(target)){
                            throw new RuntimeException();
                        }
                        path = target;
                        break;
                    case "-":
                        deleteDirectory(new File(path.toString() + "/" + relativePath));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    boolean deleteDirectory(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDirectory(f);
            }
        }
        return file.delete();
    }
}
