package fr.epita.assistants.embedfiles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {
    public static void main(String[] args) {
        final var embedFile = new DisplayEmbedFile("sample.txt");
        final var result = embedFile.display().orElseThrow();
        assertTrue(result.contains("This is a sample"));
    }
}
