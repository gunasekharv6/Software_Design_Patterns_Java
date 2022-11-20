import java.util.ArrayList;
import java.util.List;

public class FileFacade implements FacadeAPI{
    private FileAPI file;

    public FileFacade(FileAPI file) {
        this.file = file;
    }

    @Override
    public void save(List<String> programData) {
        System.out.println("Demonstrating FileFacade SAVE method for: "+file.getFiletype()+ " file type");
        file.open();
        file.write(programData);
        file.close();
    }

    @Override
    public List<String> load() {
        System.out.println("Demonstrating FileFacade LOAD method for: "+file.getFiletype()+ " file type");
        file.open();
        file.read();
        return file.getContent();
    }

    public FileAPI getFile() {
        return file;
    }

    public void setFile(FileAPI file) {
        this.file = file;
    }

    public static void demo(){
        List<String> data = new ArrayList<>();
        {
            data.add("Guna");
            data.add("Sekhar");
            data.add("Shiva");
        }

        // Binary File
        Binary binaryFile = new Binary();
        FileFacade fileFacade = new FileFacade(binaryFile);
        fileFacade.load();
        fileFacade.save(data);
        System.out.println();

        //JSON File
        JSON jsonFile = new JSON();
        fileFacade.setFile(jsonFile);
        fileFacade.load();
        fileFacade.save(data);
        System.out.println();


        //XML File
        Xml xmlFile = new Xml();
        fileFacade.setFile(xmlFile);
        fileFacade.load();
        fileFacade.save(data);
        System.out.println();

        //Text File
        TextFile textFile = new TextFile();
        fileFacade.setFile(textFile);
        System.out.println(fileFacade.load());
        fileFacade.save(data);
        System.out.println();

    }
}
