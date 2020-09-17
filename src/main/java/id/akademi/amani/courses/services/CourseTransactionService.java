package id.akademi.amani.courses.services;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import id.akademi.amani.repositories.TransactionCourseMemberAttendenceRepository;
import id.akademi.amani.repositories.entities.TransactionCourseMemberAttendenceEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseTransactionService {
    private final TransactionCourseMemberAttendenceRepository transactionCourseMemberRepository;

    public long countAttendeeOf(String id)
    {
        TransactionCourseMemberAttendenceEntity courseMemberAttendenceExample = new TransactionCourseMemberAttendenceEntity();
        courseMemberAttendenceExample.setCourseId(id);
        return transactionCourseMemberRepository.count(Example.of(courseMemberAttendenceExample));
    }
}
