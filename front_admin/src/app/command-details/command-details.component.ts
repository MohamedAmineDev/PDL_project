import { Component, OnInit } from '@angular/core';
import { CommandDetails } from '../models/CommandDetails';
import { ActivatedRoute } from '@angular/router';
import { CommandDetailsService } from '../services/command-details.service';
import { Command } from '../models/Command';

@Component({
  selector: 'app-command-details',
  templateUrl: './command-details.component.html',
  styleUrls: ['./command-details.component.css']
})
export class CommandDetailsComponent implements OnInit {
  details:Array<CommandDetails>=[];
  totalPrice:any;
  constructor(private route: ActivatedRoute,private commandDetailsService:CommandDetailsService) {
    let wantedCommand={} as Command;
    wantedCommand.id=this.route.snapshot.paramMap.get('id');
    this.commandDetailsService.getDetails(wantedCommand).subscribe(
      (data)=>{
        console.log(data);
        let i=0;
        while(i<data.length){
          this.details.push(data[i]);
          i++;
        }
      }
      ,(e)=>{
        console.log(e);
      }
    );
    this.totalPrice=this.commandDetailsService.getTotalPrice();
   }

  ngOnInit(): void {
  }

}
