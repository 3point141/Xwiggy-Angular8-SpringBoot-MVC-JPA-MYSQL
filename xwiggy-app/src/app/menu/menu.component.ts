import {ApplicationModule, Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Observable} from "rxjs";
import {MenuServiceService} from "../menu-service.service";
import {AppComponent} from "../app.component";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  model:menu[];
  total:number=0;

  modalCart:cart={
    quantity1:0,
    quantity2:0,
    quantity3:0
  };

  constructor(private http:HttpClient, private router:Router,private menuService:MenuServiceService) { }

  ngOnInit() {
    this.getItems();
  }

  getItems():void{
    this.menuService.getItems().subscribe((men: any[]) => {
      this.model = men;
    })
  }

  getTotal():void{
    let url = "http://localhost:8080/cart";
    this.http.post<number>(url,this.modalCart).subscribe(
      res=>{
        AppComponent.total=res;
        this.total=res;
      },
      err=>{
        alert("Error adding items to cart");
      }
    )

  }
}

export interface menu {
  id:string;
  item:string;
  price:number;
  quantity:number;
}

export interface cart {
  quantity1:number;
  quantity2:number;
  quantity3:number;
}
