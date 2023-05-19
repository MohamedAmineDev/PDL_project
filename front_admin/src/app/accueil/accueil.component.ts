import { Component, OnInit } from '@angular/core';
import { AccountService } from '../services/account.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {
produits =[];
clients =[];
fournisseurs=[];
commandes=[];
btnInfo:string="See more";

  constructor() { }

  ngOnInit(): void {
  }

}
