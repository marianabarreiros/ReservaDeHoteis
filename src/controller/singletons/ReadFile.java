package controller.singletons;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    private static ReadFile readFileInstance;

    private ReadFile() {
    }  
    
    public static ReadFile getInstance(){
        if(readFileInstance == null)
            readFileInstance =  new ReadFile();
        return readFileInstance;
    }
    
    public List<String> getListaDeEntradas() throws IOException, URISyntaxException {
        final String FILE = "file" + File.separator + "HotelReservation.txt";
        Path caminho = Paths.get(getClass().getClassLoader().getResource(FILE).toURI());
        Stream<String> linhas = Files.lines(caminho, StandardCharsets.ISO_8859_1);
        List<String> listaDeLinhas = linhas.collect(Collectors.toList());
        return listaDeLinhas;
    }
}
