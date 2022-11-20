import java.util.List;

public class Xml implements FileAPI{
    private FileAPI file;
    private FileType filetype = FileType.XML;

    @Override
    public void open() {
        System.out.println("Opening XML file");
    }

    @Override
    public void read() {
        System.out.println("Reading XML file");
    }

    @Override
    public void write(List<String> programData) {
        System.out.println("Writing to XML file");
    }

    @Override
    public void close() {
        System.out.println("Closing XML file");
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
