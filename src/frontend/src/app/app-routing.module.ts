import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PetsComponent } from './components/pets/pets.component';
import { VetsComponent } from './components/vets/vets.component';
import { AppointmentsComponent } from './components/appointments/appointments.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { LogoutComponent } from './components/logout/logout.component';



const routes: Routes = [ 
	{path:'login',component:LoginComponent},
	{path:'logout',component:LogoutComponent},
	{path:'home',component:HomeComponent},
	{path:'pets',component:PetsComponent},
	{path:'vets',component:VetsComponent},
	{path:'appointments',component:AppointmentsComponent}
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
