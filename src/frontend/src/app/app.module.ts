import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PetsComponent } from './components/pets/pets.component';
import { VetsComponent } from './components/vets/vets.component';
import { AppointmentsComponent } from './components/appointments/appointments.component';
import { HeaderComponent } from './components/common/header/header.component';
import { FooterComponent } from './components/common/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { LogoutComponent } from './components/logout/logout.component';
import { PetComponent } from './components/form/pet/pet.component';
import { VetComponent } from './components/form/vet/vet.component';
import { AppointmentComponent } from './components/form/appointment/appointment.component';
import { FormsModule } from '@angular/forms';
import { PetService } from './services/data/pet-service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PetsComponent,
    VetsComponent,
    AppointmentsComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    HomeComponent,
    LogoutComponent,
    PetComponent,
    VetComponent,
    AppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	FormsModule,
	HttpClientModule
  ],
  providers: [PetService],
  bootstrap: [AppComponent]
})
export class AppModule { }
