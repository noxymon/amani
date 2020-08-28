package id.akademi.amani.courses.controllers.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import id.akademi.amani.courses.services.models.MasterCourse;
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
  private Long      registeredCount;
  private Long      daysBeforeStartDate;
  private String    meetingId;
  private String    courseOutline;
  private boolean   alreadyJoined;

  public static CourseResponse from(MasterCourse masterCourse)
  {
    LocalDate now = LocalDate.now();
    return CourseResponse.builder()
                         .id(masterCourse.getId().toString())
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
                         .meetingId(masterCourse.getMeetingId())
                         .daysBeforeStartDate(
                           Duration.between(
                             now.atStartOfDay(),
                             masterCourse.getCourseStartDate().toLocalDate().atStartOfDay()
                           ).toDays()
                         )
                         .registeredCount(masterCourse.getJoinedCount())
                         .courseOutline(masterCourse.getCourseOutline())
                         .alreadyJoined(masterCourse.isMemberAlreadyJoined())
                         .build();
  }
}
