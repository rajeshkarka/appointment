import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthenticateService } from './authenticate.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate{

  constructor(private authenticateService:AuthenticateService) { }

  canActivate(route:ActivatedRouteSnapshot,state:RouterStateSnapshot){
	if(this.authenticateService.isAuthenticated){
		return true;
	}
	 return false;
  }
}
