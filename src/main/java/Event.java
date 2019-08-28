import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task{

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        try {
            return "[E]" + super.toString() + " (at: " + understandTime(at) + ")";
        } catch (ParseException e) {
            return "[E]" + super.toString() + " (at: " + at + ")";
        }
    }

    public String understandTime(String t) throws ParseException {
        String t1 = "";
        String t2 = "";
        SimpleDateFormat finalFormat = new SimpleDateFormat("d MMMMM yyyy, hh:mmaaa");

        String time = t;

        if (t.length() <= 15 && t.length() >= 12){
            for (int i=0; i<t.length(); i++){
                if (t.charAt(i)==' '){
                    t1 = t.substring(0, i);
                    t2 = t.substring(i+1);
                    Date temp;
                    //if t1 is longer, then assume t1 is date, t2 is time
                    if (t1.length() > t2.length() && t1.length() <=10 && t2.length() <=4){
                        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HHmm");
                        temp = format1.parse(t);
                        time = finalFormat.format(temp);
                    }else if (t2.length() <=10 && t1.length() <=4){
                        SimpleDateFormat format2 = new SimpleDateFormat("HHmm dd/MM/yyyy");
                        temp = format2.parse(t);
                        time = finalFormat.format(temp);
                    }

                    break;
                }
            }

        }

        return time;
    }
}
