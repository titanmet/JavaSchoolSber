package fileReader;

import java.util.Arrays;

public class FileData {
   private final String[] lines;


    public FileData(String[] lines) {
        this.lines = lines;
    }


    @Override
    public String toString() {
        return Arrays.toString(lines);
    }
}
