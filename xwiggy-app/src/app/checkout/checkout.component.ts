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
  total:string;
  cardNumberVal:boolean=null;
  monthVal:boolean=null;
  yearVal:boolean=null;
  cvvVal:boolean=null;
  nameOnCardVal:boolean=null;

  cardNumber:string;
  month:number;
  year:number;
  cvv:number;
  nameOnCard:string;


  ngOnInit() {
    if (sessionStorage.getItem("userData") == null) {
      this.router.navigate(['login']);
    }
    this.total=sessionStorage.getItem('total');
  }

  validCard(){
    if(this.cardNumber.length==0){
      this.cardNumberVal=null;
    }
    if(this.cardNumber.length>0 && this.cardNumber.length<16){
      this.cardNumberVal=false;
    }else if(this.cardNumber.length==16){
      let matcher = new RegExp('^(?=.*[0-9])(?=.{16})');
      this.cardNumberVal=matcher.test(this.cardNumber);
    }
  }

  validMonth(){
    this.monthVal = this.month >= 1 && this.month <= 12;
    console.log(this.monthVal);
  }

  validCvv(){
    this.cvvVal = this.cvv >=100 && this.cvv <= 999
  }

  validName(){
    this.nameOnCardVal=this.nameOnCard.length>=4 && this.nameOnCard.length<=10;
  }

  message:string='';

  changeDB():void{
    if(this.cardNumberVal&&this.monthVal&&this.yearVal&&this.cvvVal&&this.nameOnCardVal) {
      let url = "http://localhost:8080/changeDB";
      this.http.get(url).subscribe(
        res => {
          console.log("DB Updated");
        },
        err => {
          alert('Failed to update DB');
        }
      )
    }else{
      if(!this.cardNumberVal)
        this.message+="Card Number Not Valid \n";
      if(!this.monthVal)
        this.message+="Enter A Valid Month \n";
      if(!this.yearVal)
        this.message+="Enter A Valid Year\n";
      if(!this.cvvVal)
        this.message+="Enter A Valid CVV \n";
      if(!this.nameOnCardVal)
        this.message+="Enter A Valid Name";

      alert(this.message);
      this.message='';
      this.router.navigate(['checkout']);
    }
  }

  validYear() {
    this.yearVal= this.year>=19 && this.year<=99;
    console.log(this.yearVal);
  }


}
