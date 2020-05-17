package id.akademi.amanda.services.repositories.entities;

import java.sql.*;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity(name = "id.akademi.amanda.services.repositories.entities.MasterMember")
@Table(name = "master_member")
public class MasterMember {

  @Id
  @GeneratedValue(generator = "uuid2")
  @Column(name = "\"id\"", nullable = false)
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID id;
  @Column(name = "\"email\"", nullable = false)
  private String email;
  @Column(name = "\"first_name\"", nullable = false)
  private String firstName;
  @Column(name = "\"last_name\"", nullable = true)
  private String lastName;
  @Column(name = "\"date_of_birth\"", nullable = true)
  private Date dateOfBirth;
  @Column(name = "\"member_type\"", nullable = false)
  private String memberType;
  @Column(name = "\"create_date\"", nullable = false)
  private Timestamp createDate;
  @Column(name = "\"update_date\"", nullable = true)
  private Timestamp updateDate;
  @Column(name = "\"user_created\"", nullable = false)
  private String userCreated;
  @Column(name = "\"user_updated\"", nullable = true)
  private String userUpdated;
  @Column(name = "\"active\"", nullable = false)
  private boolean active;
}