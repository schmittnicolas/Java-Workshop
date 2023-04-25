package fr.epita.assistants.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class Json {
    public static void addToJson(String string, String value, String dstFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        try {
            File file = new File(dstFile);
            if (file.exists() && file.length() > 0) {
                rootNode = (ObjectNode) objectMapper.readTree(file);
            }

            rootNode.put(string, value);
            objectMapper.writeValue(file, rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
