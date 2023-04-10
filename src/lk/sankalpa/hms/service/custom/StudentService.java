package lk.sankalpa.hms.service.custom;

import lk.sankalpa.hms.dto.Studentdto;
import lk.sankalpa.hms.service.SuperService;
import org.hibernate.Session;

import java.util.List;

public interface StudentService extends SuperService {

    Studentdto saveStudent( Studentdto studentdto);
    Studentdto updateStudent( Studentdto studentdto);
    Studentdto searchStudent( String Id);
    void deleteStudent( String Id);
    List<Studentdto>allStudents(Session session);

}
