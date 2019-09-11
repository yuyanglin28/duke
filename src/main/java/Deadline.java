import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy(){
        return by;
    }


    @Override
    public String toString() {

        try {
            return "[D]" + super.toString() + " (by: " + understandTime(by) + ")";
        } catch (ParseException e) {
            return "[D]" + super.toString() + " (by: " + by + ")";
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
