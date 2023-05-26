import { Component, OnInit } from '@angular/core';
import { LoginUser } from '../models/User';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: LoginUser = {} as LoginUser;
  buttonText: string = "Login";
  alertIsDisplayed: boolean = false;
  alertText: string = "The email or password is incorrect !";
  constructor(private accountService: AccountService) { }

  ngOnInit(): void {
    this.buttonText = "Login";
  }
  emailIsNotValid(name: any): any {
    return (
      name.invalid == true
      && (name.dirty == true ||
        name.touched == true));
  }
  passwordIsNotValid(name: any): any {
    return (
      name.invalid == true
      && (name.dirty == true ||
        name.touched == true));
  }
  isNotValide(email: any, password: any) {
    return email.invalid == true || password.invalid == true;
  }
  addUser() {
    this.buttonText = "Loading...";
    this.accountService.login(this.form).subscribe(
      (data) => {
        this.accountService.registerToken(data);
        alert("Login is a success !");
        console.log(this.accountService.getCurrentUser());
        window.location.href = "/home";
      },
      (e) => {
        console.log(e);
        this.alertIsDisplayed = true;
      }
    );
    this.buttonText = "Login";
  }
  closeAlert() {
    this.alertIsDisplayed = false;
  }
}
