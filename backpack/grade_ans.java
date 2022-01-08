package backpack;

public class grade_ans {
    
    private int id;
    private int max_score;
    private boolean graded;
    private boolean closed;
    private boolean done;
    private int score;
    private String ansfile;
    private int instructor;

    public grade_ans(int i, int m) {
        id = i;
        max_score = m;
        graded = false;
        closed = false;
        done = false;
    }

    boolean is_closed() {
        return closed;
    }

    void checked() {
        graded = true;
    }

    public void close_this() {
        this.closed = true;
    }

    boolean is_graded() {
        return graded;
    }

    boolean is_done() {
        return done;
    }

    void mark_done() {
        done = true;
    }

    void graded_by(int i) {
        instructor = i;
    }

    void give_marks(int m) {
        score = m;
    }

    void submit_ans(String s) {
        ansfile = s;
    }

    int get_marks() {
        return score;
    }

    String get_ans() {
        return ansfile;
    }

    int get_graded_ins() {
        return instructor;
    }

    int get_id() {
        return id;
    }

    int get_max_score() {
        return max_score;
    }
}
