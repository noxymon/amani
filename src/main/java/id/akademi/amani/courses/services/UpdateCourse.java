package id.akademi.amani.courses.services;

import id.akademi.amani.courses.mappers.EntityMapper;
import id.akademi.amani.courses.services.models.MasterCourse;
import id.akademi.amani.courses.services.models.UpdateCourseParam;
import id.akademi.amani.repositories.MasterCourseRepository;
import id.akademi.amani.repositories.entities.MasterCourseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UpdateCourse
{
    private final MasterCourseRepository masterCourseRepository;
    private final EntityMapper entityMapper = EntityMapper.INSTANCE;

    public MasterCourse with(UpdateCourseParam updateCourseParam)
    {
        MasterCourseEntity existingMasterCourse = masterCourseRepository
          .findById(updateCourseParam.getId())
          .orElseThrow();

        existingMasterCourse.setUserCreated(updateCourseParam.getUserCreated());
        existingMasterCourse.setInstructorName(updateCourseParam.getInstructorName());
        existingMasterCourse.setInstructorDescription(updateCourseParam.getInstructorDescription());
        existingMasterCourse.setCourseType(updateCourseParam.getCourseType());
        existingMasterCourse.setCourseStartTime(updateCourseParam.getCourseStartTime());
        existingMasterCourse.setCourseStartDate(updateCourseParam.getCourseStartDate());
        existingMasterCourse.setCourseOutline(updateCourseParam.getCourseOutline());
        existingMasterCourse.setCourseName(updateCourseParam.getCourseName());
        existingMasterCourse.setCourseEndTime(updateCourseParam.getCourseEndTime());
        existingMasterCourse.setCourseEndDate(updateCourseParam.getCourseEndDate());
        existingMasterCourse.setCourseDescription(updateCourseParam.getCourseDescription());
        existingMasterCourse.setCapacity(updateCourseParam.getCapacity());
        existingMasterCourse.setLatitude(updateCourseParam.getLatitude());
        existingMasterCourse.setLongitude(updateCourseParam.getLongitude());
        existingMasterCourse.setMeetingId(updateCourseParam.getMeetingId());
        existingMasterCourse.setPasscode(updateCourseParam.getPasscode());
        existingMasterCourse.setPublished(updateCourseParam.isPublished());
        existingMasterCourse.setUserUpdated(updateCourseParam.getUserUpdated());
        existingMasterCourse.setWebinarLink(updateCourseParam.getWebinarLink());

        return entityMapper.from(
          masterCourseRepository.save(existingMasterCourse)
        );
    }
}
