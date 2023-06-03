import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AccountService } from './account.service';
import { Category } from '../models/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private url = "http://localhost:8090/api/category";
  constructor(private http: HttpClient, private user: AccountService) { }
  getAllCategories() {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.get<Array<Category>>(`${this.url}/categories`, head);
  }
  registerCategory(category: Category) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.post(`${this.url}/admin/addition`, category, head);
  }
  deleteCategory(id:string) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.delete(`${this.url}/admin/delete/${id}`, head);
  }
  updateCategory(category: Category) {
    const head = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.user.getToken(),
      }),
    };
    return this.http.put(`${this.url}/admin/update/${category.id}`, category,head);
  }
}
