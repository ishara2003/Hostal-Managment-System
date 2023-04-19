package lk.sankalpa.hms.dao.custom;

import lk.sankalpa.hms.dao.CrudDao;
import lk.sankalpa.hms.entity.Student;
import org.hibernate.Session;

public interface StudentDao extends CrudDao<Student , String> {

    public Student biStudentId(String Id, Session session);

}
