package hms.check;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoomEmpty {

    public void Inguest(String num, String indexNum) throws IOException {

        File file = new File("C:\\DB\\room.txt");
        String newLine = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;

            for (int i = 0; i < Integer.parseInt(indexNum) - 1; i++) {
                line = br.readLine();
                newLine += (line + "\r\n");
            }

            br.readLine();
            newLine += (indexNum + " " + num + " " + "empty guestname num date checkintime guesscheckouttime\r\n");

            while ((line = br.readLine()) != null) {
                newLine += (line + "\r\n");
            }

            FileWriter fw = new FileWriter("C:\\DB\\room.txt");

            fw.write(newLine);

            fw.close();

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
