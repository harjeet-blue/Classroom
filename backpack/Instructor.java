package backpack;
import java.text.SimpleDateFormat;

public class Instructor implements member {
    private int ID;
    int counter = -1;
    private String type;

    public Instructor(int i) {
        this.ID = i;
        type = "Instructor";
    }

    public String get_type() {
        return type;
    }

    public int get_id() {
        return ID;
    }

    public slides add_Slides() {

        slides s = new slides(this.ID);
        return s;
    }

    public Lec_vidoes add_leVidoes() {
        Lec_vidoes lv = new Lec_vidoes(this.ID);
        return lv;
    }

    public assignment add_assignment() {
        assignment a = new assignment(++counter, this.ID);
        return a;
    }

    public quiz add_quiz() {
        quiz q = new quiz(++counter, this.ID);
        return q;
    }

    SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public void view_lecture_materials() {

        for (slides s : classroom.slide) {
            System.out.println("Title : " + s.get_topic());
            System.out.println("No of slides : " + s.get_no_of_slides());

            for (int i = 0; i < s.get_no_of_slides(); i++) {
                System.out.println("Slide : " + i + " " + s.get_content().get(i));
            }
            System.out.println(form.format(s.get_time()));
            System.out.println("Uploaded by : " + s.get_instructor() + "\n");
        }

        for (Lec_vidoes l : classroom.vidoes) {
            System.out.println("Title of video : " + l.get_topic() + "\n" + "Videofile : " + l.get_file());
            System.out.println(form.format(l.get_time()));
            System.out.println("Uploaded by : " + l.get_instructor() + "\n");
        }
    }

    public void view_assessments() {

        for (assignment ga : classroom.assess_list) {
            if (ga.is_closed()) continue;
            System.out.println("ID : " + ga.get_id() + "\nAssignment : " + ga.get_assig_name() + "\nMax_marks : " + ga.get_max_score() + "\n");
        }
        System.out.println("................");
        for (quiz q : classroom.quiz_list) {
            if (q.is_closed()) continue;
            System.out.println("ID : " + q.get_id() + "\nQuiz : " + q.get_assig_name() + "\nMax_marks : " + q.get_max_score() + "\n");
        }
    }

    public void Grade_Assessments(int aid, int sid) {

        student s = Backpack.SID.get(sid);
        for (grade_ans a : s.assess_list) {
            if (a.get_id() == aid) {
                System.out.println("Submission : " + a.get_ans() + "\nMax Marks : " + a.get_max_score());
                System.out.print("Marks Scored : ");
                a.give_marks(Backpack.sc.nextInt());
                a.graded_by(this.ID);
                a.checked();
                break;
            }
        }
    }

    public void Close_Assessment(int aid) {

        for (student st : Backpack.stu_list) {

            for (grade_ans ga : st.assess_list) {
                if (ga.get_id() == aid) {
                    ga.close_this();
                    break;
                }
            }

        }
    }

    public comments add_comments(int id, String s) {
        comments c = new comments(s, id);
        return c;
    }

    public void view_comments() {
        for (comments c : classroom.comm_list) {
            c.print_com();
        }
    }

    public void logout() {
        System.out.println("Instructor : " + this.ID + " Logged out successfully ");
    }
}
