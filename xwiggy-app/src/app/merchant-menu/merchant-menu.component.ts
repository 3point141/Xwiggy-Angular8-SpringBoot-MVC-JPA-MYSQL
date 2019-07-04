import { Component, OnInit } from '@angular/core';
import {cart, menu} from "../menu/menu.component";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {MenuServiceService} from "../menu-service.service";


@Component({
  selector: 'app-merchant-menu',
  templateUrl: './merchant-menu.component.html',
  styleUrls: ['./merchant-menu.component.css']
})
export class MerchantMenuComponent implements OnInit {

  model:menu[];

  modalCart:cart={
    quantity1:0,
    quantity2:0,
    quantity3:0
  };

  constructor(private http:HttpClient, private router:Router,private menuService:MenuServiceService) { }

  ngOnInit() {
    if (sessionStorage.getItem("userData") == null) {
      this.router.navigate(['login']);
    }
    this.getItems();
  }

  clearLocal(){
    sessionStorage.clear();
  }

  getItems():void{
    this.menuService.getItems().subscribe((men: any[]) => {
      this.model = men;
    })
  }

  getTotal():void{
    let url = "http://192.168.33.10:8080/addToCart";
    this.http.post<number>(url,this.modalCart).subscribe(
      res=>{
        this.ngOnInit();
      },
      err=>{
        alert("Error adding items to cart");
      }
    )

  }
}

