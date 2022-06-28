package hms.reservation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class PeakSeasonChargeInfoSave {

    public void InChargeInfo(int index, int room, String people, String roomcharge, String extracharge, String maxpeople) throws IOException {

        File file = new File("C:\\DB\\peakFee.txt");
        String dummy = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;

            for (int i = 0; i < index - 1; i++) {
                line = br.readLine();
                dummy += (line + "\r\n");
            }

            br.readLine();
            dummy += (room + " " + people + " " + roomcharge + " " + extracharge + " " + maxpeople + "\r\n");

            while ((line = br.readLine()) != null) {
                dummy += (line + "\r\n");
            }
            FileWriter fw = new FileWriter("C:\\DB\\peakFee.txt");

            fw.write(dummy);
            fw.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
