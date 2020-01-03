package estacionamento.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    Scanner input = new Scanner(System.in);
    
    public boolean validador(String placa){
    	Pattern pattern = Pattern.compile("^[A-Z]{3}-[0-9]{4}+$");
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches();
    }
}
