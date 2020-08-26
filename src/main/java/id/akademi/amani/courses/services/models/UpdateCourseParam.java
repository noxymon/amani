package id.akademi.amani.courses.services.models;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class UpdateCourseParam
{
    private String  id;
    private Integer capacity;
    private Date    courseEndDate;
    private Time    courseEndTime;
    private String  courseName;
    private Date    courseStartDate;
    private Time    courseStartTime;
    private String  courseType;
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
    private Long    joinedCount;
    private String  courseDescription;
    private String  instructorDescription;
    private boolean isMemberAlreadyJoined;
}
