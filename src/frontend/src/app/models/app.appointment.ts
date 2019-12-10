import { Time } from '@angular/common';

export class Appointment{
	constructor(
		public petId:number,
		public branchId:number,
		public price:string,
		public status:string,
		public nameOfDoctor:string,
		public appointmentStartTime:Time,
		public appointmentEndTime:Time,
		public appointmentDate:Date,
		public createdAt:Time
	){}
}