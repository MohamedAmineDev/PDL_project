import { Component, Input, OnInit } from '@angular/core';
import { Category } from '../models/Category';
import { FormProduct, Product } from '../models/Product';
import { CategoryService } from '../services/category.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  @Input() showModal: boolean = {} as boolean;
  @Input() productToUpdate: FormProduct = {} as FormProduct;
  categories:Array<Category>=[]
  closeAlert() {
    this.showModal = false;
    window.location.href = "/manage_products";
  }
  addFournisseur() {
    console.log(this.form);
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
  buttonText: string = "Edit";
  alertIsDisplayed: boolean = false;

  constructor(private categoryService: CategoryService ,private productService:ProductService) {
    //this.form=this.productToUpdate;
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
    this.form=this.productToUpdate;
    console.log(this.productToUpdate);
  }
}
