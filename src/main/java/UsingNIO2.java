import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UsingNIO2 {

private static final String MY_FILE = "file-using-nio2.txt";

public UsingNIO2 () {

try {
writeFile();
} catch (IOException ex) {
ex.printStackTrace();
}

System.out.println("----------------------------------------");

try {
readFile();
} catch (IOException ex) {
ex.printStackTrace();
}
}

private void writeFile() throws IOException {

final Path path = Paths.get(MY_FILE);
Files.writeString(path, "Ola mundo NIO2\nTop!!\nShow!!\n");

System.out.println("Dados gravados no arquivo");
}

private void readFile() throws IOException {

final Path path = Paths.get(MY_FILE);
// System.out.println(Files.readAllLines(path));
Files.readAllLines(path).forEach(System.out::println);

}

public static void main(String[] args) {

new UsingNIO2();

}
}