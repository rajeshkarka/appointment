import { Component, OnInit } from '@angular/core';
import { Vet } from 'src/app/models/app.vet';
import { VetsService } from 'src/app/services/data/vets.service';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/models/doctor';

@Component({
  selector: 'app-vet',
  templateUrl: './vet.component.html',
  styleUrls: ['./vet.component.css']
})
export class VetComponent implements OnInit {

  vet:Vet;
  doctors:Doctor[];
  constructor(
	private vetsService:VetsService,
	private router:Router
) { }

  ngOnInit() {
	this.vet=new Vet(0,'','',this.doctors);
  }
saveVet(vet){
	this.vetsService.saveVet(this.vet).subscribe();
	this.router.navigate(["vets"]);
  }

}
