package r3szy2;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class JSONReadR3SZY2 {
    public static void readJSON(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(filename);

        Object object = parser.parse(reader);
        JSONObject jsonobject = (JSONObject) object;

        String val = (String) jsonobject.get("vizsga");

        System.out.println("vizsga: " + val);
    }
}
