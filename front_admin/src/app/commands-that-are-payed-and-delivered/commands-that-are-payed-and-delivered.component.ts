import { Component, OnInit } from '@angular/core';
import { Command } from '../models/Command';
import { CommandService } from '../services/command.service';
import { CommandDetailsService } from '../services/command-details.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-commands-that-are-payed-and-delivered',
  templateUrl: './commands-that-are-payed-and-delivered.component.html',
  styleUrls: ['./commands-that-are-payed-and-delivered.component.css']
})
export class CommandsThatArePayedAndDeliveredComponent implements OnInit {
commands: Array<Command>=[];
startUpdating(_t22: number) {
  this.commandDetailsService.storeTotalPrice(this.commands[_t22]);
  this.router.navigate(["/command_details/"+this.commands[_t22].id]);
}
prepareBeforeDelete(_t22: number) {
throw new Error('Method not implemented.');
}

  constructor(private commandService: CommandService,private commandDetailsService:CommandDetailsService,private router: Router) { 
    commandService.getAllCommandsThatArePayedAndDelivered()
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
