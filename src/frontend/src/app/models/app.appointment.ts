
export class Appointment{
	constructor(
		public appointmentId:string|number,
		public petId:number,
		public branchId:number,
		public price:string,
		public status:string,
		public nameOfDoctor:string,
		public doctorId:number,
		public appointmentStartTime:any,
		public appointmentEndTime:any,
		public appointmentDate:any,
		public text:any
	){}
}