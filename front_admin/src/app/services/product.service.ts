import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountService } from './account.service';
import { FormProduct, Product } from '../models/Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private url = "http://localhost:8090/api/product";
  constructor(private http: HttpClient, private user: AccountService) { }
  getAllProducts() {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<Product>>(`${this.url}/products`, head);
  }
  registerProduct(product: Product) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    const p={
      id:product.id,
      label:product.label,
      quantity: parseInt(product.quantity+""),
      category:product.category,
      price:parseFloat(product.price+""),
      imageLink:product.imageLink
    }
    return this.http.post(`${this.url}/admin/addition`, p, head);
  }
  deleteProduct(id:string) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.delete(`${this.url}/admin/delete/${id}`, head);
  }
  updateProduct(product: FormProduct) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    let price:number=product.price;
    let quantity:number=product.quantity+0;
    const p={
      label:product.label,
      price:parseFloat(product.price+""),
      quantity:parseInt(product.quantity+""),
      id:product.id,
      category:{id:product.categoryId},
      imageLink:product.imageLink
    };
    //console.log("#!!!!!!!!!!!!!!");
    //console.log(p);
    return this.http.put(`${this.url}/admin/update/${product.id}`, p,head);
  }
}
