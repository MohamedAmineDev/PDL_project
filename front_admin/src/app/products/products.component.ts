import { Component, OnInit } from '@angular/core';
import { FormProduct, Product } from '../models/Product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  fournisseurs: Array<Product> = [];
  displayLoading: any;
  modalButton: any;
  showErreur: any;
  addingFormDisplayed: any;
  updatingFormDisplayed: any;
  wantedCategory: FormProduct={} as FormProduct;
  askingToDelete: any;
  id: string = "";
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe(
      (data) => {
        console.log(data);
        let i = 0;
        while (i < data.length) {
          this.fournisseurs.push(data[i]);
          i++;
        }
      },
      (e) => {
        console.log(e);
      }
    );
  }
  startUpdating(_t22: number) {
    let p=this.fournisseurs[_t22];
    this.wantedCategory=new Product(p.id,p.label,p.quantity,p.price,p.imageLink,p.category.id);
    console.log(this.wantedCategory);
    this.updatingFormDisplayed=true;
  }
  prepareBeforeDelete(_t22: any) {
    this.askingToDelete = true;
    this.id = _t22;
  }

  closeLoading() {
    this.addingFormDisplayed = false;
    window.location.href = '/';
  }

  addFormConfiguration() {
    this.addingFormDisplayed = true;
  }

  closeDeleteAlert() {
    this.askingToDelete = false;
  }
  deleteFournisseur() {
    this.productService.deleteProduct(this.id).subscribe((data) => {
      console.log(data);
      window.location.href = "/manage_products";
    }, (e) => {
      console.log(e);
    })
  }

}
