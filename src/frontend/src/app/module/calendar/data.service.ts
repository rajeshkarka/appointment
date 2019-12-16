import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {DayPilot} from "daypilot-pro-angular";
import {HttpClient} from "@angular/common/http";
import { Appointment } from 'src/app/models/app.appointment';
import EventData = DayPilot.EventData;

@Injectable()
export class DataService {

  constructor(private http: HttpClient) {
  }

  getEvents(start: DayPilot.Date, end: DayPilot.Date): Observable<EventData[]> {
    return this.http.get(`http://localhost:8080/api/v1/appointments/${start}/${end}`)as Observable<EventData[]>;
  }

  createEvent(params: Appointment): Observable<BackendResult> {
    return this.http.post("http://localhost:8080/api/v1/appointments/create", params) as Observable<BackendResult>;
  }

  deleteEvent(appointmentId: string): Observable<BackendResult> {
    return this.http.post(`http://localhost:8080/api/v1/appointments/delete/${appointmentId}`, {appointmentId: appointmentId}) as Observable<BackendResult>;
  }

  moveEvent(params: MoveEventParams): Observable<BackendResult> {
    return this.http.post("/api/backend_move.php", params) as Observable<BackendResult>;
  }
}


export interface MoveEventParams {
  id: string | number;
  newStart: string;
  newEnd: string;
}

export interface BackendResult {
  appointmentId: string | number;
  result: string;
  message: string;
}

