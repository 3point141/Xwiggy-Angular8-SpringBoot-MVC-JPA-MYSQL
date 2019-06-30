import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css']
})
export class SuccessComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
    if (sessionStorage.getItem("userData") == null) {
      this.router.navigate(['login']);
    }
  }

  clearLocal(){
    sessionStorage.clear();
  }

}
