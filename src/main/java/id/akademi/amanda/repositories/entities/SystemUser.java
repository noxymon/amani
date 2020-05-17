package id.akademi.amanda.repositories.entities;

import java.sql.*;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity(name = "id.akademi.amanda.services.repositories.entities.SystemUser")
@Table(name = "system_user")
public class SystemUser {

  @Id
  @Column(name = "\"id\"", nullable = false)
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;
  @Column(name = "\"email\"", nullable = false)
  private String email;
  @Column(name = "\"password\"", nullable = false)
  private String password;
  @Column(name = "\"full_name\"", nullable = false)
  private String fullName;
  @Column(name = "\"user_type\"", nullable = false)
  private String userType;
  @Column(name = "\"create_date\"", nullable = false)
  private Timestamp createDate;
  @Column(name = "\"update_date\"", nullable = true)
  private Timestamp updateDate;
  @Column(name = "\"active\"", nullable = false)
  private boolean active;
}