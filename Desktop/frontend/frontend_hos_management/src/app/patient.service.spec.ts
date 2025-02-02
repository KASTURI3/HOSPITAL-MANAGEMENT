import { TestBed } from '@angular/core/testing';

import { PaitentService } from './PatientService';

describe('PaitentService', () => {
  let service: PaitentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PaitentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
