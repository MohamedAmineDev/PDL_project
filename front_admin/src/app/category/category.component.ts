import { Component, OnInit } from '@angular/core';
import { Category } from '../models/Category';
import { CategoryService } from '../services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
fournisseurs: Array<Category>=[];
displayLoading: any;
modalButton: any;
showErreur: any;
addingFormDisplayed: any;
updatingFormDisplayed: any;
wantedFournisseur: any;
askingToDelete: any;
  constructor(private categoryService:CategoryService) { }

  ngOnInit(): void {
    this.categoryService.getAllCategories().subscribe(
      (data)=>{
        console.log(data);
        let i=0;
        while(i<data.length){
          this.fournisseurs.push(data[i]);
          i++;
        }
      },
      (e)=>{
        console.log(e);
      }
    );
  }
  startUpdating(_t22: number) {
    throw new Error('Method not implemented.');
    }
    prepareBeforeDelete(_t22: number) {
    throw new Error('Method not implemented.');
    }
    
    closeLoading() {
    this.addingFormDisplayed=false;
    }
    
    addFormConfiguration() {
    this.addingFormDisplayed=true;
    }
    
    closeDeleteAlert() {
    throw new Error('Method not implemented.');
    }
    deleteFournisseur() {
    throw new Error('Method not implemented.');
    }
    

}
