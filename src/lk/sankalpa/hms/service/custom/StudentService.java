package lk.sankalpa.hms.service.custom;

import lk.sankalpa.hms.dto.Studentdto;
import lk.sankalpa.hms.service.SuperService;
import org.hibernate.Session;

import java.util.List;

public interface StudentService extends SuperService {

    Studentdto saveStudent(Session session, Studentdto studentdto);
    Studentdto updateStudent(Session session, Studentdto studentdto);
    Studentdto searchStudent(Session session, String Id);
    void deleteStudent(Session session, String Id);
    List<Studentdto>allStudents(Session session);

}
