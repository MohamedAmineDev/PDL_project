import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { CategoryService } from '../services/category.service';
import { FormProduct, Product } from '../models/Product';
import { Category } from '../models/Category';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  showModal: boolean = true;
  categories:Array<Category>=[]
  closeAlert() {
    this.showModal = false;
    window.location.href = "/manage_products";
  }
  addFournisseur() {
    let product=new Product(null,this.form.label,this.form.quantity,this.form.price,this.form.imageLink,this.form.categoryId);
    console.log(product);
    this.productService.registerProduct(product).subscribe(
      (data) => {
        console.log(data);
        window.location.href = "/manage_products";
      },
      (e) => {
        console.log(e);
      }
    );
  }
  form: FormProduct = {} as FormProduct;
  InputIsNotValid(name: any): any {
    return (
      name.invalid == true
      && (name.dirty == true ||
        name.touched == true));
  }
  emailIsNotValid(name: any): any {
    return (
      name.invalid == true
      && (name.dirty == true ||
        name.touched == true));
  }
  isNotValide(el1: any, el2: any) {
    return el1.invalid == true || el2.invalid == true;
  }
  buttonText: string = "Add";
  alertIsDisplayed: boolean = false;

  constructor(private categoryService: CategoryService ,private productService:ProductService) {
    this.categoryService.getAllCategories().subscribe(
      (data) => {
        console.log(data);
        let i = 0;
        while (i < data.length) {
          this.categories.push(data[i]);
          i++;
        }
      },
      (e) => {
        console.log(e);
      }
    );
   }

  ngOnInit(): void {
  }

}
