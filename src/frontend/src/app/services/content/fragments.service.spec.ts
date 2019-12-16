import { TestBed } from '@angular/core/testing';

import { FragmentsService } from './fragments.service';

describe('FragmentsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FragmentsService = TestBed.get(FragmentsService);
    expect(service).toBeTruthy();
  });
});
