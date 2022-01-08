package backpack;

import java.util.Date;
import java.text.SimpleDateFormat;

public class comments {
    
    private String comment;
    private Date time;
    private String who;
    private int id;
    SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public comments(String s, int id) {
        set_date();
        Backpack.sc.nextLine();
        System.out.print("Enter comment : ");
        this.comment = Backpack.sc.nextLine();
        this.who = s;
        this.id = id;
    }

    public void print_com() {
        System.out.println(comment);
        System.out.println(form.format(this.time));
        System.out.println(who + " :  id : " + id);
    }

    public void set_date() {
        time = new Date();
    }

    public int get_id() {
        return id;
    }

    public Date get_date() {
        return time;
    }

    public String get_tyep() {
        return who;
    }

    public String get_comment() {
        return comment;
    }
}
