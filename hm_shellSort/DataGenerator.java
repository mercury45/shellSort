import java.io.*;

public class DataGenerator {
    public static void main(String[] args) {
        File file = new File("data.txt");
        try {
            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(file));
            int numberOfGroups = 50 + (int)(Math.random()*50);
            out.write(numberOfGroups + "\n");
            for (int i = 0; i < numberOfGroups; i++) {
                int numberOfIntegers = 100 + (int) (Math.random() * 9900);
                out.write(Integer.toString(numberOfIntegers) + "\n");
                for (int j = 0; j < numberOfIntegers; j++) {
                    String num = Integer.toString((-10000 + (int)(Math.random() * 20000)));
                    out.write(num);
                    if (j != numberOfIntegers - 1) {
                        out.write(" ");
                    }
                }
                out.write("\n");
            }
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
