package backpack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class Backpack {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<student> stu_list = new ArrayList<>();
    static ArrayList<Instructor> ins_list = new ArrayList<>();
    static HashMap<Integer, student> SID = new HashMap<>();
    static HashMap<Integer, Instructor> IID = new HashMap<>();

    public static void main(String[] args) {

        Instructor I1 = new Instructor(0);
        Instructor I2 = new Instructor(1);
        ins_list.add(I1);
        ins_list.add(I2);
        IID.put(0, I1);
        IID.put(1, I2);
        student s1 = new student(0);
        student s2 = new student(1);
        student s3 = new student(2);
        stu_list.add(s1);
        stu_list.add(s2);
        stu_list.add(s3);
        SID.put(0, s1);
        SID.put(1, s2);
        SID.put(2, s3);
        int c;

        do {
            System.out.println("\nWelcome to Backpack\n1. Enter as instructor\n2. Enter as student\n3. Exit");
            c = sc.nextInt();

            if (c == 1) {
                System.out.println("Instructors ids : - \n0\n1");
                System.out.print("Enter instructor id : ");

                int id = sc.nextInt();
                instructor_menu(id);
            } else if (c == 2) {

                System.out.println("Instructors ids : - \n0\n1\n2");
                System.out.print("Enter student id : ");

                int id = sc.nextInt();
                student_menu(id);
            } else System.exit(0);

        } while (c != 3);

    }

    public static void instructor_menu(int id) {
        int c;
        do {
            System.out.println("\nWelcome Instructor : " + id);
            System.out.println("INSTRUCTOR MENU");
            System.out.println("1. Add lecture materials\n2. Add grade assessments\n3. View lecture materials");
            System.out.println("4. View assessments\n5. Grade assessments\n6. Close assessments\n7. View comments");
            System.out.println("8. Add comments\n9. Logout\nENTER APPROPRIATE OPTION");
            c = sc.nextInt();
            inst_helper(c, id);

        } while (c != 9);

    }

    public static void inst_helper(int c, int id) {

        Instructor ins = IID.get(id);

        switch (c) {
            case 1:
                classroom.Add_lect_material(ins);
                break;
            case 2:
                classroom.Add_assessments(ins);
                break;
            case 3:
                classroom.view_material(ins);
                break;
            case 4:
                classroom.view_assign_quiz(ins);
                break;
            case 5:
                classroom.grade(ins);
                break;
            case 6:
                classroom.close(ins);
                break;
            case 7:
                classroom.View_Com(ins);
                break;
            case 8:
                classroom.Add_Com(ins);
                break;
            case 9:
                classroom.Log_out(ins);
                break;
            default:
                break;
        }
    }

    public static void student_menu(int id) {
        int c;
        do {
            System.out.println("\nWelcome Student : " + id);
            System.out.println("STUDENT MENU");
            System.out.println("1. View lecture materials\n2. View assessments\n3. Submit assessments\n4. View Grades");
            System.out.println("5. View comments\n6. Add comments\n7. Logout\nENTER CORRECT OPTION");
            c = sc.nextInt();
            student_helper(c, id);

        } while (c != 7);
    }

    public static void student_helper(int c, int id) {

        student s = SID.get(id);

        switch (c) {
            case 1:
                classroom.view_material(s);
                break;
            case 2:
                classroom.view_assign_quiz(s);
                break;
            case 3:
                classroom.submit(s);
                break;
            case 4:
                classroom.see_grades(s);
                break;
            case 5:
                classroom.View_Com(s);
                break;
            case 6:
                classroom.Add_Com(s);
                break;
            case 7:
                classroom.Log_out(s);
                break;
            default:
                break;
        }
    }

}

