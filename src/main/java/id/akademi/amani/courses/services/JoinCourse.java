package id.akademi.amani.courses.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import id.akademi.amani.commons.TransactionStatus;
import id.akademi.amani.courses.services.models.JoinCourseOutput;
import id.akademi.amani.courses.services.models.JoinCourseParam;
import id.akademi.amani.courses.services.models.MasterCourse;
import id.akademi.amani.repositories.TransactionCourseMemberAttendenceRepository;
import id.akademi.amani.repositories.entities.TransactionCourseMemberAttendenceEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinCourse
{
    private final FetchSingleCourse                           fetchSingleCourse;
    private final CourseTransactionService                    courseTransactionService;
    private final TransactionCourseMemberAttendenceRepository transactionCourseMemberRepository;

    public JoinCourseOutput join(JoinCourseParam joinCourseParam)
    {
        final MasterCourse existingMasterCourseEntity = fetchSingleCourse.byId(joinCourseParam.getCourseId(), null);
        final long alreadyJoinedInCourse = courseTransactionService.countAttendeeOf(
            joinCourseParam.getCourseId()
        );

        assertCourseAvailale(existingMasterCourseEntity, alreadyJoinedInCourse);

        TransactionCourseMemberAttendenceEntity savedTransaction = saveTransactionCourseMemberAttendance(
            joinCourseParam,
            existingMasterCourseEntity
        );
        return JoinCourseOutput.builder()
                               .transcationId(savedTransaction.getTransactionId().toString())
                               .amount(savedTransaction.getAmount())
                               .amountFinal(savedTransaction.getAmountFinal())
                               .transactionStatus(
                                   TransactionStatus.from(savedTransaction.getTransactionStatus())
                               )
                               .build();
    }

    private void assertCourseAvailale(MasterCourse existingMasterCourse, long alreadyJoinedInCourse)
    {
        if (alreadyJoinedInCourse >= existingMasterCourse.getCapacity()) {
            throw new RuntimeException("Course ini sudah penuh");
        }
    }

    private TransactionCourseMemberAttendenceEntity saveTransactionCourseMemberAttendance(
        JoinCourseParam joinCourseParam, MasterCourse existingMasterCourse)
    {
        TransactionCourseMemberAttendenceEntity transactionCourseMember = new TransactionCourseMemberAttendenceEntity();
        transactionCourseMember.setCourseId(existingMasterCourse.getId());
        transactionCourseMember.setMemberId(joinCourseParam.getMemberId());
        transactionCourseMember.setDiscount(0d);
        transactionCourseMember.setAmount(0d);
        transactionCourseMember.setAmountFinal(0d);
        transactionCourseMember.setPaidAt(Timestamp.valueOf(LocalDateTime.now()));
        transactionCourseMember.setTransactionStatus(TransactionStatus.PAID.getStatus());
        return transactionCourseMemberRepository.save(transactionCourseMember);
    }
}
