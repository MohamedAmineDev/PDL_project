import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandsThatArePayedAndDeliveredComponent } from './commands-that-are-payed-and-delivered.component';

describe('CommandsThatArePayedAndDeliveredComponent', () => {
  let component: CommandsThatArePayedAndDeliveredComponent;
  let fixture: ComponentFixture<CommandsThatArePayedAndDeliveredComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommandsThatArePayedAndDeliveredComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CommandsThatArePayedAndDeliveredComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
