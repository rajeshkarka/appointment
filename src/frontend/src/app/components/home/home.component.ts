import { Component, OnInit } from '@angular/core';
import { FragmentsService } from 'src/app/services/content/fragments.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private contentService:FragmentsService) { }

  images:string[];
  contentfragment:string;

  ngOnInit() {
	this.contentService.getContentFragments().subscribe(result=>this.parseResponse(result));
   }

   parseResponse(result){
	this.images=result[":items"]["root"][":items"]["carousel"]["pages"];
	this.contentfragment=result[":items"]["root"][":items"]["contentfragment"]["text"];
	}

}
