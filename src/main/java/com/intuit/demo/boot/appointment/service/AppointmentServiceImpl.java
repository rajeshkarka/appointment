package com.intuit.demo.boot.appointment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.intuit.demo.boot.appointment.model.Appointment;
import com.intuit.demo.boot.appointment.repository.AppointmentRepository;

@Component("appointmentService")
@Service(value="appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository repository;

    
    public AppointmentServiceImpl(AppointmentRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Appointment> findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> findByPetId(Long petId) {
		// TODO Auto-generated method stub
		return null;
	}
	
    @Override
    public Optional<Appointment> findById(Long appointmentId) {
        return repository.findById(appointmentId);
    }

    @Override
    public List<Appointment> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Appointment> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate) {
        return repository.findAllByAppointmentDateBetweenOrderByPriceAsc(startDate, endDate);
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment appointment) {
        return repository.save(appointment);
    }

    @Override
    public Appointment updateStatus(Long appointmentId, Appointment appointment) {

        Optional<Appointment> appointmentList = repository.findById(appointmentId);

        if(appointmentList.isPresent()){
            if(appointment.getStatusId()!= 0){
                appointmentList.get().setStatusId(appointment.getStatusId());
            }
            return repository.save(appointmentList.get());
        }
        return null;
    }

    @Override
    public void deleteById(Long appointmentId) {
        repository.deleteById(appointmentId);
    }

	
}
