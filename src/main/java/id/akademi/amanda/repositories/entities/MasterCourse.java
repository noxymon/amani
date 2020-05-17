package id.akademi.amanda.repositories.entities;

import java.sql.*;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity(name = "id.akademi.amanda.services.repositories.entities.MasterCourse")
@Table(name = "master_course")
public class MasterCourse {

  @Id
  @GeneratedValue(generator = "uuid2")
  @Column(name = "\"id\"", nullable = false)
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;
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
}