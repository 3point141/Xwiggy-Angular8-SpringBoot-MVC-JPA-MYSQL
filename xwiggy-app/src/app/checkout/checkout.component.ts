import { Component, OnInit } from '@angular/core';
import {AppComponent, User} from "../app.component";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  constructor(private http:HttpClient, private router:Router) { }

  user:User = AppComponent.modelUser;
  total:number=AppComponent.total;
  ngOnInit() {
  }

  changeDB():void{
    let url="http://localhost:8080/changeDB";
    this.http.get(url).subscribe(
      res=>{
        console.log("DB Updated");
      },
      err=>{
        alert('Failed to update DB');
      }
    )
  }
}
