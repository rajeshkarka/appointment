import {Component, OnInit, ViewChild} from '@angular/core';
import {DayPilot, DayPilotCalendarComponent} from "daypilot-pro-angular";
import {DataService, MoveEventParams} from "./data.service";
import {CreateComponent} from "./create.component";


@Component({
  selector: 'calendar-component',
  template: `
      <div class="column-left">
          <daypilot-navigator [config]="navigatorConfig" [(date)]="calendarConfig.start"></daypilot-navigator>
      </div>
      <div class="column-main">
          <daypilot-calendar #calendar [events]="events" [config]="calendarConfig"
                             (viewChange)="viewChange()"></daypilot-calendar>
      </div>
      <create-dialog #create (close)="createClosed($event)"></create-dialog>
  `,
  styles: [`
      .column-left {
          width: 220px;
          float: left;
      }

      .column-main {
          margin-left: 220px;
      }
  `]
})
export class CalendarComponent implements OnInit {
  @ViewChild("calendar", {static: false}) calendar: DayPilotCalendarComponent;
  @ViewChild("create", {static: false}) create: CreateComponent;


  events: any[]=[];

  navigatorConfig = {
	start:1,
	dayBeginsHour:8,
	dayEndsHour:15,
    selectMode: "week",
    showMonths: 1,
    skipMonths: 3,
    showNonBusiness:"false"
  };


  calendarConfig = {
    start: DayPilot.Date.today(),
    viewType: "Week",
    eventDeleteHandling: "Update",
    onEventDeleted: args => {
      this.ds.deleteEvent(args.e.id()).subscribe(result => this.calendar.control.message("Deleted"));
    },
    onEventMoved: args => {
      let params: MoveEventParams = {
        id: args.e.id(),
        newStart: args.newStart,
        newEnd: args.newEnd
      };
      this.ds.moveEvent(params).subscribe(result => this.calendar.control.message("Moved"));
    },
    onEventResized: args => {
      let params: MoveEventParams = {
        id: args.e.id(),
        newStart: args.newStart,
        newEnd: args.newEnd
      };
      this.ds.moveEvent(params).subscribe(result => this.calendar.control.message("Resized"));
    },
    onTimeRangeSelected: args => {
      this.create.show(args);
    }
  };

  constructor(private ds: DataService) {
  }

  ngOnInit(): void {
	let event = {
	  start: "2019-12-17T10:00:00",
	  end: "2019-12-17T15:00:00",
	  id: 23,
	  text: "Mary"
	};
	
	let event1 = {
	  start: "2019-12-18T15:00:00",
	  end: "2019-12-18T17:00:00",
	  id: 24,
	  text: "Mehta"
	};
	
	this.events=[event,event1];
	console.log(this.events);
	}



  viewChange() {
	 this.ds.getEvents(this.calendar.control.visibleStart(), this.calendar.control.visibleEnd()).subscribe(result=>this.parseRespose(result));
	 console.log(this.events);

  }

parseRespose(result){

	 for(let i=0;i<result.length;i++){
		let event = {
		  start:result[i].start,
		  end: result[i].end,
		  id: result[i].id,
		  resource: "A",
		  text: ""
		};
		this.events.push(event);
	}
	console.log(this.events);
	this.calendar.events=this.events;
}

  createClosed(result) {
    if (result) {
      this.events.push(result);
    }
    this.calendar.control.clearSelection();
  }
}


