package backpack;

public class quiz implements grade_assessments {

    private int ID;
    private String name;
    private String type;
    private boolean closed;
    private int upload_instr;

    public quiz(int id, int ins) {
        type = "Quiz";
        assessment_details();
        ID(id);
        closed = false;
        uploaded_by(ins);
    }

    public void assessment_details() {
        Backpack.sc.nextLine();
        System.out.print("Enter quiz question : ");
        this.name = Backpack.sc.nextLine();
    }

    public void ID(int i) {
        this.ID = i;
    }

    public void close_this() {
        this.closed = true;
    }

    public boolean is_closed() {
        return this.closed;
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
        return grade_assessments.MAX;
    }

    public int get_uploaded_inst() {
        return this.upload_instr;
    }

}
