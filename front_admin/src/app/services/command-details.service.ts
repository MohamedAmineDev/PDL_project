import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Command } from '../models/Command';
import { AccountService } from './account.service';
import { CommandDetails } from '../models/CommandDetails';

@Injectable({
  providedIn: 'root'
})
export class CommandDetailsService {
  private url = "http://localhost:8090/api/command_product";
  constructor(private http: HttpClient, private user: AccountService) { }
  getDetails(command:Command){
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<CommandDetails>>(`${this.url}/details/${command.id}`,head);
  }
  storeTotalPrice(command:Command){
    sessionStorage.setItem("t_p",command.totalPrice+"");
  }
  getTotalPrice(){
    let totalPrice:any=sessionStorage.getItem("t_p");
    return  totalPrice;
  }
}
