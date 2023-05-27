import { Component, Input, OnInit } from '@angular/core';
import { CategoryService } from '../services/category.service';
import { Category } from '../models/Category';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit {
  @Input() showModal: boolean = {} as boolean;
  @Input() categoryToUpdate: Category = {} as Category;
  closeAlert() {
    this.showModal = false;
    window.location.href = "/manage_categories";
  }
  addFournisseur() {
    this.categoryService.updateCategory(this.form).subscribe(
      (data) => {
        console.log(data);
        window.location.href = "/manage_categories";
      },
      (e) => {
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
  buttonText: string = "Edit";
  alertIsDisplayed: boolean = false;

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.form=this.categoryToUpdate;
  }


}
