import { Component, OnInit } from '@angular/core';
import { SupplyProduct } from '../models/Supply';
import { ActivatedRoute } from '@angular/router';
import { SupplyService } from '../services/supply.service';

@Component({
  selector: 'app-supply-details',
  templateUrl: './supply-details.component.html',
  styleUrls: ['./supply-details.component.css']
})
export class SupplyDetailsComponent implements OnInit {
  details:Array<SupplyProduct>=[];
totalPrice: any;

  constructor(private route: ActivatedRoute,private supplyDetailsService:SupplyService) {
    let id=this.route.snapshot.paramMap.get('id');
    this.supplyDetailsService.getDetails(id).subscribe(
      (data)=>{
        let i=0;
        while(i<data.length){
          this.details.push(data[i]);
          i++;
        }
      },
      (e)=>{
        console.log(e);
      }
    );
    this.totalPrice=this.supplyDetailsService.getTotalPrice();
   }

  ngOnInit(): void {
  }

}
