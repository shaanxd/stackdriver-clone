package repository.content;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileContentRepository implements ContentRepository {
    private String filePath;

    public FileContentRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readLogs() {
        List<String> logs = new ArrayList<>();
        try {
            logs = Files.readAllLines(Paths.get(filePath));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return logs;
    }
}
