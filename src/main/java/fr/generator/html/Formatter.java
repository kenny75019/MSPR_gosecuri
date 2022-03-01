package fr.generator.html;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Formatter {
    public static String toHtml(String path, String title, String Content) throws IOException {
        Path filePath = Path.of(path);
        String html = Files.readString(filePath);
        return String.format(html, title, Content );
    }
}
