import { Component, OnInit } from '@angular/core';
import {AppComponent, User} from "../app.component";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private http:HttpClient, private router:Router) { }

  model:User={
    username:'',
    password:'',
    firstname:'',
    lastname:'',
    email:'',
    address:'',
    phone:0
  };

  present:boolean = null;
  usernameAvailability:string;
  fontColor:string;


  usernamePresent():void{
    this.fontColor='';
    let url = "http://localhost:8080/checkUserName";
    this.http.post<boolean>(url,this.model.username).subscribe(
      res=>{
        this.present=res;
        console.log(this.present);
        if(this.present) {
          this.fontColor="red";
          this.usernameAvailability = "UserName Already Taken";
        }
        else {
          this.fontColor="green";
          this.usernameAvailability = "Available";
        }
        this.router.navigate(['register']);
      }
    )
  }


  registerUser():void{
    let url = "http://localhost:8080/register";
    this.http.post<User>(url,this.model).subscribe(
      res=>{
        AppComponent.modelUser =res;
        this.router.navigate(['welcome']);
      },
      err=>{
        console.log([this.model]);
        alert("An error has occurred while Registering");
      }
    )
  }

  ngOnInit() {
  }

}
