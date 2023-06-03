import { Component, OnInit } from '@angular/core';
import { Product } from '../models/Product';
import { Client } from '../models/User';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  clients: Array<Client> = [];
  startUpdating(_t22: number) {
    let wantedClient = this.clients[_t22];
    this.clientService.unlockClient(wantedClient).subscribe(
      (data) => {
        console.log(data);
        window.location.href = "/manage_users";
      }
      ,
      (e) => {
        console.log(e);
      }
    );
  }
  prepareBeforeDelete(arg0: any) {
    let wantedClient = this.clients[arg0];
    this.clientService.lockClient(wantedClient).subscribe(
      (data) => {
        console.log(data);
        window.location.href = "/manage_users";
      }
      ,
      (e) => {
        console.log(e);
      }
    );
  }
  displayLoading: any;
  closeLoading() {
    throw new Error('Method not implemented.');
  }
  modalButton: any;
  constructor(private clientService: UserService) {
    clientService.getAllClients().subscribe(
      (data) => {
        let i = 0;
        while (i < data.length) {
          this.clients.push(data[i]);
          i++;
        }
      },
      (e) => {
        console.log(e);
      }
    );
  }

  ngOnInit(): void {
    console.log(this.clients);
  }

}
