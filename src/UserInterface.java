import java.io.*;
import java.awt.*;

public class UserInterface {
    public static void createInterface() {
        Console con = System.console();

        if(con == null && !GraphicsEnvironment.isHeadless()) {
            try {
                String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
                StringBuilder path = convertFilePath(filename);

                Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start", "cmd", "/k", "java -jar \"" + path + "\""});
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Converts unicode characters from filepath URL to proper characters; only works for spacebar
    private static StringBuilder convertFilePath(String s) {
        StringBuilder path = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '%' && s.charAt(i + 1) == '2' && s.charAt(i + 2) == '0') {
                path.append(" ");
                i += 2;
            } else {
                path.append(s.charAt(i));
            }
        }

        return path;
    }
}
