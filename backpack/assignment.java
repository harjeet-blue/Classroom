package backpack;

public class assignment implements grade_assessments {

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
