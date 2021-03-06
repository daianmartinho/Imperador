package util;

import java.util.Date;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Util {

    private static final SimpleDateFormat datetime = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private static final SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat time = new SimpleDateFormat("HH:mm");
    private static final NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));

    static {
        nf.setMaximumFractionDigits(2);	   // O default é 3.
        nf.setMinimumFractionDigits(2);
        nf.setGroupingUsed(false);
    }

    public static boolean dataValida(String umaData) {
        try {
            if (umaData.length() != 10) {
                return false;
            }

            Integer.parseInt(umaData.substring(0, 2));
            Integer.parseInt(umaData.substring(3, 5));
            Integer.parseInt(umaData.substring(6, 10));

            datetime.setLenient(false);
            datetime.parse(umaData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Date strToDate(String umaData) {
        int dia = Integer.parseInt(umaData.substring(0, 2));
        int mes = Integer.parseInt(umaData.substring(3, 5));
        int ano = Integer.parseInt(umaData.substring(6, 10));

        return java.sql.Date.valueOf(ano + "-" + mes + "-" + dia);
    }

    public static Date strToDateTime(String umaData) {
        try {
            Date date = datetime.parse(umaData);
            return date;
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Calendar strToCalendar(String umaData) {
        Calendar data = Calendar.getInstance();
        try {
            data.setTime(datetime.parse(umaData));
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
//		int dia = Integer.parseInt(umaData.substring(0, 2));
//		int mes = Integer.parseInt(umaData.substring(3, 5));
//		int ano = Integer.parseInt(umaData.substring(6, 10));
//
//		Calendar data = new GregorianCalendar(ano, mes - 1, dia);
        return data;
    }

    public static Timestamp strToTimestamp(String umaData) {
        int dia = Integer.parseInt(umaData.substring(0, 2));
        int mes = Integer.parseInt(umaData.substring(3, 5));
        int ano = Integer.parseInt(umaData.substring(6, 10));

        int hh = Integer.parseInt(umaData.substring(11, 13));
        int mi = Integer.parseInt(umaData.substring(14, 16));
        int ss = Integer.parseInt(umaData.substring(17, 19));

        return Timestamp.valueOf(ano + "-" + mes + "-" + dia + " " + hh + ":" + mi + ":" + ss);
    }

    public static String dateToStr(Date umaData) {
        return date.format(umaData);
    }
      

    public static String calendarToStr(Calendar umaData, String tipo) {
        String saida = "";
        if (umaData == null) {
            return "";
        } else {
            
            switch(tipo){
                case "date":
                    saida = date.format(umaData.getTime());
                    break;
                case "time":
                    saida = time.format(umaData.getTime());
                    break;
                case "datetime":   
                    saida = datetime.format(umaData.getTime());
                    break;                    
            }
            
            return saida;           
        }
    }

    public static double strToDouble(String valor)
            throws NumberFormatException {
        if (valor == null || "".equals(valor)) {
            return 0;
        } else {
            return Double.parseDouble(valor);
        }
    }

    public static String doubleToStr(double valor) {
        return nf.format(valor);
    }
}
