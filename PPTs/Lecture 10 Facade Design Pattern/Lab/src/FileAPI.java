import java.util.List;

public interface FileAPI {
    void open();
    void read();
    void write(List<String> programData);
    void close();
    List<String> getContent();

    FileType getFiletype();

    void setFiletype(FileType filetype);
}
