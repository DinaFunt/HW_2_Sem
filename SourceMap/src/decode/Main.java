package decode;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] Args) throws IOException {
        ArrayList<String> result = new ArrayList<>();

        ParseFile pr = new ParseFile("Text.txt");

        Decoder dec = new Decoder();

        for (int i = 1; i < pr.mappings.length; i++) {
            if (pr.mappings[i].length() > 0) {
                String s = dec.WordToFinalString(pr.mappings[i]);
                result.add(s);
            }
        }

        Writer wr = new Writer("Text2.txt", pr.file, pr.source);
        wr.AddLine(result, pr.names);
    }
}