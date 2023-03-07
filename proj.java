
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class proj {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data);
            }
        } catch (IOException ex) {
            System.out.println("Ошибка!");
            ex.printStackTrace();
        }
        parserAndRequest(sb);

    }

    public static void parserAndRequest(StringBuilder sb) {
        Map<String, String> diction = new HashMap<String, String>();

        String[] keys = sb.toString().replace("{", "").replace("\"", "").replace("}", "").replaceAll("\\s", "")
                .split(",");
        for (String data : keys) {
            String[] keyValue = data.split(":");
            String key = keyValue[0];
            String value = keyValue[1];
            diction.put(key, value);
        }

        System.out.println(diction);
        String name = diction.get("name");
        String country = diction.get("country");
        String city = diction.get("city");
        System.out.printf("SELECT * FROM students WHERE name = %s AND country = %s AND city = %s", name,
                country, city);
    }
}