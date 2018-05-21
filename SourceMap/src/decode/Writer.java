package decode;

import java.io.*;
import java.util.ArrayList;

public class Writer {
    private String OutFileName;
    private String file;
    private String source;


    public Writer(String Out, String files, String sources) {
        OutFileName = Out;
        file = files;
        source = sources;
    }

    public void AddLine(ArrayList<String> str, String[] names) {
        str.add(0, "Input file: " + source + "; Output file: " + file);
        StringBuilder n = new StringBuilder("Names with indexes: ");
        int j = 0;
        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > 1) {
                n.append(j).append(")").append(names[i]).append(" ");
                j++;
            }
        }
        str.add(1, n.toString());

        try
        {
            OutputStream f = new FileOutputStream(OutFileName, true);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);

            for (String aStr : str) {
                out.write(aStr);
                out.write("\n");
                out.flush();
            }
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }

    }

}
