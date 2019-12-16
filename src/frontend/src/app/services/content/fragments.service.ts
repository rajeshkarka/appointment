import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FragmentsService {

  constructor(private http:HttpClient) { }

getContentFragments(){
	return this.http.get("http://localhost:4503/content/intuit-demo/pets-demo.model.json");
  
}
}
