import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';
import { CurrentUser } from '../models/User';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  loggedIn: boolean=false;
  user: CurrentUser={} as CurrentUser;
  isdisPlayed: boolean=false;

  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
    this.loggedIn=this.accountService.isAuthenticated();
    this.user=this.accountService.getCurrentUser();
  }
  logout() {
    this.accountService.removeToken();
    window.location.href = "/login";
  }
  displayOptions() {
    this.isdisPlayed=true;
  }
  hideOptions() {
    this.isdisPlayed=false;
  }
}
