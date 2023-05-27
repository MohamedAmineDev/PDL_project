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
    return this.http.post(`${this.url}/admin/addition`, product, head);
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
      price:price,
      quantity:quantity,
      id:product.id,
      category:{id:product.categoryId}
    };
    console.log("#!!!!!!!!!!!!!!");
    console.log(p);
    return this.http.put(`${this.url}/admin/update/${product.id}`, p,head);
  }
}
