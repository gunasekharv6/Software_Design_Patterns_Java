import java.util.List;

public class Binary implements FileAPI{
    private FileAPI file;
    private List<String> fileContent;
    private FileType filetype = FileType.BINARY;


    @Override
    public void open() {
        System.out.println("Opening Binary file");
    }

    @Override
    public void read() {
        System.out.println("Reading Binary file");
    }

    @Override
    public void write(List<String> programData) {
        System.out.println("Writing to Binary file");
    }

    @Override
    public void close() {
        System.out.println("Closing Binary file");
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
