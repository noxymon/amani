package id.akademi.amani.repositories.entities;

import java.sql.*;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Data
@Entity(name = "id.akademi.amani.repositories.entities.TransactionCourseMemberAttendence")
@Table(name = "transaction_course_member_attendence")
public class TransactionCourseMemberAttendence {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "\"transaction_id\"", nullable = false)
  private UUID transactionId;
  @Column(name = "\"amount\"", nullable = false)
  private Double amount;
  @Column(name = "\"amount_final\"", nullable = false)
  private Double amountFinal;
  @Column(name = "\"course_id\"", nullable = false)
  private String courseId;
  @Column(name = "\"created_date\"", nullable = false)
  @CreationTimestamp
  private Timestamp createdDate;
  @Column(name = "\"discount\"", nullable = false)
  private Double discount;
  @Column(name = "\"expired_at\"", nullable = true)
  private Timestamp expiredAt;
  @Column(name = "\"member_id\"", nullable = false)
  private String memberId;
  @Column(name = "\"paid_at\"", nullable = true)
  private Timestamp paidAt;
  @Column(name = "\"transaction_status\"", nullable = false)
  private Integer transactionStatus;
  @Column(name = "\"updated_date\"", nullable = true)
  @UpdateTimestamp
  private Timestamp updatedDate;
}