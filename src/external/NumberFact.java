package external;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NumberFact {
    String url;

    public NumberFact(int number){
        url = "http://numbersapi.com/" + number + "/math";
    }

    public void printFact() throws IOException{
        BufferedReader br = null;

        try {
            URL checkURL = new URL(url);
            br = new BufferedReader(new InputStreamReader(checkURL.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println("Here's a fun fact before you start your puzzle! " + sb);

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}