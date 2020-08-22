package id.akademi.amani.repositories.entities;

import java.sql.*;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "id.akademi.amani.repositories.entities.MasterMember")
@Table(name = "master_member")
public class MasterMember {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private String id;
  @Column(name = "\"active\"", nullable = false)
  private boolean active;
  @Column(name = "\"create_date\"", nullable = false)
  private Timestamp createDate;
  @Column(name = "\"date_of_birth\"", nullable = true)
  private Date dateOfBirth;
  @Column(name = "\"email\"", nullable = false)
  private String email;
  @Column(name = "\"first_name\"", nullable = false)
  private String firstName;
  @Column(name = "\"last_name\"", nullable = true)
  private String lastName;
  @Column(name = "\"member_type\"", nullable = false)
  private String memberType;
  @Column(name = "\"password\"", nullable = false)
  private String password;
  @Column(name = "\"update_date\"", nullable = true)
  private Timestamp updateDate;
  @Column(name = "\"user_created\"", nullable = false)
  private String userCreated;
  @Column(name = "\"user_updated\"", nullable = true)
  private String userUpdated;
}