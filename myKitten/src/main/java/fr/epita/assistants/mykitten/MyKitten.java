package fr.epita.assistants.mykitten;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyKitten {
    /**
     * Initializer.
     *
     * @param srcPath Source file path.
     */
    public MyKitten(String srcPath) {
        Path file = Paths.get(srcPath);

        try {
            streamContent = Files.readAllLines(file).stream();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Use the streamContent to replace `wordToReplace` with "miaou". Don't forget
     * to add the line number beforehand for each line. Store the new
     * result directly in the streamContent field.
     *
     * @param wordToReplace The word to replace
     */
    public void replaceByMiaou(String wordToReplace) {

        List<String> list = streamContent.toList();

        streamContent = IntStream.range(0, (int) list.stream().count()).mapToObj(index -> String.format("%d %s", index + 1, list.get(index).replaceAll(wordToReplace, "miaou")));
    }

    /**
     * Use the streamContent to write the content into the destination file.
     *
     * @param destPath Destination file path.
     */
    public void toFile(String destPath) {
        Path file = Paths.get(destPath);

        try {
            Files.write(file, streamContent.toList(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates an instance of MyKitten and calls the above methods to do it
     * straightforwardly.
     *
     * @param srcPath       Source file path
     * @param destPath      Destination file path
     * @param wordToReplace Word to replace
     */
    public static void miaou(String srcPath, String destPath, String wordToReplace) {
        MyKitten myKitten = new MyKitten(srcPath);
        myKitten.replaceByMiaou(wordToReplace);
        myKitten.toFile(destPath);
    }

    public Stream<String> streamContent;
}
