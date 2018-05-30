package controller.singletons;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReading {

    private static FileReading fileReadingInstance;

    private FileReading() {
    }

    public static FileReading getInstance() {
        if (fileReadingInstance == null) {
            fileReadingInstance = new FileReading();
        }
        return fileReadingInstance;
    }

    public Collection<String> getFilledLinesListInFile() throws IOException, URISyntaxException {
        final String FILE = "file" + File.separator + "HotelReservation.txt";
        Path filePath = Paths.get(getClass().getClassLoader().getResource(FILE).toURI());
        Stream<String> filledLines = Files.lines(filePath, StandardCharsets.ISO_8859_1);
        List<String> filledLinesList = filledLines.collect(Collectors.toList());
        return filledLinesList;
    }
}
