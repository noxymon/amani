package id.akademi.amani.courses.controllers.models;

import java.time.LocalDate;
import java.time.LocalTime;
import id.akademi.amani.repositories.entities.MasterCourse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourseResponse
{
    private String    id;
    private String    courseName;
    private String    courseDescription;
    private boolean   published;
    private String    courseType;
    private String    instructorName;
    private String    instructorDescription;
    private String    webinarLink;
    private Double    latitude;
    private Double    longitude;
    private Integer   capacity;
    private LocalDate courseStartDate;
    private LocalDate courseEndDate;
    private LocalTime courseStartTime;
    private LocalTime courseEndTime;

    public static CourseResponse from(MasterCourse masterCourse)
    {
        return CourseResponse.builder()
            .id(masterCourse.getId())
            .capacity(masterCourse.getCapacity())
            .courseName(masterCourse.getCourseName())
            .courseDescription(masterCourse.getCourseDescription())
            .instructorName(masterCourse.getInstructorName())
            .instructorDescription(masterCourse.getInstructorDescription())
            .courseStartDate(masterCourse.getCourseStartDate().toLocalDate())
            .courseEndDate(masterCourse.getCourseEndDate().toLocalDate())
            .courseStartTime(masterCourse.getCourseStartTime().toLocalTime())
            .courseEndTime(masterCourse.getCourseEndTime().toLocalTime())
            .courseType(masterCourse.getCourseType())
            .latitude(masterCourse.getLatitude())
            .longitude(masterCourse.getLongitude())
            .published(masterCourse.isPublished())
            .webinarLink(masterCourse.getWebinarLink())
            .build();
    }
}
