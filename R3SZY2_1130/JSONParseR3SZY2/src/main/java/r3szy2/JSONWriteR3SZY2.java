package r3szy2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONWriteR3SZY2 {
    public static void writeJSON() {
		JSONObject obj = new JSONObject();
		
		JSONArray vizsgak = new JSONArray();
		vizsgak.add("adatkezeles xmlben");
		vizsgak.add("valoszinusegszamitas");
		vizsgak.add("mesterseges intelligencia");

		obj.put("vizsgak", vizsgak);

		try {

			FileWriter file = new FileWriter("vizsgak1R3SZY2.json");
			file.write(obj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("fajlba irt xml:\n" + obj.toJSONString());

	}
}
