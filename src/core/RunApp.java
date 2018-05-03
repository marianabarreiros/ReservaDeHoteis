package core;

import controller.singletons.ReadFile;
import model.hotel.Hotel;
import java.time.LocalDate;
import java.util.Set;
import controller.singletons.ValidatesDates;
import controller.singletons.ValidateFileLines;
import controller.validatefaile.ValidatePatternFile;

public class RunApp {

    public static void main(String[] Args) {
//        LEITURA DO ARQUIVO
        ReadFile rf = ReadFile.getInstance();
        ValidatePatternFile patternFile = new ValidatePatternFile(rf.readFile());
        
//        VALIDAR AS LINHAS E COLOCAR EM UM MAP
        ValidateFileLines vfl = ValidateFileLines.getInstance();
        vfl.parseFileLines(patternFile.validatePatternsFile());
        
//        FORMATAÇÃO DAS DATAS
//        ValidatesDates fd = ValidatesDates.getInstance();
//        Set<LocalDate> fds = fd.formatToDates(patternFile.validatePatternsFile());
//        System.out.println(fds);
        
//        CRIAÇÃO DOS HOTEIS
//        Hotel lakewood = new Hotel('3', 110, 90, 80, 80);
//        Hotel bridgewood = new Hotel('4', 160, 60, 110, 50);
//        Hotel ridgewood = new Hotel('5', 220, 150, 100, 40);

//        SimpleClientFactory scf = new SimpleClientFactory();
//        Client client = null;
//        try {
//            client = scf.creatClient("Regulam: 17Mar2009(Mon), 18Mar2009(Tue), 19Mar2009(Wed)");
//        } catch (Exception ex) {
//            Logger.getLogger(RunApp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(client);
//        Client regular = new Regular();
//        Client reward = new Reward();
    }
}
