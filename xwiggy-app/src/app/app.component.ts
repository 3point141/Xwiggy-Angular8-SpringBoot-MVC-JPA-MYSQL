import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



export class AppComponent {
  title = 'xwiggy-app';

  static total:number;

  static modelUser: User ={
    username:'',
    password:'',
    email:'',
    phone:0,
    firstname:'',
    lastname:'',
    address:'',
    merchant:null
  };

}
export interface User{
  username:string;
  password:string;
  firstname:string;
  lastname:string;
  email:string;
  address:string;
  phone:number;
  merchant:boolean;
}

