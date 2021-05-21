package entity;

import java.sql.Time;

public class Course {
    public Integer id;
    public String name;
    public String last_updated;
    public String created_at;

    public Course(Integer id, String name,  String last_updated, String created_at) {
        this.id = id;
        this.name = name;
        this.last_updated = last_updated;
        this.created_at = created_at;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return  id +
                "\t" + name +
                "\t" + last_updated +
                "\t" + created_at ;
    }
}