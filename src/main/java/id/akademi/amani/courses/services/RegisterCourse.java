package id.akademi.amani.courses.services;

import id.akademi.amani.courses.mappers.EntityMapper;
import id.akademi.amani.courses.services.models.MasterCourse;
import id.akademi.amani.courses.services.models.RegisterCourseParam;
import id.akademi.amani.repositories.MasterCourseRepository;
import id.akademi.amani.repositories.entities.MasterCourseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterCourse
{
    private final MasterCourseRepository masterCourseRepository;
    private final EntityMapper           entityMapper = EntityMapper.INSTANCE;

    public MasterCourse addNew(RegisterCourseParam registerCourseParam)
    {
        MasterCourseEntity masterCourseEntity = new MasterCourseEntity();
        masterCourseEntity.setCapacity(registerCourseParam.getCapacity());
        masterCourseEntity.setCourseName(registerCourseParam.getCourseName());
        masterCourseEntity.setUserCreated(registerCourseParam.getCreatedUser());
        masterCourseEntity.setCourseEndDate(registerCourseParam.getCourseEndDate());
        masterCourseEntity.setCourseEndTime(registerCourseParam.getCourseEndTime());
        masterCourseEntity.setCourseOutline(registerCourseParam.getCourseOutline());
        masterCourseEntity.setInstructorName(registerCourseParam.getInstructorName());
        masterCourseEntity.setCourseStartDate(registerCourseParam.getCourseStartDate());
        masterCourseEntity.setCourseStartTime(registerCourseParam.getCourseStartTime());
        masterCourseEntity.setCourseDescription(registerCourseParam.getCourseDescription());
        masterCourseEntity.setInstructorDescription(registerCourseParam.getInstructorDescription());
        final MasterCourseEntity masterCourseEntityfterSaved = masterCourseRepository.save(masterCourseEntity);
        return entityMapper.from(masterCourseEntityfterSaved);
    }
}
