import { Component, OnInit } from '@angular/core';
import { NgModel } from '@angular/forms';
import { Category } from '../models/Category';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {
  showModal: boolean = true;
  closeAlert() {
    this.showModal = false;
  }
  addFournisseur() {
    this.categoryService.registerCategory(this.form).subscribe(
      (data)=>{
        console.log(data);
      },
      (e)=>{
        console.log(e);
      }
    );
  }
  form: Category = {} as Category;
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

  constructor(private categoryService:CategoryService) { }

  ngOnInit(): void {
  }

}
