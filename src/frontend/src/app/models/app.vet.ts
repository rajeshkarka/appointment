import { Doctor } from './doctor';

export class Vet{
	constructor(
		public branchId:number,
		public branchName:string,
		public address:string,
		public doctors:Doctor[]
	){}
}