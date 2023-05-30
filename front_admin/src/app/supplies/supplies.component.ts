import { Component, OnInit } from '@angular/core';
import { Supply } from '../models/Supply';
import { SupplyService } from '../services/supply.service';
import { Product } from '../models/Product';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-supplies',
  templateUrl: './supplies.component.html',
  styleUrls: ['./supplies.component.css']
})
export class SuppliesComponent implements OnInit {
supplies: Array<Supply>=[];
products:Array<Product>=[];
startUpdating(_t23: number) {
this.supplyService.storeTotalPrice(this.supplies[_t23]);
this.router.navigate(["/supply_details/"+this.supplies[_t23].id]);
}
prepareBeforeDelete(arg0: any) {
  this.wantedSupply=this.supplies[arg0];
  this.askingToDelete=true;
}
displayLoading: any;
closeLoading() {
throw new Error('Method not implemented.');
}
modalButton: any;
showErreur: any;
addFormConfiguration() {
this.addingFormDisplayed=true;
}
wantedSupply:Supply={} as Supply;
addingFormDisplayed: boolean=false;
updatingFormDisplayed: boolean=false;
askingToDelete: any;
closeDeleteAlert() {
this.askingToDelete=false;
}
deleteFournisseur() {
  this.supplyService.deleteSupply(this.wantedSupply.id).subscribe(
    (data)=>{
      console.log(data);
      window.location.href = "/manage_supplies";
    },
    (e)=>{
      console.log(e);
    }
  );  
}
  constructor(private supplyService:SupplyService,private productService:ProductService,private router: Router) {
    this.supplyService.getAllSupplies().subscribe(
      (data)=>{
        console.log(data);
        let i=0;
        while(i<data.length){
          this.supplies.push(data[i]);
          i++;
        }
      },
      (e)=>{
        console.log(e);
      }
    );
    this.productService.getAllProducts().subscribe(
      (data)=>{
        //console.log(data);
        let i=0;
        while(i<data.length){
          this.products.push(data[i]);
          i++;
        }
      },
      (e)=>{
        console.log(e);
      }
    );
   }

  ngOnInit(): void {
  }

}
