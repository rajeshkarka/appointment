import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/services/user/authenticate.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  userLoggedIn=false;
  constructor(private authenticationService:AuthenticateService) { }

  ngOnInit() {
	this.userLoggedIn=this.authenticationService.isAuthenticated();
  }

}
