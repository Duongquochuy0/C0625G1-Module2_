package ss19_string_regex.bai_tap;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream(), "UTF-8" ));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", " ");
            Pattern p = Pattern.compile("title=\"(.*?)\"");
            Matcher m = p.matcher(content);
            while (m.find()) {
                String title = m.group(1);
                System.out.println(title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
