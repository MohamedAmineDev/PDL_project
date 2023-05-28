import { Component, OnInit } from '@angular/core';
import { Command } from '../models/Command';

@Component({
  selector: 'app-commands-that-are-payed-and-delivered',
  templateUrl: './commands-that-are-payed-and-delivered.component.html',
  styleUrls: ['./commands-that-are-payed-and-delivered.component.css']
})
export class CommandsThatArePayedAndDeliveredComponent implements OnInit {
commands: Array<Command>=[];
startUpdating(_t22: number) {
throw new Error('Method not implemented.');
}
prepareBeforeDelete(_t22: number) {
throw new Error('Method not implemented.');
}

  constructor() { }

  ngOnInit(): void {
  }

}
