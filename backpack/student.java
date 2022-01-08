package backpack;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class student implements member {

    private int ID;
    private String type;
    ArrayList<grade_ans> assess_list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public student(int i) {
        this.ID = i;
        this.type = "Student";
    }

    public String get_type() {
        return type;
    }

    public int get_id() {
        return ID;
    }

    SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public void view_lecture_materials() {

        for (slides s : classroom.slide) {
            System.out.println("Title : " + s.get_topic());
            System.out.println("No of slides : " + s.get_no_of_slides());

            for (int i = 0; i < s.get_no_of_slides(); i++) {
                System.out.println("Slide : " + i + " " + s.get_content().get(i));
            }
            System.out.println(form.format(s.get_time()) + "\n");
            System.out.println("Uploaded by : " + s.get_instructor());
        }

        for (Lec_vidoes l : classroom.vidoes) {
            System.out.println("Title of video : " + l.get_topic() + "\n" + "Videofile : " + l.get_file());
            System.out.println(form.format(l.get_time()) + "\n");
            System.out.println("Uploaded by : " + l.get_instructor());
        }
    }

    public void view_assessments() {

        for (grade_ans ga : assess_list) {
            if (ga.is_closed() || ga.is_done()) continue;
            grade_assessments a = classroom.AID.get(ga.get_id());
            System.out.println("ID : " + a.get_id() + "\n" + a.get_type() + " : " + a.get_assig_name() + "\nMax_marks : " + a.get_max_score() + "\n");
        }

    }

    public void submit_assessments() {

        System.out.println("Pending Assessment : ");
        int f = 0;
        for (grade_ans ga : assess_list) {
            if (ga.is_closed() || ga.is_done() || ga.is_graded()) continue;
            grade_assessments a = classroom.AID.get(ga.get_id());
            System.out.println("ID : " + a.get_id() + "\n" + a.get_type() + " : " + a.get_assig_name() + "\nMax_marks : " + a.get_max_score() + "\n");
            f++;
        }

        if (f == 0) {
            System.out.println(" NO pending assessments :");
            return;
        }
        System.out.print("Enter id : ");
        int id = sc.nextInt();
        grade_assessments a = classroom.AID.get(id);
        String ans;

        if (a.get_type().equals("Assignment")) {

            do {
                System.out.print("Enter the filename of assignement : ");
                ans = sc.next();
            } while (!check_name(ans));

        } else {

            System.out.print("Enter the one word ans : ");
            ans = sc.next();
        }

        for (grade_ans ga : assess_list) {
            if (ga.get_id() == id) {
                ga.submit_ans(ans);
                ga.mark_done();
                break;
            }
        }
    }

    public boolean check_name(String s) {
        if (s.length() < 5) return false;
        int l = s.length();
        if (s.substring(l - 4).equals(".zip"))
            return true;
        System.out.println("Wrong filename format");
        return false;
    }

    public void view_grades() {
        System.out.println("Graded Assessments ");

        for (grade_ans ga : assess_list) {
            if (ga.is_graded() && !ga.is_closed()) {
                System.out.println("ID : " + ga.get_id());
                System.out.println("Submission : " + ga.get_ans() + "\nMax marks : " + ga.get_max_score() + "\nMax scored : " + ga.get_marks());
                System.out.println("Graded by : " + ga.get_graded_ins());
            }
        }
        System.out.println("---------------------");
        System.out.println("Ungraded Assessments ");

        for (grade_ans ga : assess_list) {
            if (ga.is_done() && !ga.is_graded() && !ga.is_closed())
                System.out.println("ID : " + ga.get_id() + "\nSubmission : " + ga.get_ans() + "        Max marks : " + ga.get_max_score() + "\n");
        }
    }

    public void view_comments() {
        for (comments c : classroom.comm_list) {
            c.print_com();
        }
    }

    public comments add_comments(int id, String s) {
        comments c = new comments(s, id);
        return c;
    }

    public void logout() {
        System.out.println("Student : " + this.ID + " Logged out successfully ");
    }

}


