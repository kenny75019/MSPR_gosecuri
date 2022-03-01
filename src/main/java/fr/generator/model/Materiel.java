package fr.generator.model;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Materiel {
    private String code;
    private String label;

    public Materiel(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public static List<Materiel> getLesMaterielsParFichier(String path) throws IOException {
        Path filePath = Path.of(path);
        List<String> lines = Files.readAllLines(filePath);
        List<Materiel> lesMateriels = new ArrayList<>();
        for (String line: lines) {
            int idxFirstSpace = line.indexOf(" ");
            String code = line.substring(0, idxFirstSpace);
            String label = line.substring(idxFirstSpace).strip();
            Materiel m = new Materiel(code, label);
            lesMateriels.add(m);
        }
        return lesMateriels;
    }

    @Override
    public String toString(){
        return label;
    }
}
