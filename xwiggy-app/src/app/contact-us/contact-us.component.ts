import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {User} from "../app.component";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  modelUser: User = {
    username:'',
    password:'',
    email:'',
    phone:0,
    firstname:'',
    lastname:'',
    address:'',
    merchant:null
  };

  modelMessage:contact={
    name:'',
    email:'',
    message:''
  };


  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit() {
    if(sessionStorage.getItem('userData')==null)
      this.router.navigate(["login"]);

    let userData = JSON.parse(sessionStorage.getItem('userData'));
    console.log(userData);
    Object.assign(this.modelUser,userData);
  }

  gif:boolean=false;
  sendFeedback() {
    this.gif=true;
    this.modelMessage.name=this.modelUser.firstname+this.modelUser.lastname;
    this.modelMessage.email=this.modelUser.email;

    let url = "http://localhost:8080/contact";
    this.http.post <contact>(url,this.modelMessage).subscribe(
      res => {
        ContactUsComponent.changeLoading();
        if(res)
          alert("Message Sent Successfully");
          this.gif=!res;
      },
      err=>{
        alert("An error has occurred while sending the message");
        this.gif=false;
      }
    )
  }

  static changeLoading():void{
    setTimeout(()=>{
    },4000);
  }

  clearLocal(){
    sessionStorage.clear();
  }
}



export interface contact {
  message:string;
  name:string;
  email:string;
}
