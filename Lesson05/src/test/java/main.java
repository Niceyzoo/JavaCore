import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws IOException {

        File a = new File("./test.csv");
        a.createNewFile();

        String outputFileName = "test.csv";

        AppData ad = new AppData(new String[]{"Value1", "Value2", "Value3"}, new int[][]{{100, 200, 300}, {400, 500, 600}});

        try (BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName))) {

            for (String value : ad.head) {
                writter.write(value + ";");
            }
            writter.write("\n");

            for (int i = 0; i < ad.data.length; i++) {
                for (int j = 0; j < ad.data[0].length; j++) {
                    writter.write(ad.data[i][j] + ";");
                }
                writter.write("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<AppData> w = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader("test.csv"))) {

            String result = null;

            while ((result = in.readLine()) != null) {
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class AppData implements Serializable {
        private String[] head;
        private int[][] data;

        public AppData(String head[], int data[][]) {
            this.head = head;
            this.data = data;

        }


    }
}
