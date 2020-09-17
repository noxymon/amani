package id.akademi.amani.courses.services;

import id.akademi.amani.repositories.TransactionCourseMemberAttendenceRepository;
import id.akademi.amani.repositories.entities.TransactionCourseMemberAttendenceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindTransactionService
{
    private final TransactionCourseMemberAttendenceRepository transactionCourseMemberRepository;

    public Optional<TransactionCourseMemberAttendenceEntity> byMemberId(String courseId, String memberId)
    {
        TransactionCourseMemberAttendenceEntity courseMemberAttendenceEntity = new TransactionCourseMemberAttendenceEntity();
        courseMemberAttendenceEntity.setCourseId(courseId);
        courseMemberAttendenceEntity.setMemberId(memberId);
        return transactionCourseMemberRepository.findOne(Example.of(courseMemberAttendenceEntity));
    }
}
