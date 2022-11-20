import java.util.List;

public class JSON implements FileAPI{
    private FileAPI file;
    private FileType filetype = FileType.JSON;

    @Override
    public void open() {
        System.out.println("Opening JSON file");
    }

    @Override
    public void read() {
        System.out.println("Reading JSON file");
    }

    @Override
    public void write(List<String> programData) {
        System.out.println("Writing to JSON file");
    }

    @Override
    public void close() {
        System.out.println("Closing JSON file");
    }

    @Override
    public List<String> getContent() {
        return null;
    }

    @Override
    public FileType getFiletype() {
        return filetype;
    }

    @Override
    public void setFiletype(FileType filetype) {
        this.filetype = filetype;
    }
}
