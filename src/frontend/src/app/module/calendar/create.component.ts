import {Component, EventEmitter, Output, ViewChild} from "@angular/core";
import {DayPilot, DayPilotModalComponent} from "daypilot-pro-angular";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import { DataService } from './data.service';
import { Appointment } from 'src/app/models/app.appointment';
import { AppointmentStatus } from 'src/app/models/app.appointmentstatus';
import { User } from 'src/app/models/app.user';

@Component({
  selector: 'create-dialog',
  template: `
      <daypilot-modal #modal >
          <div class="center">
              <h1>Schedule Appointment</h1>
              <form [formGroup]="form">
					
 					<div class="form-item">
                      <input formControlName="name" type="hidden" ng-value="1"> 
                  </div>
 					<div class="form-item">
                      <input formControlName="name" type="hidden" ng-value="1"> 
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
export class CreateComponent {
  @ViewChild("modal", {static: false}) modal: DayPilotModalComponent;
  @Output() close = new EventEmitter();

  form: FormGroup;
  dateFormat = "MM/dd/yyyy h:mm tt";

  constructor(private fb: FormBuilder, private ds: DataService) {
    this.form = this.fb.group({
      name: ["", Validators.required],
      start: ["", this.dateTimeValidator(this.dateFormat)],
      end: ["", [Validators.required, this.dateTimeValidator(this.dateFormat)]]
    });
  }

  show(args: any) {
    args.name = "";
    this.form.setValue({
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
	  petId:1,
      branchId:1,
      price:'20',
      status:'booked',
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

  dateTimeValidator(format: string) {
    return function (c: FormControl) {
      let valid = !!DayPilot.Date.parse(c.value, format);
      return valid ? null : {badDateTimeFormat: true};
    };
  }
}
