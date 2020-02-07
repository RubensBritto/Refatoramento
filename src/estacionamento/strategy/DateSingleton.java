package estacionamento.strategy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSingleton {
    private static DateSingleton uniqueCalendar = new DateSingleton();
    public Date today;
    private DateSingleton()
    {
        today = new Date();
  
    }
    public static DateSingleton getInstance(){
        return uniqueCalendar;
    }
    
    public int getHoraFormatada(Date h, String formato) {
        String fh = new SimpleDateFormat(formato).format(h);
        return Integer.parseInt(fh);
    }

}
