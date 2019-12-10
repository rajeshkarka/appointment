import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from 'src/app/services/user/authenticate.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authenticateService:AuthenticateService) { }
  loginText="Login";
  ngOnInit() {
	this.authenticateService.logout();
  }

}
