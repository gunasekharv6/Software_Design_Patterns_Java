import java.util.ArrayList;
import java.util.List;

public class TextFile implements FileAPI{
    private String fileName = "NotePad";
    private String location = "./textfile Location";
    private List<String> fileContent = new ArrayList<>();
    private FileType filetype = FileType.TEXT;


    @Override
    public void open() {
        System.out.println("Opening the FILE: " + fileName);
    }

    @Override
    public void read() {
        System.out.println("Reading the FILE: " + fileName + " from LOCATION: " + location);
    }

    @Override
    public void write(List<String> programData) {
        for(String s : programData){
            fileContent.add(s);
        }
        System.out.println("Writing the FILE: " + fileName + " to LOCATION: " + location);
    }

    @Override
    public void close() {
        System.out.println("Closing the FILE: " + fileName);
    }

    @Override
    public List<String> getContent() {
        return fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getFileContent() {
        return fileContent;
    }

    public void setFileContent(List<String> fileContent) {
        this.fileContent = fileContent;
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
