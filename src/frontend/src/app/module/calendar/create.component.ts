import {Component, EventEmitter, Output, ViewChild, OnInit} from "@angular/core";
import {DayPilot, DayPilotModalComponent} from "daypilot-pro-angular";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import { DataService } from './data.service';
import { Appointment } from 'src/app/models/app.appointment';
import { AppointmentStatus } from 'src/app/models/app.appointmentstatus';
import { User } from 'src/app/models/app.user';
import { PetService } from 'src/app/services/data/pet-service';
import { VetsService } from 'src/app/services/data/vets.service';
import { Pet } from 'src/app/models/app.pet';
import { Vet } from 'src/app/models/app.vet';
import { Doctor } from 'src/app/models/doctor';

@Component({
  selector: 'create-dialog',
  template: `
      <daypilot-modal #modal >
          <div class="center">
              <h1>Schedule Appointment</h1>
              <form [formGroup]="form">
					
 					<div class="form-item">
                      <select  (change)="petValue($event.target.value)" formControlName="name" type="select">
					 <option *ngFor="let pet of pets" value="{{pet.petId}}">{{pet.petName}}</option> 
					</select>
                  </div>
 					<div class="form-item">
                      <select (change)="vetValue($event.target.value)" formControlName="name" type="select"> 
						<option *ngFor="let vet of vets" value="{{vet.branchId}}">{{vet.branchName}}</option> 
						</select>
                  </div>
                  <div class="form-item">
                      <input formControlName="name" type="text" placeholder="Pet Name"> <span
                          *ngIf="!form.controls.name.valid">Pet name required</span>
                  </div>
                  <div class="form-item">
                      <input formControlName="start" type="text" placeholder="Start"> <span
                          *ngIf="!form.controls.start.valid">Invalid appointment start</span>
                  </div>
                  <div class="form-item">
                      <input formControlName="end" type="text" placeholder="End"> <span
                          *ngIf="!form.controls.end.valid">Invalid appointment end</span>
                  </div>
                  <div class="form-item">
                      <button (click)="submit()" [disabled]="!form.valid" class="btn btn-primary">Schedule</button>
                      &nbsp;
                      <button (click)="cancel()" class="btn btn-secondary">Cancel</button>
                  </div>
              </form>
          </div>
      </daypilot-modal>
  `,
  styles: [`
      form, input, button {
          font-size: 14px;
      }

      input {
          padding: 5px;
      }

      button {
          padding: 5px 15px;
      }

      .center {
          max-width: 800px;
          margin-left: auto;
          margin-right: auto;
      }

      .form-item {
          margin: 10px 0px;
      }

      .form-item span {
          padding-left: 10px;
      }
	.modal {
	    position: fixed;
	    top: 0px;
	    left: 0px;
	    right: 0px;
	    max-height: 80%;
	    overflow-y: auto;
	    padding: 20px;
	    background-color: white;
	    transform: translateY(-100%);
	    display: block !important;
	}
	.visible {
	    visibility: visible!important;
	    display: block;
	}
  `]
})
export class CreateComponent implements OnInit {
  @ViewChild("modal", {static: false}) modal: DayPilotModalComponent;
  @Output() close = new EventEmitter();


  form: FormGroup;
  dateFormat = "MM/dd/yyyy h:mm tt";
  pets:Pet[];
  vets:Vet[];
  petId:any;
  branchId:any;

  constructor(private fb: FormBuilder, private ds: DataService,private petService:PetService,private vetService:VetsService) {
    this.form = this.fb.group({
	  pets:["", Validators.required],
 	  vets:["", Validators.required],
      name: ["", Validators.required],
      start: ["", this.dateTimeValidator(this.dateFormat)],
      end: ["", [Validators.required, this.dateTimeValidator(this.dateFormat)]]
    });
  }

  show(args: any) {
    args.name = "";
    this.petService.loadPets().subscribe(response=>{this.pets =response});
	this.vetService.loadVets().subscribe(response=>{this.vets=response});
    this.form.setValue({
	  pets:this.pets,
 	  vets:this.vets,
      start: args.start.toString(this.dateFormat),
      end: args.end.toString(this.dateFormat),
      name: ""
    });
    this.modal.show();
  }

  submit() {
    let data = this.form.getRawValue();

	let user:User={
		userId:1,
		userName:'',
		address:'',
		password:''
		
	}
	let appointmentStatus: AppointmentStatus={
		scheduleId:0,
		status:'booked',
		userId:user
	}
	
	
    let params: Appointment = {
	 /* appointmentId:data.appointmentId,
	  petId:data.petId,
      branchId:data.branchId,
      price:data.price,
      status:data.status,*/
	  appointmentId:1,
	  petId:this.petId,
      branchId:this.branchId,
      price:'$20',
      status:'pending',
	  doctorId:1,
      nameOfDoctor:data.nameOfDoctor,
      appointmentDate:new Date().toDateString,
      appointmentStartTime: DayPilot.Date.parse(data.start, this.dateFormat).toString(),
      appointmentEndTime: DayPilot.Date.parse(data.end, this.dateFormat).toString(),
      text: data.name
    };
 	
    this.ds.createEvent(params).subscribe(result => {
      params.appointmentId = result.appointmentId;
      this.modal.hide();
      this.close.emit(params);
    });
  }

  cancel() {
    this.modal.hide();
    this.close.emit();
  }

  closed() {
    this.close.emit();
  }

  petValue(petValue){
	 this.petId=petValue;
	}
	vetValue(branchValue){
	 this.branchId=branchValue;
	}
  dateTimeValidator(format: string) {
    return function (c: FormControl) {
      let valid = !!DayPilot.Date.parse(c.value, format);
      return valid ? null : {badDateTimeFormat: true};
    };
  }

ngOnInit(){
	let  pet=new Pet(0,0,'','',0,'','');
	this.pets=[pet];
	let doctor= new Doctor(0,'','',['','']);
	let vet=new Vet(0,'','',[doctor]);
	this.vets=[vet];
}
}
