import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountService } from './account.service';
import { Supply, SupplyProduct } from '../models/Supply';
import { Product } from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class SupplyService {
  private url = "http://localhost:8090/api/supply";
  private sessionName = "basket";
  constructor(private http: HttpClient, private user: AccountService) { }
  getAllSupplies() {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<Supply>>(`${this.url}/admin/supplies`, head);
  }
  registerSupply() {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    let supply: Supply = {} as Supply;
    supply.supplyProductList = this.getBasket();
    return this.http.post(`${this.url}/admin/addition`, supply, head);
  }
  deleteSupply(id: string) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.delete(`${this.url}/admin/delete/${id}`, head);
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
    let basket: Array<SupplyProduct> = [];
    while (i < items.length) {
      let v = items[i].split(" ");
      let supplyProduct: SupplyProduct = {} as SupplyProduct;
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
  getDetails(id: any) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<SupplyProduct>>(`http://localhost:8090/api/supply_product/admin/supply/details/${id}`, head);
  }
  storeTotalPrice(supply: Supply) {
    sessionStorage.setItem("t_p", supply.totalPrice + "");
  }
  getTotalPrice() {
    let totalPrice: any = sessionStorage.getItem("t_p");
    return totalPrice;
  }
}
