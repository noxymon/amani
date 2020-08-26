package id.akademi.amani.courses.services.models;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import lombok.Data;

@Data
public class MasterCourse
{
    private UUID    id;
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
    private Long    joinedCount;
    private boolean isMemberAlreadyJoined;
    private boolean publicAccess;
}
