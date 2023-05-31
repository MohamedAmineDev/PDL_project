import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountService } from './account.service';
import { Command } from '../models/Command';
import * as CryptoJS from 'crypto-js';
import { Product } from '../models/Product';
import { CommandProduct, SupplyProduct } from '../models/Supply';
@Injectable({
  providedIn: 'root'
})
export class BasketService {
  private url = "http://localhost:8090/api/command";
  private sessionName:any;
  private secretKey:any;
  constructor(private http: HttpClient, private user: AccountService) { 
    let u=user.getCurrentUser();
    this.secretKey= sessionStorage.getItem(`${u.identity}`);
    if(this.secretKey==null){
     this.secretKey=crypto.randomUUID();
     sessionStorage.setItem(`${u.identity}`,this.secretKey);
    }
    this.sessionName=CryptoJS.AES.encrypt(u.email,this.secretKey.trim()).toString();
  }
  addCommand(){
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };

    return this.http.post(`${this.url}/client/addition/${false}`,head);
  }
  putInTheBasket(product: Product, quantity: number) {
    let currentBasket = sessionStorage.getItem(this.sessionName);
    if (currentBasket == null) {
      let currentProduct = `${product.id} ${quantity} ${product.label}`;
      sessionStorage.setItem(this.sessionName, currentProduct);
    }
    else {
      //let currentProducts=currentBasket.split("||");
      let newProduct = `||${product.id} ${quantity} ${product.label}`;
      currentBasket = `${currentBasket}${newProduct}`;
      sessionStorage.setItem(this.sessionName, currentBasket);
    }
  }
  getBasket() {
    let currentBasket: string = sessionStorage.getItem(this.sessionName) + "";
    let items = currentBasket.split("||");
    let i = 0;
    let basket: Array<CommandProduct> = [];
    while (i < items.length) {
      let v = items[i].split(" ");
      let supplyProduct: CommandProduct = {} as CommandProduct;
      supplyProduct.quantity = parseInt(v[1]);
      supplyProduct.product = { id: v[0], label: v[2] }
      basket.push(supplyProduct);
      i++;
    }
    return basket;
  }
  resetBasket() {
    sessionStorage.removeItem(this.sessionName);
  }
}
