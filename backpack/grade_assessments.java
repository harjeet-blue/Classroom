package backpack;

public interface grade_assessments {
    int MAX = 1;

    void assessment_details();

    void ID(int i);

    boolean is_closed();

    void uploaded_by(int i);

    int get_id();

    public void close_this();

    String get_type();

    String get_assig_name();

    public int get_max_score();
}
