package backpack;

public interface member {

    void view_lecture_materials();

    void view_assessments();

    void view_comments();

    comments add_comments(int i, String s);

    void logout();

    String get_type();

    int get_id();

}
