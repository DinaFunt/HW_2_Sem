package decode;

import java.io.*;

public class ParseFile {
    String version;
    String file;
    String source;
    String[] names;
    String[] mappings;

    ParseFile(String FileName) throws IOException {
        WorkWithFile(FileName);
    }

    private void WorkWithFile(String FileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FileName));
        String line = null;

        try {
            Version(reader.readLine());
            File(reader.readLine());
            Source(reader.readLine());
            Names(reader.readLine());
            Mappings(reader.readLine());

        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            reader.close();
        }
    }

    private static String LineFilter(String line) {
        line = line.replaceAll("[\\[\\]]", " ");
        line = line.replaceAll(":", " ");
        line = line.replaceAll("\"", "");
        line = line.replace(',', ' ');
        line = line.replace('\"', ' ');
        return line;
    }

    private void Version(String line){
        line = LineFilter(line);
        String[] temp = line.split(" ");
        version = temp[1];
    }

    private void Source(String line){
        line = LineFilter(line);
        String[] temp = line.split(" ");
        int i = 1;
        while (temp[i].equals("") || temp[i].equals(" ")) {
            i++;
        }
        source = temp[i];
    }

    private void File(String line){
        line = LineFilter(line);
        String[] temp = line.split(" ");
        int i = 1;
        while (temp[i].equals("") || temp[i].equals(" ")) {
            i++;
        }
        file = temp[i];
    }

    private void Names(String line) {
        line = LineFilter(line);
        names = line.split(" ");
    }

    private void Mappings(String line) {
        line = LineFilter(line);
        mappings = line.split(" ");
    }

}