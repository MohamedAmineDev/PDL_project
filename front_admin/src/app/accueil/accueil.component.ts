import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';
import { ProductService } from '../services/product.service';
import { SupplyService } from '../services/supply.service';
import { CommandService } from '../services/command.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
  nbP:number=0;
  nbS:number=0;
  nbCl:number=0;
  nbC:number=0;
  btnInfo: string = "See more";

  constructor(private productService: ProductService, private supplyService: SupplyService, private commandService: CommandService, private clientService: UserService) { 
    productService.getAllProducts().subscribe(
      (data)=>{
        this.nbP=data.length;
      },
      (e)=>{}
    );
  supplyService.getAllSupplies().subscribe(
      (data)=>{
        this.nbS=data.length;
      },
      (e)=>{}
    );
    commandService.getAllCommandsThatAreWaitingForPayment().subscribe(
      (data)=>{
        this.nbC=data.length;
      },
      (e)=>{}
    );
    clientService.getAllClients().subscribe(
      (data)=>{
        this.nbCl=data.length;
      },
      (e)=>{}
    );
  }

  ngOnInit(): void {
  }

}
