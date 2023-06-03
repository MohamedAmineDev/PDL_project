import { Component, Input, OnInit } from '@angular/core';
import { Product } from '../models/Product';
import { SupplyService } from '../services/supply.service';

@Component({
  selector: 'app-add-supply',
  templateUrl: './add-supply.component.html',
  styleUrls: ['./add-supply.component.css']
})
export class AddSupplyComponent implements OnInit {
askingToDelete: any;
closeDeleteAlert() {
throw new Error('Method not implemented.');
}
deleteFournisseur() {
throw new Error('Method not implemented.');
}
addsupply() {
  alert("mmmmmmmmmmm");
this.supplyService.registerSupply().subscribe(
  (data)=>{
    console.log(data);
    this.supplyService.resetBasket();
  },
  (e)=>{
    console.log(e);
  }
);
}
  updateBakset(_t24: number) {
    let wantedProduct = this.products[_t24];
    alert("Hello !");

    let quantity: number = parseInt(prompt(`Put the quantity you want to supply for ${wantedProduct.label}`) + "");
    if (quantity > 0) {
      this.supplyService.putInTheBasket(wantedProduct, quantity);
      this.basket=this.supplyService.getBasket();
    }
    else {
      alert("Quantity is not a number !");
    }
  }
  startUpdating(_t28: number) {
    throw new Error('Method not implemented.');
  }
  prepareBeforeDelete(arg0: any) {
    throw new Error('Method not implemented.');
  }
  showModal: boolean = true;
  @Input() products: Array<Product> = [];
  basket: any;
  closeAlert() {
    this.showModal = false;
  }
  alertIsDisplayed: boolean = false;

  constructor(private supplyService: SupplyService) { 
    this.basket=supplyService.getBasket();
  }

  ngOnInit(): void {
    console.log(this.products);
  }

}
