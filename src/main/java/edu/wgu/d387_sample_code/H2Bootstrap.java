package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.entity.ReservationEntity;
import edu.wgu.d387_sample_code.entity.RoomEntity;
import edu.wgu.d387_sample_code.repository.ReservationRepository;
import edu.wgu.d387_sample_code.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
@Transactional
public class H2Bootstrap implements CommandLineRunner {

	@Autowired
	RoomRepository roomRepository;
	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Bootstrapping data: ");
		RoomEntity room1= new RoomEntity(405, "200");
		room1.setId(1L);
		LocalDate checkinDate1 = LocalDate.of(2023, 3, 10);
		LocalDate checkoutDate1 = LocalDate.of(2023, 3, 14);
		ReservationEntity reservation1 = new ReservationEntity(checkinDate1, checkoutDate1, room1);
		reservation1.setId(1L);
		reservationRepository.save(reservation1);
		room1.addReservationEntity(reservation1);
		roomRepository.save(room1);

		Iterable<RoomEntity> itr = roomRepository.findAll();
		
		System.out.println("Printing out data: ");
		for(RoomEntity room : itr) {
			System.out.println(room.getRoomNumber());
		}
	}

}
