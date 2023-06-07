import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountService } from './account.service';
import { Command } from '../models/Command';

@Injectable({
  providedIn: 'root'
})
export class CommandService {
  private url = "http://localhost:8090/api/command";
  constructor(private http: HttpClient, private user: AccountService) { }
  getAllCommandsThatAreWaitingForPayment(){
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<Command>>(`${this.url}/admin/commands_that_are_waiting_for_payment`,head);
  }
  getAllCommandsThatArePayedWaitingForDelivery(){
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<Command>>(`${this.url}/admin/commands_that_are_payed_waiting_for_delivery`,head);
  }
  getAllCommandsThatArePayedAndDelivered(){
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<Command>>(`${this.url}/admin/commands_that_are_payed_and_delivered`,head);
  }
  confirmPaymentForACommand(command:Command){
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.put(`${this.url}/admin/update/${command.id}`,true,head);
  }
  getAllCommands(){
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<Command>>(`${this.url}/commands`,head);
  }
}
