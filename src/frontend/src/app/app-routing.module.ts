import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PetsComponent } from './components/pets/pets.component';
import { VetsComponent } from './components/vets/vets.component';
import { AppointmentsComponent } from './components/appointments/appointments.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { LogoutComponent } from './components/logout/logout.component';
import { RouteGuardService } from './services/user/route-guard.service';
import { PetComponent } from './components/form/pet/pet.component';
import { VetComponent } from './components/form/vet/vet.component';
import { AppointmentComponent } from './components/form/appointment/appointment.component';



const routes: Routes = [ 
	{path:'',component:LoginComponent,},
	{path:'login',component:LoginComponent},
	{path:'logout',component:LogoutComponent},
	{path:'home',component:HomeComponent,canActivate:[RouteGuardService]},
	{path:'pets',component:PetsComponent,canActivate:[RouteGuardService]},
	{path:'pet',component:PetComponent,canActivate:[RouteGuardService]},
	{path:'vets',component:VetsComponent,canActivate:[RouteGuardService]},
	{path:'vet',component:VetComponent,canActivate:[RouteGuardService]},
	{path:'appointments',component:AppointmentsComponent,canActivate:[RouteGuardService]},
	{path:'appointment',component:AppointmentComponent,canActivate:[RouteGuardService]}
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
