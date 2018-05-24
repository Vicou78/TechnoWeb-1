package lab.mvc.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Dates {
	 public static boolean isValid(String strdate, String format) {
	        SimpleDateFormat df = new SimpleDateFormat(format);
	        try {
	            Date date = df.parse(strdate);
	            return true;
	        } catch (ParseException ex) {
	            Logger.getLogger(Dates.class.getName()).log(Level.SEVERE, null, ex);
	            return false;
	        }
	    }
}
