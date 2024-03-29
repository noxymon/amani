package id.akademi.amani.courses.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import id.akademi.amani.repositories.entities.TransactionCourseMemberAttendenceEntity;
import org.springframework.stereotype.Service;
import id.akademi.amani.courses.mappers.MasterCourseMapper;
import id.akademi.amani.courses.services.models.MasterCourse;
import id.akademi.amani.repositories.MasterCourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FetchSingleCourse
{
    private final FindTransactionService   findTransactionService;
    private final MasterCourseRepository   masterCourseRepository;
    private final CourseTransactionService courseTransactionService;
    private final MasterCourseMapper       masterCourseMapper = MasterCourseMapper.INSTANCE;

    public MasterCourse byId(String id, Optional<String> memberId)
    {
        long attendeeCount = courseTransactionService.countAttendeeOf(id);
        MasterCourse masterCourseExisting = masterCourseMapper.map(masterCourseRepository
          .findById(UUID.fromString(id))
          .orElseThrow()
        );
        masterCourseExisting.setJoinedCount(attendeeCount);

        if (memberId.isPresent()) {
            final Optional<TransactionCourseMemberAttendenceEntity> existingTransaction = findTransactionService.byMemberId(id, memberId.get());
            boolean isMemberAlreadyJoined = existingTransaction.isPresent();
            masterCourseExisting.setMemberAlreadyJoined(isMemberAlreadyJoined);
        }
        return masterCourseExisting;
    }
}
