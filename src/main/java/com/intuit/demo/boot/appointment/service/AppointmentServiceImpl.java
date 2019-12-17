package com.intuit.demo.boot.appointment.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.intuit.demo.boot.appointment.model.Appointment;
import com.intuit.demo.boot.appointment.model.Veterinary;
import com.intuit.demo.boot.appointment.repository.AppointmentRepository;
import com.intuit.demo.boot.veternity.service.VeterinaryService;

@Component("appointmentService")
@Service(value="appointmentService")
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository repository;
    
    @Autowired
    VeterinaryService veternaryService;

    
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
    public boolean isAvailable(final Long petId,final Long vetId,String startDate, String endDate) throws ParseException {
    	Veterinary veterinary=veternaryService.getVeternity(vetId);
    	SimpleDateFormat formate = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    	if(repository.isAvailable(petId, veterinary, formate.parse(startDate), formate.parse(endDate)) !=null) {
    		return true;
    	}
    	return false;
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
