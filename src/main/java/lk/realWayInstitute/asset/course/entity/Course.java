package lk.realWayInstitute.asset.course.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lk.realWayInstitute.asset.batch.entity.Batch;
import lk.realWayInstitute.asset.student.entity.Student;
import lk.realWayInstitute.asset.teacher.entity.Teacher;
import lk.realWayInstitute.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "Course" )
public class Course extends AuditEntity {

    private String code;

    private String name;

    @OneToMany(mappedBy = "course")
    private List< Batch > batches;

    @ManyToMany(mappedBy = "courses")
    private List< Student > students;

    @OneToMany(mappedBy = "course")
    private List< Teacher > teachers;


}