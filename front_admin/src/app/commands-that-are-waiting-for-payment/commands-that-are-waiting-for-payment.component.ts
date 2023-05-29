import { Component, OnInit } from '@angular/core';
import { CommandService } from '../services/command.service';
import { Command } from '../models/Command';

@Component({
  selector: 'app-commands-that-are-waiting-for-payment',
  templateUrl: './commands-that-are-waiting-for-payment.component.html',
  styleUrls: ['./commands-that-are-waiting-for-payment.component.css']
})
export class CommandsThatAreWaitingForPaymentComponent implements OnInit {
  commands: Array<Command> = [];
  showModal: boolean = false;
  wantedCommand: Command = {} as Command;
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
  constructor(private commandService: CommandService) {
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
