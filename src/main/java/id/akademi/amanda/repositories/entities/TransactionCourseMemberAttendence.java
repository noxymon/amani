package id.akademi.amanda.repositories.entities;

import java.sql.*;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity(name = "id.akademi.amanda.services.repositories.entities.TransactionCourseMemberAttendence")
@Table(name = "transaction_course_member_attendence")
public class TransactionCourseMemberAttendence {

  @Id
  @Column(name = "\"transaction_id\"", nullable = false)
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID transactionId;
  @Column(name = "\"course_id\"", nullable = false)
  private String courseId;
  @Column(name = "\"member_id\"", nullable = false)
  private String memberId;
  @Column(name = "\"created_date\"", nullable = false)
  private Timestamp createdDate;
  @Column(name = "\"updated_date\"", nullable = true)
  private Timestamp updatedDate;
  @Column(name = "\"paid_at\"", nullable = true)
  private Timestamp paidAt;
  @Column(name = "\"expired_at\"", nullable = true)
  private Timestamp expiredAt;
  @Column(name = "\"transaction_status\"", nullable = false)
  private Integer transactionStatus;
  @Column(name = "\"amount\"", nullable = false)
  private Double amount;
  @Column(name = "\"discount\"", nullable = false)
  private Double discount;
  @Column(name = "\"amount_final\"", nullable = false)
  private Double amountFinal;
}