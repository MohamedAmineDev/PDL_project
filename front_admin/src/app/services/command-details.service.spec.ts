import { TestBed } from '@angular/core/testing';

import { CommandDetailsService } from './command-details.service';

describe('CommandDetailsService', () => {
  let service: CommandDetailsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommandDetailsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
