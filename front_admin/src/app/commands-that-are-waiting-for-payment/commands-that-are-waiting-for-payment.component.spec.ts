import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandsThatAreWaitingForPaymentComponent } from './commands-that-are-waiting-for-payment.component';

describe('CommandsThatAreWaitingForPaymentComponent', () => {
  let component: CommandsThatAreWaitingForPaymentComponent;
  let fixture: ComponentFixture<CommandsThatAreWaitingForPaymentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CommandsThatAreWaitingForPaymentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CommandsThatAreWaitingForPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
