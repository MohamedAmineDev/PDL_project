import { Component, OnInit } from '@angular/core';
import { CommandService } from '../services/command.service';
import { Command } from '../models/Command';

@Component({
  selector: 'app-commands-that-are-waiting-for-payment',
  templateUrl: './commands-that-are-waiting-for-payment.component.html',
  styleUrls: ['./commands-that-are-waiting-for-payment.component.css']
})
export class CommandsThatAreWaitingForPaymentComponent implements OnInit {
commands: Array<Command>=[];
startUpdating(_t20: number) {
throw new Error('Method not implemented.');
}
prepareBeforeDelete(_t20: number) {
throw new Error('Method not implemented.');
}

  constructor(private commandService:CommandService) {
    commandService.getAllCommandsThatAreWaitingForPayment()
    .subscribe(
      (data)=>{
        let i=0;
        while(i<data.length){
          this.commands.push(data[i]);
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
