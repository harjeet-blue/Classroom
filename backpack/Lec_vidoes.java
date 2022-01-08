package backpack;

import java.util.Date;
import java.util.Scanner;

public class Lec_vidoes {
    private String topic;
    private String name;
    private int instructor;
    private Date time;

    Scanner sc = new Scanner(System.in);

    public Lec_vidoes(int i) {
        lecture_details();
        time_of_upload();
        uploaded_by(i);
    }

    public void lecture_details() {
        System.out.print("Enter the topic of the video : ");
        this.topic = sc.next();

        do {
            System.out.print("Enter the filename : ");
            this.name = sc.next();

        } while (!check_name(name));
    }

    public boolean check_name(String s) {
        if (s.length() < 5) return false;
        int l = s.length();
        if (s.substring(l - 4).equals(".mp4"))
            return true;
        System.out.println("Wrong filename format");
        return false;
    }

    public void time_of_upload() {
        this.time = new Date();
    }

    public void uploaded_by(int i) {
        instructor = i;
    }

    public String get_file() {
        return name;
    }

    public String get_topic() {
        return topic;
    }

    public Date get_time() {
        return time;
    }

    public int get_instructor() {
        return instructor;
    }

}

class assignment implements grade_assessments {

    private int ID;
    private String name;
    private String type;
    private int max_score;
    private boolean closed;
    private int upload_instr;

    public assignment(int id, int ins) {
        type = "Assignment";
        assessment_details();
        closed = false;
        ID(id);
        uploaded_by(ins);
    }

    public void assessment_details() {
        Backpack.sc.nextLine();
        System.out.print("Enter the problem statement : ");
        this.name = Backpack.sc.nextLine();
        System.out.print("Enter the max marks : ");
        this.max_score = Backpack.sc.nextInt();

    }

    public void ID(int i) {
        this.ID = i;
    }

    public boolean is_closed() {
        return this.closed;
    }

    public void close_this() {
        this.closed = true;
    }

    public void uploaded_by(int i) {
        this.upload_instr = i;
    }

    public String get_type() {
        return type;
    }

    public int get_id() {
        return this.ID;
    }

    public String get_assig_name() {
        return this.name;
    }

    public int get_max_score() {
        return this.max_score;
    }

    public int get_uploaded_inst() {
        return this.upload_instr;
    }
}
