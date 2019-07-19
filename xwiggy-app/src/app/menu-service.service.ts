import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MenuServiceService {

  constructor(public HttpClient: HttpClient) { }
  public getItems():any{
    let url = "http://172.20.10.5:8080/menu";
    return this.HttpClient.get(url);
  }
}
