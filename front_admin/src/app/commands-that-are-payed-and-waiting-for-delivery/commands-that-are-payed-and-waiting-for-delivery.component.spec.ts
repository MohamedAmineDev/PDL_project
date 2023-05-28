import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandsThatArePayedAndWaitingForDeliveryComponent } from './commands-that-are-payed-and-waiting-for-delivery.component';

describe('CommandsThatArePayedAndWaitingForDeliveryComponent', () => {
  let component: CommandsThatArePayedAndWaitingForDeliveryComponent;
  let fixture: ComponentFixture<CommandsThatArePayedAndWaitingForDeliveryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommandsThatArePayedAndWaitingForDeliveryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CommandsThatArePayedAndWaitingForDeliveryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
