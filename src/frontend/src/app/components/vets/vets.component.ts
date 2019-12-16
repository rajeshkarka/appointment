import { Component, OnInit } from '@angular/core';
import { VetsService } from 'src/app/services/data/vets.service';
import { Router } from '@angular/router';
import { Vet } from 'src/app/models/app.vet';

@Component({
  selector: 'app-vets',
  templateUrl: './vets.component.html',
  styleUrls: ['./vets.component.css']
})
export class VetsComponent implements OnInit {

  vets:Vet[];

  constructor(
	private vetService:VetsService,
	private router:Router
) { }

  ngOnInit() {
	this.loadVets();
  }

  loadVets(){
	this.vetService.loadVets().subscribe(
		response=>{
			this.vets =response});
}

	deleteVet(branchId){
	this.vetService.deleteVet(branchId).subscribe();
	this.router.navigate(['vets']);
}
}
