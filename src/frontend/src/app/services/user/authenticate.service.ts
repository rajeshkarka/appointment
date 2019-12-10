import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  constructor(private router:Router) { }

  authenticate(username,password){
	if(username===password){
		sessionStorage.setItem('authenticatedUser',username);
		return true;
	}
	return false;
}
 isAuthenticated(){
	let userName=sessionStorage.getItem("authenticatedUser");
	return !(userName===null);
}
logout(){
	sessionStorage.removeItem("authenticatedUser");
	this.router.navigate(["login"]);
}
}
