package demo;

import org.json.JSONException;
import org.json.JSONObject;

public class ConvertJson {

    public static JSONObject convert(String jsonString) {
        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
