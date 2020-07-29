package id.akademi.amani.repositories.entities;

import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Data
@Entity(name = "id.akademi.amani.services.repositories.entities.MasterCourse")
@Table(name = "master_course")
public class MasterCourse {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "\"id\"", nullable = false)
  private String id;
  @Column(name = "\"course_name\"", nullable = false)
  private String courseName;
  @Column(name = "\"course_description\"", nullable = true)
  private String courseDescription;
  @Column(name = "\"course_start_date\"", nullable = false)
  private Date courseStartDate;
  @Column(name = "\"course_start_time\"", nullable = false)
  private Time courseStartTime;
  @Column(name = "\"course_end_date\"", nullable = false)
  private Date courseEndDate;
  @Column(name = "\"course_end_time\"", nullable = false)
  private Time courseEndTime;
  @Column(name = "\"published\"", nullable = false)
  private boolean published;
  @Column(name = "\"user_created\"", nullable = false)
  private String userCreated;
  @Column(name = "\"user_updated\"", nullable = true)
  private String userUpdated;
  @Column(name = "\"course_type\"", nullable = false)
  private String courseType;
  @Column(name = "\"instructor_name\"", nullable = false)
  private String instructorName;
  @Column(name = "\"instructor_description\"", nullable = true)
  private String instructorDescription;
  @Column(name = "\"webinar_link\"", nullable = true)
  private String webinarLink;
  @Column(name = "\"latitude\"", nullable = true)
  private Double latitude;
  @Column(name = "\"longitude\"", nullable = true)
  private Double longitude;
  @Column(name = "\"capacity\"", nullable = false)
  private Integer capacity;
  @Column(name = "\"passcode\"", nullable = true)
  private String passcode;
}