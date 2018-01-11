import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.IOException;
// import org.sql2o.*;

public class App {
    public static void main(String[] args)
    {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";
        OkHttpClient client = new OkHttpClient();

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null)
        {
            port = Integer.parseInt(process.environment().get("PORT"));
        }
        else
        {
            port = 4567;
        }

        setPort(port);

        get("/", (req, res) -> {
            Request request = new Request.Builder()
                .url("https://api.fixer.io/latest")
                .build();

            String base = null;

            try {
                Response response = client.newCall(request).execute();

                String data = response.body().string();

                try {
                  JSONObject jsonData = new JSONObject(data);
                  base = jsonData.getString("base");
                } catch (JSONException e) {
                  e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            Map<String, Object> model = new HashMap<String, Object>();
            model.put("base", base);
            model.put("template", "templates/converter.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
