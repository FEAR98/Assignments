package BufferedStream;

public interface FileReadWrite
{
    String read(String filePath);
    void write(String filePath, String data);
}
