package id.akademi.amani.repositories.entities;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "id.akademi.amani.repositories.entities.SystemUser")
@Table(name = "system_user")
public class SystemUser {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private String id;
  @Column(name = "\"active\"", nullable = false)
  private boolean active;
  @Column(name = "\"create_date\"", nullable = false)
  private Timestamp createDate;
  @Column(name = "\"email\"", nullable = false)
  private String email;
  @Column(name = "\"full_name\"", nullable = false)
  private String fullName;
  @Column(name = "\"password\"", nullable = false)
  private String password;
  @Column(name = "\"update_date\"", nullable = true)
  private Timestamp updateDate;
  @Column(name = "\"user_type\"", nullable = false)
  private String userType;
}