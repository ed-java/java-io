import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UsingID {

    private static final String MY_FILE = "/root/java-io/file-using-io.txt";

    public UsingID() {
        writeFile();
        readFile();
    }

    private void writeFile() {
        try {
            final File file = new File(MY_FILE);
            boolean fileCreated = false;

            if (!file.exists()) {
                fileCreated = file.createNewFile();
            }

            if (fileCreated || file.exists()) {
                OutputStream output = new FileOutputStream(file);
                output.write("Olá mundo IO\nMundo IO HERE\n".getBytes("UTF-8"));
                output.close();
                System.out.println("Arquivo escrito com sucesso.");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(MY_FILE));
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println("Lido: " + linha);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UsingID();
    }
}
