// Using File IO 1.0
// buscar codigos de josh bloch programador
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileInputStream;

public class UsingID2 {

private static final String MY_FILE = "file-using-io.txt"; // O arquivo será salvo no mesmo local de onde você roda o comando

public UsingID2() throws IOException {
writeFile(); 
readFile(); 
}

private void writeFile() throws IOException {

    /*
final File file = new File(MY_FILE);

boolean fileCreated = false; 
if(!file.exists()) {
fileCreated = file.createNewFile();
}
if (fileCreated || file.exists()) { 
    */
    
final OutputStream output = new FileOutputStream(MY_FILE); // FileOutputStream: Cria/sobrescreve o arquivo automaticamente
output.write("Ola mundo IO\nTOP!!!\nShow!!\nFoi!!\n".getBytes("UTF-8"));
output.close();
System.out.println("Dados gravados no arquivo");
}


// Ineficiente em arquivos grandes
// Dados brutos (sem significado direto como texto): .pdf, .jpg, .mp3, .docx
// NÃO recomendado para leitura de arquivos de texto (.txt, .csv) com acentuação
// Arquivo binário (foto.jpg) pode ser copiado com: "InputStream in = new FileInputStream("foto.jpg");"
/*
private void readFile() {
try {
final InputStream input = new FileInputStream(MY_FILE); // implementa a interface autocloseable
int content;
while ((content = input.read()) != -1) {
    System.out.print((char) content);
} 
} catch (IOException ex){
ex.printStackTrace();
}
}
*/

// Muito mais eficiente (usa buffer)
// Ideal para arquivos de texto legíveis: .txt, .csv, .html, .xml
// Respeita linhas, codificação e acentuação (ex: UTF-8)
// Arquivo texto (dados.txt) pode ser lido com: "BufferedReader br = new BufferedReader(new FileReader("dados.txt"));"
private void readFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(MY_FILE))) {
        String line;
        System.out.println("Conteúdo do arquivo:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}



public static void main(String[] args) throws IOException {
new UsingID2();
}
}