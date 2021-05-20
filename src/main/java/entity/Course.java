package entity;

import java.sql.Time;

public class Course {
    public Integer id;
    public String name;
    public String start_at;
    public String end_at;
    public int number_attending;
    public String last_updated;
    public String created_at;

    public Course(Integer id, String name, String start_at, String end_at, int number_attending, String last_updated, String created_at) {
        this.id = id;
        this.name = name;
        this.start_at = start_at;
        this.end_at = end_at;
        this.number_attending = number_attending;
        this.last_updated = last_updated;
        this.created_at = created_at;
    }

    public Course() {
    }
}