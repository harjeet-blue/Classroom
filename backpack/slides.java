package backpack;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class slides {
    private int no_of_slides;
    private String topic;
    private ArrayList<String> content;
    private Date time;
    private int instructor;

    Scanner sc = new Scanner(System.in);

    public slides(int i) {
        content = new ArrayList<>();
        lecture_details();
        time_of_upload();
        uploaded_by(i);
    }

    public void lecture_details() {

        System.out.print("Enter the topic of slides : ");
        this.topic = sc.next();

        System.out.print("Enter no of slides : ");
        this.no_of_slides = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the content of the slides");

        for (int i = 1; i <= no_of_slides; i++) {
            System.out.print("Enter the content of slide " + i + " : ");
            String s = sc.nextLine();
            content.add(s);
        }
    }

    public void time_of_upload() {
        this.time = new Date();
    }

    public void uploaded_by(int i) {
        instructor = i;
    }

    public int get_no_of_slides() {
        return no_of_slides;
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

    public ArrayList<String> get_content() {
        return content;
    }
}
