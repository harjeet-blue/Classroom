package backpack;

import java.util.ArrayList;
import java.util.HashMap;

public class classroom {
    static HashMap<Integer, grade_assessments> AID = new HashMap<>();
    static ArrayList<slides> slide = new ArrayList<>();
    static ArrayList<Lec_vidoes> vidoes = new ArrayList<>();
    static ArrayList<assignment> assess_list = new ArrayList<>();
    static ArrayList<quiz> quiz_list = new ArrayList<>();
    static ArrayList<comments> comm_list = new ArrayList<>();

    public static void Add_lect_material(Instructor m) {

        System.out.println("1. Add Lecture Slides \n2. Add Lecture Videos");
        int c = Backpack.sc.nextInt();
        if (c == 1) {

            slides s = m.add_Slides();
            slide.add(s);

        } else {
            Lec_vidoes lv = m.add_leVidoes();
            vidoes.add(lv);
        }

    }

    public static void Add_assessments(Instructor m) {
        System.out.println("1. Add assignment\n2. Add quiz");
        int c = Backpack.sc.nextInt();
        if (c == 1) {
            assignment a = m.add_assignment();
            AID.put(a.get_id(), a);
            assess_list.add(a);
            for (student st : Backpack.stu_list) {
                st.assess_list.add(new grade_ans(a.get_id(), a.get_max_score()));
            }

        } else {
            quiz q = m.add_quiz();
            AID.put(q.get_id(), q);
            quiz_list.add(q);
            for (student st : Backpack.stu_list) {
                st.assess_list.add(new grade_ans(q.get_id(), 1));
            }
        }

    }

    public static void view_material(member m) {
        m.view_lecture_materials();
    }

    public static void view_assign_quiz(member m) {
        m.view_assessments();
    }

    public static void Add_Com(member m) {
        comments c = m.add_comments(m.get_id(), m.get_type());
        comm_list.add(c);
    }

    public static void View_Com(member m) {
        m.view_comments();
    }

    public static void Log_out(member m) {
        m.logout();
    }

    public static void grade(Instructor m) {

        m.view_assessments();
        System.out.print("Enter assessments ID : ");
        int aid = Backpack.sc.nextInt();
        int f = 0;
        for (student st : Backpack.stu_list) {
            for (grade_ans ga : st.assess_list) {
                if (ga.get_id() == aid && !ga.is_graded()) {
                    System.out.println(st.get_id());
                    f++;
                    break;
                }
            }
        }
        if (f == 0) {
            System.out.println("Either no one has submitted yet or everyone's work has been graded");
            return;
        }
        System.out.print(" choose student id : ");
        int sid = Backpack.sc.nextInt();
        m.Grade_Assessments(aid, sid);
    }

    public static void close(Instructor m) {

        System.out.println("List of open assessments :- ");
        int f = 0;
        for (assignment ga : classroom.assess_list) {
            if (ga.is_closed()) continue;
            System.out.println("ID : " + ga.get_id() + "\nAssignment : " + ga.get_assig_name() + "\nMax_marks : " + ga.get_max_score() + "\n");
            f++;
        }
        System.out.println("................");
        for (quiz q : classroom.quiz_list) {
            if (q.is_closed()) continue;
            System.out.println("ID : " + q.get_id() + "\nQuiz : " + q.get_assig_name() + "\nMax_marks : " + q.get_max_score() + "\n");
            f++;
        }
        if (f == 0) {
            System.out.println(" NO open  assessments ");
            return;
        }
        System.out.print("Enter the id of assessment to close : ");
        int id = Backpack.sc.nextInt();
        grade_assessments a = AID.get(id);
        a.close_this();
        m.Close_Assessment(id);

    }


    public static void submit(student s) {
        s.submit_assessments();
    }

    public static void see_grades(student s) {
        s.view_grades();
    }

}
