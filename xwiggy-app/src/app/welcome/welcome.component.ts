import { Component, OnInit } from '@angular/core';
import {AppComponent, User} from "../app.component";

@Component({
  selector: 'app-welcom',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor() { }
  user: User = AppComponent.modelUser;
  ngOnInit() {
  }

}
