import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticateService } from 'src/app/services/user/authenticate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string="rkarka";
  password:string="rkarka";
  loginText="Logout";

  constructor(
	private route:Router,
	private authenticateService:AuthenticateService) { }

  ngOnInit() {
  }
	
  login(){
	if(this.authenticateService.authenticate(this.username,this.password)){
	this.route.navigate(['home']);
	}
	
   }
}
