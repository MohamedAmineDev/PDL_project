import { Component, OnInit } from '@angular/core';
import { CommandService } from '../services/command.service';
import { Command } from '../models/Command';
import { CommandDetailsService } from '../services/command-details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-commands-that-are-waiting-for-payment',
  templateUrl: './commands-that-are-waiting-for-payment.component.html',
  styleUrls: ['./commands-that-are-waiting-for-payment.component.css']
})
export class CommandsThatAreWaitingForPaymentComponent implements OnInit {
  commands: Array<Command> = [];
  showModal: boolean = false;
  wantedCommand: Command = {} as Command;
  startUpdating(_t22: number) {
    this.commandDetailsService.storeTotalPrice(this.commands[_t22]);
    this.router.navigate(["/command_details/"+this.commands[_t22].id]);
  }
  prepareBeforeDelete(_t20: number) {
    this.wantedCommand= this.commands[_t20];
    this.showModal = true;
    
  }
  closeModal() {
    this.showModal = false;
  }
  confirmCommand(){
    this.commandService.confirmPaymentForACommand(this.wantedCommand).subscribe(
      (data) => {
        console.log(data);
        window.location.href = "/manage_waiting_for_payment_commands";
      },
      (e) => {
        console.log(e);
      }
    );
  }
  constructor(private commandService: CommandService,private commandDetailsService:CommandDetailsService,private router: Router) {
    commandService.getAllCommandsThatAreWaitingForPayment()
      .subscribe(
        (data) => {
          let i = 0;
          while (i < data.length) {
            this.commands.push(data[i]);
            i++;
          }
        },
        (e) => {
          console.log(e);
        }
      );
  }

  ngOnInit(): void {
  }

}
