package lk.sankalpa.hms.service.custom;

import lk.sankalpa.hms.dto.Reservationdto;
import lk.sankalpa.hms.service.SuperService;
import org.hibernate.Session;

import java.util.List;

public interface ReservationService extends SuperService {

Reservationdto addReservation(Reservationdto reservationdto);

List<Reservationdto> allReservatines(Session session);

void deleteReservation(String Id);



}
