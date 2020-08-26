package id.akademi.amani.courses.controllers.models;

import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
public class RegisterCourseRequest
{
    private Integer capacity;
    private boolean published;
    private String  courseName;
    private String  courseOutline;
    private Date    courseEndDate;
    private Time    courseEndTime;
    private String  instructorName;
    private Date    courseStartDate;
    private Time    courseStartTime;
    private String  courseDescription;
    private String  instructorDescription;
}
