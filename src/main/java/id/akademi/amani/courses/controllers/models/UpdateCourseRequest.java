package id.akademi.amani.courses.controllers.models;

import lombok.Getter;

import java.sql.Date;
import java.sql.Time;

@Getter
public class UpdateCourseRequest
{
    private Integer capacity;
    private String  courseDescription;
    private Date    courseEndDate;
    private Time    courseEndTime;
    private String  courseName;
    private Date    courseStartDate;
    private Time    courseStartTime;
    private String  courseType;
    private String  instructorDescription;
    private String  instructorName;
    private Double  latitude;
    private Double  longitude;
    private boolean published;
    private String  userCreated;
    private String  userUpdated;
    private String  webinarLink;
    private String  passcode;
    private String  meetingId;
    private String  courseOutline;
}
