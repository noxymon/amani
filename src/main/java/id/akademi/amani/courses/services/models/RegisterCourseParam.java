package id.akademi.amani.courses.services.models;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Builder
public class RegisterCourseParam
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
    private String  createdUser;
}
