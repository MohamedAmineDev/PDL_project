import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountService } from './account.service';
import { Client } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url = "http://localhost:8090/api/user";
  constructor(private http: HttpClient, private user: AccountService) { }
  getAllClients() {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<Client>>(`${this.url}/clients`, head);
  }
  lockClient(client: Client) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    const c={
      email:client.email,
      nom:client.nom,
      prenom:client.prenom
    };
    return this.http.put(`${this.url}/admin/lock_user`, c,head);
  }
  unlockClient(client: Client) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    const c={
      email:client.email,
      nom:client.nom,
      prenom:client.prenom
    };
    return this.http.put(`${this.url}/admin/unlock_user`, c,head);
  }
}
